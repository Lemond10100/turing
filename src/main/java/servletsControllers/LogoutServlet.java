package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutServlet() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Retrieve the session if it exists
        if (session != null) {
            session.invalidate(); // Invalidate the session to remove all attributes

            // Clear the JSESSIONID cookie
            Cookie sessionCookie = new Cookie("JSESSIONID", null);
            sessionCookie.setMaxAge(0); // Set the cookie's max age to 0 to delete it
            sessionCookie.setPath(request.getContextPath()); // Ensure the path matches the cookie's path
            response.addCookie(sessionCookie);
        }
        response.sendRedirect("login.jsp"); // Redirect to the login page
    }
}
