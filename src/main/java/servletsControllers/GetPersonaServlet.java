package servletsControllers;

import model.Persona;
import services.GestioneRubricaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GetPersonaServlet extends HttpServlet {
    public GetPersonaServlet() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestioneRubricaService service = new GestioneRubricaService();
        List<Persona> listaPersonas = service.getAllPersonas();  // Retrieve all personas from the database
        
        request.setAttribute("personas", listaPersonas);  // Store the list in request scope
        request.getRequestDispatcher("/displayPersonas.jsp").forward(request, response);  // Forward to JSP for display
    }
}
