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

        // se l'username esiste e la password corrisponde vado avanti
        if (index != -1 && passwords.get(index).equals(password)) {
            System.out.println("Login effettuato con successo");
            operationsCounter = 0;
            return true;
        }

        // Altrimenti stampo messaggio di errore
        printErrorAccess();
        return false;
    }

    static void executeOperations(int type) {
        int userInput;

        if (type == 5) {
            userInput = 2;
            System.out.println("Operazione Potenza: inserire base ed esponente.");
        } else {
            System.out.println("Quanti numeri vuoi inserire?");
            userInput = inInt.nextInt();
        }

        if (userInput <= 0) {
            return;
        }

        ArrayList<Integer> nums = new ArrayList<>();
        String stringValue = "";

        for (int i = 0; i < userInput; i++) {
            if (type == 5) {
                System.out.println(i == 0 ? "Inserisci la base: " : "Inserisci l'esponente: ");
            } else {
                System.out.print("Numero " + (i + 1) + ": ");
            }

            int inputValue = inInt.nextInt();
            nums.add(inputValue);
            stringValue += inputValue + (i == userInput - 1 ? "" : ", ");
        }

        int result = nums.get(0);
        String operationName = "";

        for (int i = 1; i < nums.size(); i++) {

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
                    if (nums.get(i) == 0) {
                        System.out.println("Errore: divisione per zero");
                        return;
                    } else {
                        result /= nums.get(i);
                        operationName = "Divisione";
                    }
                    break;

                case 5:
                    result = (int) Math.pow(result, nums.get(i));
                    operationName = "Potenza";
                    break;

                default:
                    break;
            }
        }

        results.add(result);
        historyValues.add(operationName + " di [" + stringValue + "]");
        System.out.println("Risultato: " + result);

        operationsCounter++;

        if (operationsCounter >= 4) {
            System.out.println("Limite operazioni raggiunto. Verrai slogagto");
            isLogged = false;
        }
    }

    static void showHistory() {
        System.out.println("\n--- STORICO OPERAZIONI ---");

        if (historyValues.isEmpty()) {
            System.out.println("Al momento non hai ancora effetuato nessuna operazione");
            return;
        }

        for (int i = 0; i < historyValues.size(); i++) {
            System.out.println(historyValues.get(i) + " = " + results.get(i));
        }
    }

    public static void main(String[] args) throws Exception {

        while (true) {
            if (!isLogged) {
                System.out.println("-----BENVENUTO-----");
                System.out.println("1 - Registrati");
                System.out.println("2 - Login");
                System.out.println("0 - Esci");
                System.out.println("-------------------");

                int userChoice = inInt.nextInt();

                if (userChoice == 0) {
                    break;
                }

                System.out.println("Inserisci un username con il quale registrarti");
                String username = inString.nextLine();
                System.out.println("Inserisci la password");
                String password = inString.nextLine();

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
            } else {
                System.out.println("\n--- MENU (Operazioni dispoinbili: " + operationsCounter + "/4) ---");
                System.out.println("1 - Calcolatrice");
                System.out.println("2 - Storico");
                System.out.println("0 - logout");

                int userChoice = inInt.nextInt();

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
