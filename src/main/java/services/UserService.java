package services;

import config.DatabaseConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Persona;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Correct driver class for newer MySQL versions
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }
    private Connection getConnection() throws SQLException {
        // Utilizza le impostazioni dal DatabaseConfig per stabilire una connessione
        return DriverManager.getConnection(
                DatabaseConfig.getDbUrl(),
                DatabaseConfig.getDbUser(),
                DatabaseConfig.getDbPassword()
        );
    }




    public UserService(){}
    //deprecated
    public void setCurrentUserIntoSession(HttpServletRequest request,String username){
        System.out.println("siamo in service:setCurrentUserIntoSession ");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

    }


    public String getCurrentUserFromSession(HttpSession session){
         return(String)session.getAttribute("username");
    }

    public User authenticate(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");
                // Use BCrypt to check the password
                if (BCrypt.checkpw(password, storedHashedPassword)) {
                    // If the password matches, return a User object
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(storedHashedPassword); // store hashed password
                    // You can set other user properties here, if any
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // return null if authentication fails
    }


    public boolean userExists(User user) {
        // Check if the username already exists in the database
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addUser(User user) {
        // Add the new user to the database
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}






