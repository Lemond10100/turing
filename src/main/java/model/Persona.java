package model;

import javax.validation.constraints.*;

public class Persona {
    private Integer id;

    @NotBlank(message = "Il nome non può essere vuoto")
    @Size(min = 2, max = 100, message = "Il nome deve contenere tra 2 e 100 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    @Size(min = 2, max = 100, message = "Il cognome deve contenere tra 2 e 100 caratteri")
    private String cognome;

    @Size(max = 200, message = "L'indirizzo non può superare i 200 caratteri")
    private String indirizzo;

    @NotBlank(message = "Il numero di telefono non può essere vuoto")
    @Pattern(regexp = "^\\+?[0-9. ()-]{10,25}$", message = "Il numero di telefono non è valido")
    private String telefono;

    @NotNull(message = "L eta non può essere vuota")
    @Min(value = 0, message = "L'età deve essere un numero positivo")
    private int eta;

    @NotBlank(message = "Il nome utente non può essere vuoto")
    @Size(min = 3, max = 30, message = "Il nome utente deve contenere tra 3 e 30 caratteri")
    private String username;

    public Persona(String nome, String cognome, String indirizzo, String telefono, int eta, String username) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.eta = eta;
        this.username = username;  // Imposta l'username tramite il costruttore
    }

    public Persona(Integer id, String nome, String cognome, String indirizzo, String telefono, int eta, String username) {
        this(nome, cognome, indirizzo, telefono, eta, username);
        this.id = id;  // Imposta anche l'id
    }

    // Getter e Setter

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public String getIndirizzo() { return indirizzo; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public int getEta() { return eta; }
    public void setEta(int eta) { this.eta = eta; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
