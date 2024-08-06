package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.GestioneRubricaService;

import java.io.IOException;


public class DeletePersonaServlet extends HttpServlet {
    public DeletePersonaServlet(){}
    static {
        System.out.println("DeletePersonaServlet class");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("siamo in DeletePersonaServlet,do post");
        Integer id = Integer.parseInt(request.getParameter("id"));
        GestioneRubricaService service = new GestioneRubricaService();
        service.rimuoviPersona(id);
        response.sendRedirect("lista.jsp"); // Redirect to your JSP page that lists all personas
    }
}
