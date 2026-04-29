import java.util.ArrayList;
import java.util.Scanner;

import esercizio_2.DatabaseManager;
import esercizio_2.Data;
import esercizio_2.User;

public class App {
    public static void main(String[] args) throws Exception {

        // Verifica che siano le stesse istanze
        DatabaseManager db1 = DatabaseManager.getInstance();
        DatabaseManager db2 = DatabaseManager.getInstance();
        System.out.println("Stessa istanza DatabaseManager? " + (db1 == db2));

        // Prendo l'istanza di User
        User user = User.getInstance();

        // Inizializzo gli Scanner
        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1) Salva un dato");
            System.out.println("2) Richiama un dato per indice");
            System.out.println("3) Mostra tutti i dati");
            System.out.println("4) Mostra numero connessioni");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");

            // Recupero la scelta dell'utente
            choice = inInt.nextInt();

            switch (choice) {
                // Salvare un nuovo dato
                case 1: {
                    System.out.print("Contenuto del dato: ");
                    String content = inString.nextLine();

                    System.out.print("Nome utente: ");
                    String name = inString.nextLine();

                    user.setName(name);
                    Data saved = db1.save(content, user.getName());
                    System.out.println("Salvato: " + saved);
                    break;
                }
                // Stampare un dato specifico
                case 2: {
                    System.out.print("Indice da richiamare: ");
                    int i = inInt.nextInt();
                    Data result = db1.find(i);

                    // Se resutl è null stampo messaggio di errore ed esco
                    if (result == null) {
                        System.out.println("Errore: indice non valido");
                        return;
                    }

                    // Stampo il risultato
                    System.out.println("Trovato: " + result);
                    break;
                }
                // Stampare tutti i dati
                case 3: {
                    // Recupero tutti i dati
                    ArrayList<Data> list = db1.all();
                    // Controllo che non sia vuoto
                    if (list.isEmpty()) {
                        System.out.println("Nessun dato salvato.");
                        return;
                    }
                    // Stampo i dati
                    System.out.println("--- Dati salvati ---");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + ") " + list.get(i));
                    }
                    break;
                }
                // Stampa numero di connessioni attive
                case 4: {
                    System.out.println("Connessioni totali: " + db1.getConnectionCounter());
                    break;
                }
                // Esci
                case 0:
                    System.out.println("Uscita.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }

        inInt.close();
        inString.close();
    }
}
