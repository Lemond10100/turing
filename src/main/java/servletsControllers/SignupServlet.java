package servletsControllers;
import org.mindrot.jbcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import services.GestioneRubricaService;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // Check if username already exists
        GestioneRubricaService service = new GestioneRubricaService();
        if (service.userExists(user)) {
            // Redirect back to signup with an error message
            response.sendRedirect("signup.jsp?error=Username already exists");
        } else {
            // Hash the password for security
            String hashedPassword = hashPassword(password);
            user.setPassword(hashedPassword);
            // Add user to the database
            service.addUser(user);

            // Redirect to login page
            response.sendRedirect("login.jsp");
        }
    }

    private String hashPassword(String password) {
        // Implement your password hashing logic here (e.g., using BCrypt)
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
