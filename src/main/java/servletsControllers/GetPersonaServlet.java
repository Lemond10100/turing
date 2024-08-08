package servletsControllers;

import model.Persona;
import services.GestioneRubricaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.UserService;

import java.io.IOException;
import java.util.List;


public class GetPersonaServlet extends HttpServlet {
    public GetPersonaServlet() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Get existing session if present

        // Check if user is logged in
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp"); // Redirect to login page if not logged in
            return;
        }

        String username = (String) session.getAttribute("username"); // Retrieve username from session
        GestioneRubricaService service = new GestioneRubricaService();
        UserService userService = new UserService();
        // Retrieve only the personas associated with the logged-in user
        List<Persona> listaPersonas = service.getAllPersonasForUser(username);
        request.setAttribute("personas", listaPersonas); // Store the list in request scope
        request.getRequestDispatcher("/lista.jsp").forward(request, response); // Forward to JSP for display
    }
}
