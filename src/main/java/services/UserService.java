package services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Persona;

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
    private final String url = "jdbc:mysql://localhost:3306/rubrica";
    private final String userdb = "rubrica";
    private final String password = "Dom101006566!";




    public UserService(){}

    public void setCurrentUserIntoSession(HttpServletRequest request,String username){
        System.out.println("siamo in service:setCurrentUserIntoSession ");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

    }


    public String getCurrentUserFromSession(HttpSession session){
         return(String)session.getAttribute("username");
    }

}






