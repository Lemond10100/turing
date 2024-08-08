package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Persona;
import services.GestioneRubricaService;
import java.io.IOException;

public class ModificaPersonaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");  // Recupera l'username dalla sessione

        if (username == null) {
            response.sendRedirect("login.jsp");  // Se non c'è username, reindirizza al login
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String indirizzo = request.getParameter("indirizzo");
        String telefono = request.getParameter("telefono");
        int eta = Integer.parseInt(request.getParameter("eta"));

        Persona persona = new Persona(id, nome, cognome, indirizzo, telefono, eta, username);

        GestioneRubricaService service = new GestioneRubricaService();

        // Prima di procedere con la modifica, verifica se il numero di telefono è già utilizzato
        boolean isDuplicate = service.isPhoneNumberExistExceptCurrent(telefono, id, username);
        if (isDuplicate) {
            request.setAttribute("errorMessage", "Il numero di telefono è già utilizzato da un'altra persona.");
            request.getRequestDispatcher("numberAlreadyExists.jsp").forward(request, response);
        } else {
            // Se non ci sono duplicati, procedi con l'aggiornamento dei dati della persona
            service.modificaPersona(persona);
            response.sendRedirect("getPersona");
        }
    }
}
