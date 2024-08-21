package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Persona;
import services.GestioneRubricaService;
import services.UserService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;


public class AddPersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("Session is invalid or user not authenticated. Redirecting to login.");
            response.sendRedirect("login.jsp?error=SessionExpired");
            return;
        }

        // Get the username from the session
        String username = (String) session.getAttribute("user");

        // Retrieve form data
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String indirizzo = request.getParameter("indirizzo");
        String telefono = request.getParameter("telefono");
        int eta = Integer.parseInt(request.getParameter("eta"));

        // Create a new Persona object
        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta, username);

        // Validate the Persona object
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Persona>> violations = validator.validate(persona);

        // Handle validation errors
        if (!violations.isEmpty()) {
            request.setAttribute("persona", persona);
            request.setAttribute("errors", violations);
            request.getRequestDispatcher("editor.jsp").forward(request, response);
        } else {
            // Add the persona to the database
            GestioneRubricaService service = new GestioneRubricaService();
            String result = service.aggiungiPersona(persona);

            // Handle the result
            if (result.equalsIgnoreCase(GestioneRubricaService.PERSONA_AGGIUNTA_CON_SUCCESSO)) {
                response.sendRedirect("getPersona");
            } else if (result.equalsIgnoreCase(GestioneRubricaService.NUMERO_DI_TELEFONO_GIÀ_ESISTENTE_NELLA_RUBRICA)) {
                request.setAttribute("message", "Numero di telefono già esistente nella rubrica.");
                request.getRequestDispatcher("numberAlreadyExists.jsp").forward(request, response);
            }
        }
    }
}
