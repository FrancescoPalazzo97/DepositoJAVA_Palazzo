package esercizio_2;

import java.util.ArrayList;

public class DbRepo {
    private static DbRepo instance; // Istanza

    private ArrayList<Data> data = new ArrayList<>(); // Dummy db
    private int nextId = 0; // ID incrementale

    // Costruttore privato
    private DbRepo() {
    }

    // Metodo che torna l'istanza
    public static DbRepo getInstance() {

        // Se non esiste ancora la crea
        if (instance == null) {
            instance = new DbRepo();
        }

        return instance;
    }

    // Metodo per salvare dati nel dummy db
    public Data save(String content, String userName) {
        Data newData = new Data(nextId++, content, userName);
        data.add(newData);
        return newData;
    }

    // Metodo che ritorna tutti i dati
    public ArrayList<Data> index() {
        return data;
    }

    // Metodo che ritorna solo un elemento specifico attraverso l'indice
    public Data show(int i) {
        // Validazione per verificare che l'indice passato al metodo sia valido
        if (i < 0 || i >= data.size()) {
            return null;
        }

        return data.get(i);
    }

}
