package model;

public class Persona {
    private Integer id;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;
    private int eta;
    private String username;  // Aggiunta del campo username

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
