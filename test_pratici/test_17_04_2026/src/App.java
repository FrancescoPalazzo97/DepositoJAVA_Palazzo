/*
p1- registrazione login
p2- usare calc o visulizare dati
*/

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // Scanner per interi e stringhe
    static Scanner inInt = new Scanner(System.in);
    static Scanner inString = new Scanner(System.in);

    // Liste
    static ArrayList<String> usernames = new ArrayList<>(); // Lista di usernames
    static ArrayList<String> passwords = new ArrayList<>(); // lista di passwords
    static ArrayList<Integer> results = new ArrayList<>(); // Lista dei risultati
    static ArrayList<String> historyValues = new ArrayList<>(); // Lista dello storico

    static boolean isLogged = false; // Flag per controllare il loggin
    static int operationsCounter = 0; // Contatore delle operazioni totali

    // metodo che stampa massaggio di errore
    static void printErrorAccess() {
        System.out.println("Username o password errati");
    }

    // Metodo che controlla se un username già esiste
    static boolean existUsername(String username) {
        return usernames.contains(username);
    }

    // Metodo per la registrazione
    static void signin(String username, String password) {
        // Controllo se l'username già esiste in caso stampo messaggio di errore e non
        // procedo
        if (existUsername(username)) {
            System.out.println("Username già usato.");
            return;
        }

        usernames.add(username);
        passwords.add(password);
    }

    // Metodo per fare il login
    static boolean login(String username, String password) {
        int index = usernames.indexOf(username); // Mi prendo l'indice dell'username

        // Controllo che non ci siano problemi verificando se l'username è presente e
        // coincida con l'indice della password
        if (index == -1 || !passwords.get(index).equals(password)) {
            printErrorAccess();
            return false;
        }

        // se il controllo passa stampo messaggio di successo e vado avanti
        System.out.println("Login effettuato con successo");
        operationsCounter = 0;
        return true;
    }

    // Metodo che gestisce l'inserimento dei valori e le operazioni matematiche dato
    // il tipo di operazione
    static void executeOperations(int type) {
        int userInput;

        if (type == 5) { // Se l'input è 5 impost userInput forzatamente a 2 (non do la possibilità di
                         // inserire più di 2 numeri per la potenza)
            userInput = 2;
            System.out.println("Operazione Potenza: inserire base ed esponente.");
        } else { // Altrimenti chiedo quanti numeri vuole inserire
            System.out.println("Quanti numeri vuoi inserire?");
            userInput = inInt.nextInt();
        }

        // Se l'input è 0 posso tornare e non eseguire nulla dato che non ci sono numeri
        // su cui fare operazioni, altrimenti procedo
        if (userInput <= 0) {
            return;
        }

        ArrayList<Integer> nums = new ArrayList<>(); // Instanzio una List per i numeri che inserirà l'utente
        String stringValue = ""; // Mi inizializzo una stringa vuota

        // Ciclo n volte in base all'input dell'utente
        for (int i = 0; i < userInput; i++) {
            // Controllo che l'utente abbia scelto la potenza in tal caso stampo messaggi
            // differenti
            if (type == 5) {
                System.out.println(i == 0 ? "Inserisci la base: " : "Inserisci l'esponente: ");
            } else {
                System.out.print("Numero " + (i + 1) + ": ");
            }

            int inputValue = inInt.nextInt(); // Mi salvo l'input dell'utente
            nums.add(inputValue); // Lo inserisco nella List
            stringValue += inputValue + (i == userInput - 1 ? "" : ", "); // Se l'elemento è l'ultimo non aggiungo la
                                                                          // virgola
        }

        int result = nums.get(0); // inizializzo result con primo valore di nums
        String operationName = ""; // Inizializzo stringa vuota

        // Ciclo per la lunghezza di nums
        for (int i = 1; i < nums.size(); i++) {

            // Gestisco le casistiche con uno switch su type
            switch (type) {
                case 1:
                    result += nums.get(i);
                    operationName = "Somma";
                    break;

                case 2:
                    result -= nums.get(i);
                    operationName = "Sottrazione";
                    break;

                case 3:
                    result *= nums.get(i);
                    operationName = "Moltiplicazione";
                    break;

                case 4:
                    if (nums.get(i) == 0) { // Se un numero è 0 lancio errore
                        System.out.println("Errore: divisione per zero");
                        return;
                    }

                    result /= nums.get(i);
                    operationName = "Divisione";
                    break;

                case 5:
                    result = (int) Math.pow(result, nums.get(i)); // Eseguo la potenza utilizzando la classe Math e mi
                                                                  // torno un intero
                    operationName = "Potenza";
                    break;

                default:
                    break;
            }
        }

        // Salvo risultato nella sua List così come per lo storico operazioni
        results.add(result);
        historyValues.add(operationName + " di [" + stringValue + "]");
        System.out.println("Risultato: " + result);

        operationsCounter++; // Incremeto il contatore delle operazioni effettuate

        if (operationsCounter >= 4) { // Se raggiunge il limite slogga l'utente
            System.out.println("Limite operazioni raggiunto. Verrai slogagto");
            isLogged = false;
        }
    }

    // Metodo per mostrate lo storico
    static void showHistory() {
        System.out.println("\n--- STORICO OPERAZIONI ---");

        if (historyValues.isEmpty()) { // Se vuoto stampo un altro messaggio e non procedo con il resto del codice
            System.out.println("Al momento non hai ancora effetuato nessuna operazione");
            return;
        }

        // Altrimenti stampo lo storico
        for (int i = 0; i < historyValues.size(); i++) {
            System.out.println(historyValues.get(i) + " = " + results.get(i));
        }
    }

    public static void main(String[] args) throws Exception {

        while (true) {
            if (!isLogged) { // Blocco codice se non loggato
                // menu
                System.out.println("-----BENVENUTO-----");
                System.out.println("1 - Registrati");
                System.out.println("2 - Login");
                System.out.println("0 - Esci");
                System.out.println("-------------------");

                int userChoice = inInt.nextInt();

                // Se 0 esco
                if (userChoice == 0) {
                    break;
                }

                // Prendo gli input dell'utete
                System.out.println("Inserisci un username");
                String username = inString.nextLine();
                System.out.println("Inserisci la password");
                String password = inString.nextLine();

                // Switch per gestire la scelta dell'utente
                switch (userChoice) {
                    case 1:
                        signin(username, password);
                        break;

                    case 2:
                        isLogged = login(username, password);
                        break;

                    default:
                        break;
                }
            } else { // Blocco codice se loggato
                // menu
                System.out.println("\n--- MENU (Operazioni dispoinbili: " + operationsCounter + "/4) ---");
                System.out.println("1 - Calcolatrice");
                System.out.println("2 - Storico");
                System.out.println("0 - logout");

                int userChoice = inInt.nextInt();

                // Switch per gestire la scelta dell'utente
                switch (userChoice) {
                    case 1:
                        System.out.println("1 - Somma");
                        System.out.println("2 - Sottrazione");
                        System.out.println("3 - Moltiplicazione");
                        System.out.println("4 - Divisione");
                        System.out.println("5 - Potenza");

                        int operationChoice = inInt.nextInt();

                        if (operationChoice >= 1 && operationChoice <= 5) {
                            executeOperations(operationChoice);
                        }

                        break;

                    case 2:
                        showHistory();
                        break;

                    case 0:
                        isLogged = false;
                        break;

                    default:
                        break;
                }
            }
        }
    }
}
