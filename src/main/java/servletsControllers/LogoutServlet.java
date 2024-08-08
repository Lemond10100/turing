package servletsControllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class LogoutServlet extends HttpServlet {
    public LogoutServlet(){}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Recupera la sessione se esiste
        if (session != null) {
            session.invalidate(); // Invalida la sessione per rimuovere tutti gli attributi
        }
        response.sendRedirect("login.jsp"); // Reindirizza alla pagina di login
    }
}
