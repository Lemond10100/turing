package services;

import model.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestioneRubricaService {
    private String url = "jdbc:mysql://localhost:3306/rubrica";
    private String user = "rubrica";
    private String password = "Dom101006566!";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Correct driver class for newer MySQL versions
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public void aggiungiPersona(Persona persona) {
        String sql = "INSERT INTO lista_contatti (nome, cognome, indirizzo, telefono, eta) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, persona.getNome());
            pstmt.setString(2, persona.getCognome());
            pstmt.setString(3, persona.getIndirizzo());
            pstmt.setString(4, persona.getTelefono());
            pstmt.setInt(5, persona.getEta());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rimuoviPersona(int id) {
        String sql = "DELETE FROM lista_contatti WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificaPersona(Persona persona) {
        String sql = "UPDATE lista_contatti SET nome = ?, cognome = ?, indirizzo = ?, telefono = ?, eta = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, persona.getNome());
            pstmt.setString(2, persona.getCognome());
            pstmt.setString(3, persona.getIndirizzo());
            pstmt.setString(4, persona.getTelefono());
            pstmt.setInt(5, persona.getEta());
            pstmt.setInt(6, persona.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> getAllPersonas() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM lista_contatti";
        System.out.println("We are in GestioneRubrica, getAllPersonas");
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                personas.add(new Persona(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"),
                        rs.getString("indirizzo"), rs.getString("telefono"), rs.getInt("eta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }
}
