package servletsControllers;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.DatabaseConfigurationService;


public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dbHost = request.getParameter("dbHost");
        String dbPort = request.getParameter("dbPort");
        String dbUrl = request.getParameter("dbUrl");
        String dbUser = request.getParameter("dbUser");
        String dbPassword = request.getParameter("dbPassword");
        DatabaseConfigurationService checkDbCredentials = new DatabaseConfigurationService();
        boolean success = checkDbCredentials.findDbByCredentials(dbHost, dbPort, dbUrl, dbUser, dbPassword);

        if (success) {
            response.sendRedirect("signup.jsp");  // or any other success page
        } else {
            response.sendRedirect("index.jsp?error=true");  // Provide error feedback
        }
    }
}
