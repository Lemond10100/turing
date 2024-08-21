package servletsControllers;

import model.Persona;
import services.GestioneRubricaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.UserService;

import java.io.IOException;
import java.util.List;
import model.User;
import services.CookieUtil;


public class GetPersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the existing session, but don't create a new one if it doesn't exist
        HttpSession session = request.getSession(false);

        // Check if the session exists and the user is authenticated
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("Session is invalid or user not authenticated. Redirecting to login.");
            response.sendRedirect("login.jsp?error=SessionExpired");
            return;
        }

        // Log session details for debugging purposes
        System.out.println("Session ID in getPersona: " + session.getId());
        String username = (String) session.getAttribute("user");
        if (username != null) {
            System.out.println("User retrieved from session in getPersona: " + username);
        }

        // Business logic to get the persona list
        GestioneRubricaService gestioneRubricaService = new GestioneRubricaService();
        List<Persona> listaPersonas = gestioneRubricaService.getAllPersonasForUser(username);
        request.setAttribute("personas", listaPersonas);
        // Forward to the JSP page or render response
        request.getRequestDispatcher("/lista.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // If there's any POST logic for getPersona, handle it here, or simply forward to doGet
        doGet(request, response);
    }
}

