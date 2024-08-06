package servletsControllers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class PersonaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String id = request.getParameter("id"); // Might be null if it's a new Persona
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String indirizzo = request.getParameter("indirizzo");
        String telefono = request.getParameter("telefono");
        String eta = request.getParameter("eta"); // Ensure this is handled as an integer in your logic

        // Business logic
        // Check if an ID is present. If present, it means update, otherwise, it means create new.
        if (id != null && !id.isEmpty()) {
            // Update the existing Persona
            //qui devo richiamare un service che chiama le funzioni esposte dalla jdbc, corretto ?
            // Example: gestioneRubrica.updatePersona(new Persona(id, nome, cognome, indirizzo, telefono, Integer.parseInt(eta)));
        } else {
            // Add a new Persona
            // Example: gestioneRubrica.addPersona(new Persona(nome, cognome, indirizzo, telefono, Integer.parseInt(eta)));
        }

        // Redirecting to the list page after completing the operation
        response.sendRedirect("lista.jsp"); // Make sure the redirection URL is correct
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handling for GET requests if needed, such as forwarding to JSP pages
        request.getRequestDispatcher("editor.jsp").forward(request, response);
    }
}
