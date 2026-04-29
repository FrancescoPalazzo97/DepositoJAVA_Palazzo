package esercizio_2;

import java.util.ArrayList;

public class DatabaseManager {
    private static DatabaseManager instance; // Istanza
    private static int connectionCounter = 0; // Contatore delle connessioni disponibili

    private DbRepo repo;

    // Costruttore privato che inizializza repo con l'istanza di DbRepo
    private DatabaseManager() {
        this.repo = DbRepo.getInstance();
    }

    // Metodo che torna l'istanza
    public static DatabaseManager getInstance() {

        // Se non esiste ancora la crea
        if (instance == null) {
            instance = new DatabaseManager();
        }

        return instance;
    }

    // Metodo per la connessione
    public void connect() {
        connectionCounter++;
        System.out.println("Connessione stabilita. Connessioni attive: " + connectionCounter);
    }

    // Metodo che ritorna il contatore
    public int getConnectionCounter() {
        return connectionCounter;
    }

    // Metodo fa la connessione al dummy db e salva il nuovo dato
    public Data save(String content, String userName) {
        connect();
        return repo.save(content, userName);
    }

    // Metodo fa la connessione al dummy db e torna il dato corrispondente
    public Data find(int i) {
        connect();
        return repo.show(i);
    }

    // Metodo fa la connessione al dummy db e torna tutti i dati
    public ArrayList<Data> all() {
        connect();
        return repo.index();
    }

}
