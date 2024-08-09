package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException");
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        String username = userService.getCurrentUserFromSession(session);
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String indirizzo = request.getParameter("indirizzo");
        String telefono = request.getParameter("telefono");
        int eta = Integer.parseInt(request.getParameter("eta"));

        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta, username);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Persona>> violations = validator.validate(persona);
        System.out.println("Number of violations debugging::::: " + violations.size());//debugging
        for (ConstraintViolation<Persona> violation : violations) {
            System.out.println(violation.getMessage());
        }
        if (!violations.isEmpty()) {

            System.out.println("validation checkings..");
            request.setAttribute("persona", persona); // Include the persona object to repopulate the form
            request.setAttribute("errors", violations); // Send validation errors back to the form
            request.getRequestDispatcher("editor.jsp").forward(request, response); // Redirect back to the form page
        } else {
            GestioneRubricaService service = new GestioneRubricaService();
            String result = service.aggiungiPersona(persona);

            if (result.equalsIgnoreCase(GestioneRubricaService.PERSONA_AGGIUNTA_CON_SUCCESSO)) {
                response.sendRedirect("getPersona"); // Redirect to list page if successful
            } else if (result.equalsIgnoreCase(GestioneRubricaService.NUMERO_DI_TELEFONO_GIÀ_ESISTENTE_NELLA_RUBRICA)) {
                request.setAttribute("message", "Numero di telefono già esistente nella rubrica.");
                request.getRequestDispatcher("numberAlreadyExists.jsp").forward(request, response); // Forward to error page if the number exists
            }
        }
    }
}
