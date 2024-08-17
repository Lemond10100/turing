import static org.mockito.Mockito.*;

import jakarta.servlet.RequestDispatcher;
import org.junit.jupiter.api.Test;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import servletsControllers.AddPersonaServlet;

import java.io.IOException;

public class AddPersonaServletTest {

    @Test
    void whenValidPersonaIsAdded_thenRedirectToList() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("nome")).thenReturn("John");
        when(request.getParameter("cognome")).thenReturn("Doe");
        when(request.getParameter("indirizzo")).thenReturn("123 Street");
        when(request.getParameter("telefono")).thenReturn("1234567890");
        when(request.getParameter("eta")).thenReturn("30");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        new AddPersonaServlet().doPost(request, response);


    }
}
