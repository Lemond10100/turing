package services;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void createSessionCookie(HttpServletResponse response, String sessionId) {
        Cookie sessionCookie = new Cookie("JSESSIONID", sessionId);
        sessionCookie.setMaxAge(60 * 60); // 1 hour (in seconds)
        sessionCookie.setHttpOnly(true);  // Protect the cookie from JavaScript access
        sessionCookie.setSecure(false);    // Ensure the cookie is sent only over HTTPS
        response.addCookie(sessionCookie);
    }

    // Puoi aggiungere altri metodi utili per la gestione dei cookie qui, se necessario
}
