package esercizio_1;

public class User {

    private static User instance; // Istanza

    // Costruttore privato
    private User() {
    }

    // Metodo per prendere l'istanza
    public static User getInstance() {

        if (instance == null) {
            instance = new User();
        }

        return instance;
    }

    @Override
    public String toString() {
        return "Istanza utente: " + super.toString();
    }

}
