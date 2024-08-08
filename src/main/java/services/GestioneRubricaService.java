package services;

import model.Persona;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestioneRubricaService {
    public static final String NUMERO_DI_TELEFONO_GIÀ_ESISTENTE_NELLA_RUBRICA = "Numero_di_telefono_già_esistente_nella_rubrica";
    public static final String PERSONA_AGGIUNTA_CON_SUCCESSO = "Persona_aggiunta_con_successo";
    private String url = "jdbc:mysql://localhost:3306/rubrica";
    private String userdb = "rubrica";
    private String password = "Dom101006566!";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Correct driver class for newer MySQL versions
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    private boolean numberAlreadyExist(String telefono) {
        String sql = "SELECT COUNT(*) FROM lista_contatti WHERE telefono = ?";
        try (Connection conn = DriverManager.getConnection(url, userdb, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, telefono);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String aggiungiPersona(Persona persona) {
        if (!numberAlreadyExist(persona.getTelefono())) {
            String sql = "INSERT INTO lista_contatti (nome, cognome, indirizzo, telefono, eta) VALUES (?, ?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(url, userdb, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, persona.getNome());
                pstmt.setString(2, persona.getCognome());
                pstmt.setString(3, persona.getIndirizzo());
                pstmt.setString(4, persona.getTelefono());
                pstmt.setInt(5, persona.getEta());
                pstmt.executeUpdate();
                return PERSONA_AGGIUNTA_CON_SUCCESSO;
            } catch (SQLException e) {
                e.printStackTrace();
                return "Errore durante l'aggiunta della persona: " + e.getMessage();
            }
        } else {
            return NUMERO_DI_TELEFONO_GIÀ_ESISTENTE_NELLA_RUBRICA;
        }
    }



    public void rimuoviPersona(Integer id) {
        String sql = "DELETE FROM lista_contatti WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, userdb, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificaPersona(Persona persona) {
        String sql = "UPDATE lista_contatti SET nome = ?, cognome = ?, indirizzo = ?, telefono = ?, eta = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, userdb, password);
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

    public boolean isPhoneNumberExistExceptCurrent(String phoneNumber, int currentId) {
        String query = "SELECT COUNT(*) FROM lista_contatti WHERE telefono = ? AND id <> ?";
        try (Connection conn = DriverManager.getConnection(url, userdb, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, phoneNumber);
            stmt.setInt(2, currentId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // Controlla se il conteggio è maggiore di zero
                }
            }
        } catch (SQLException e) {
            System.err.println("Errore durante la verifica del numero di telefono: " + e.getMessage());
            // Gestisci l'eccezione come preferisci, log, throw new runtime exception, ecc.
        }
        return false;  // Se la query non trova duplicati o si verifica un'eccezione
    }



    public List<Persona> getAllPersonas() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM lista_contatti";
        System.out.println("We are in GestioneRubrica, getAllPersonas");
        try (Connection conn = DriverManager.getConnection(url, userdb, password);
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

    private Persona getPersonaById(Integer id){
        for(Persona persona :this.getAllPersonas()){
            if(persona.getId()==id){
                return persona;
            }
        }
        return null;
    }


        // Other methods...

        public boolean userExists(User user) {
            // Check if the username already exists in the database
            String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
            try (Connection conn = DriverManager.getConnection(url, userdb, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, user.getUsername());
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public void addUser(User user) {
            // Add the new user to the database
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (Connection conn = DriverManager.getConnection(url,userdb, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getPassword());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public String getPasswordForUser(String username) {
        String sql = "SELECT password FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(url, userdb, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


