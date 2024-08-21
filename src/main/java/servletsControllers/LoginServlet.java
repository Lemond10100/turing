package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.User;
import services.CookieUtil;
import services.GestioneRubricaService;
import org.mindrot.jbcrypt.BCrypt;
import services.UserService;

import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Assume UserService is a class you've implemented to handle user authentication
        UserService userService = new UserService();
        User user = userService.authenticate(username, password);

        if (user != null) {
            // Create a session for the user
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getUsername());

            // Log session details
            System.out.println("Session ID: " + session.getId());
            System.out.println("Session Creation Time: " + new java.util.Date(session.getCreationTime()));
            System.out.println("User stored in session: " + session.getAttribute("user"));

            // Use the CookieUtil class to create and add the session cookie
            CookieUtil.createSessionCookie(response, session.getId());

            // Log the cookie details
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    System.out.println("Cookie Name: " + cookie.getName());
                    System.out.println("Cookie Value: " + cookie.getValue());
                    System.out.println("Cookie Max Age: " + cookie.getMaxAge());
                    System.out.println("Cookie HttpOnly: " + cookie.isHttpOnly());
                    System.out.println("Cookie Secure: " + cookie.getSecure());
                }
            } else {
                System.out.println("No cookies found in the request.");
            }

            System.out.println("siamo in redirection verso getPersona");
            response.sendRedirect("getPersona");  // Supponendo che "getPersona" sia il path corretto
        } else {
            // Authentication failed, redirect back to llogin with error message
            response.sendRedirect("login.jsp?error=1");
        }
    }
}

