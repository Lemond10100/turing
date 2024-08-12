package servletsControllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.GestioneRubricaService;
import services.UserService;
import java.io.IOException;


public class DeletePersonaServlet extends HttpServlet {
    public DeletePersonaServlet(){}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("siamo in DeletePersonaServlet,do post");
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        String username = userService.getCurrentUserFromSession(session);
        if (username == null) {
            response.sendRedirect("login.jsp"); // Redirigi al login se non c'è sessione
            return;
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        GestioneRubricaService service = new GestioneRubricaService();
        service.rimuoviPersona(id, username);
        response.sendRedirect("getPersona");
    }
}

