package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.GestioneRubricaService;
import services.UserService;

import java.io.IOException;

public class DeletePersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("siamo in DeletePersonaServlet, doPost");

        // Retrieve the session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("Session is invalid or user not authenticated. Redirecting to login.");
            response.sendRedirect("login.jsp?error=SessionExpired");
            return;
        }

        // Get the username from the session
        String username = (String) session.getAttribute("user");

        // Retrieve the persona ID from the request
        Integer id = Integer.parseInt(request.getParameter("id"));

        // Remove the persona using the service
        GestioneRubricaService service = new GestioneRubricaService();
        service.rimuoviPersona(id, username);

        // Redirect to the persona list
        response.sendRedirect("getPersona");
    }
}
