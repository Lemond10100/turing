
package servletsControllers;

import model.Persona;
import services.GestioneRubricaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddPersonaServlet extends HttpServlet {
    public AddPersonaServlet(){}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("siamo in AddPersonaServlet,doPost");
        Integer id=null;
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String telefono = request.getParameter("telefono");
        String indirizzo = request.getParameter("indirizzo");
        int eta = Integer.parseInt(request.getParameter("eta"));

        Persona persona = new Persona( nome, cognome,indirizzo, telefono, eta);
        GestioneRubricaService service = new GestioneRubricaService();

        if (id == null) {
            service.aggiungiPersona(persona);
            System.out.println("if id=null");
        }

        response.sendRedirect("lista.jsp");
    }
}

