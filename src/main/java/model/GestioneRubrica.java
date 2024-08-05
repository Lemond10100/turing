package model;

import java.util.ArrayList;
import java.util.List;

public class GestioneRubrica {
    private List<Persona> rubrica = new ArrayList<>();



    public void aggiungiPersona(Persona persona) {
        rubrica.add(persona);
    }

    public void rimuoviPersona(int id) {
        rubrica.removeIf(p -> p.getId() == id);
    }

    public void modificaPersona(Persona persona) {
        int index = rubrica.indexOf(persona);
        if (index != -1) {
            rubrica.set(index, persona);
        }
    }

    // Metodi per aggiungere, rimuovere e modificare vanno qui
}
