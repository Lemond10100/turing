package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Persona;
import model.User;
import services.GestioneRubricaService;
import services.UserService;

import java.io.IOException;

public class AddPersonaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("siamo in AddPersonaServlet ");
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        String username = userService.getCurrentUserFromSession(session);
        //String username = (String) session.getAttribute("username"); // Recupera l'username dalla sessione
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String indirizzo = request.getParameter("indirizzo");
        String telefono = request.getParameter("telefono");
        int eta = Integer.parseInt(request.getParameter("eta"));

        GestioneRubricaService service = new GestioneRubricaService();
        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta, username);
        String result = service.aggiungiPersona(persona);

        if (result.equalsIgnoreCase(GestioneRubricaService.PERSONA_AGGIUNTA_CON_SUCCESSO)) {
            response.sendRedirect("getPersona"); // Redirect to list page if successful
        } else if (result.equalsIgnoreCase(GestioneRubricaService.NUMERO_DI_TELEFONO_GIÀ_ESISTENTE_NELLA_RUBRICA)) {
            request.setAttribute("message", "Numero di telefono già esistente nella rubrica.");
            request.getRequestDispatcher("numberAlreadyExists.jsp").forward(request, response); // Forward to error page
        }
    }
}
