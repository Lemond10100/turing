package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.GestioneRubricaService;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public LoginServlet(){}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        GestioneRubricaService service = new GestioneRubricaService();
        String storedHashedPassword = service.getPasswordForUser(username);

        if (storedHashedPassword != null && BCrypt.checkpw(password, storedHashedPassword)) {
            // Login successful, redirect to persona list
            response.sendRedirect("lista.jsp");
            System.out.println("loginservlet,doPost_if_");
        } else {
            // Login failed, redirect back to login page with an error
            response.sendRedirect("login.jsp?error=Invalid credentials");
            System.out.println("elseeeeeeeeeeee");
        }
    }
}
