package esercizio_2;

public class User {
    private static User instance; // Istanza
    private String name; // Nome utente

    // Costruttore privato
    private User() {
    }

    // Metodo che torna l'istanza
    public static User getInstance() {

        // Se non esiste ancora la crea
        if (instance == null) {
            instance = new User();
        }

        return instance;
    }

    // Metodo che torna il nome dell'utente
    public String getName() {
        return name;
    }

    // Metodo che modifica il nome dell'utente
    public void setName(String name) {
        this.name = name;
    }

    // Ovveride del metodo toString()
    @Override
    public String toString() {
        return "Utente: " + name;
    }

}
