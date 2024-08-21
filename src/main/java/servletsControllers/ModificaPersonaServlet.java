package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Persona;
import services.GestioneRubricaService;

import java.io.IOException;

public class ModificaPersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session, but don't create a new one if it doesn't exist
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("Session is invalid or user not authenticated. Redirecting to login.");
            response.sendRedirect("login.jsp?error=SessionExpired");
            return;
        }

        // Get the username from the session
        String username = (String) session.getAttribute("user");

        // Retrieve form data
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String indirizzo = request.getParameter("indirizzo");
        String telefono = request.getParameter("telefono");
        int eta = Integer.parseInt(request.getParameter("eta"));

        // Create a new Persona object
        Persona persona = new Persona(id, nome, cognome, indirizzo, telefono, eta, username);

        // Use the service to handle the business logic
        GestioneRubricaService service = new GestioneRubricaService();

        // Before proceeding with the modification, check if the phone number is already used
        boolean isDuplicate = service.isPhoneNumberExistExceptCurrent(telefono, id, username);
        if (isDuplicate) {
            request.setAttribute("errorMessage", "Il numero di telefono è già utilizzato da un'altra persona.");
            request.getRequestDispatcher("numberAlreadyExists.jsp").forward(request, response);
        } else {
            // If no duplicates are found, proceed with updating the persona data
            service.modificaPersona(persona);
            response.sendRedirect("getPersona");
        }
    }
}
