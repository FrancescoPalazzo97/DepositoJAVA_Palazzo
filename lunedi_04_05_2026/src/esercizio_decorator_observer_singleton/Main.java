package esercizio_decorator_observer_singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static NotificationManager notificationManager = NotificationManager.getIstance();

    private static Scanner inInt = new Scanner(System.in);
    private static Scanner inString = new Scanner(System.in);

    private static void printDecoratorMenu() {
        System.out.println("Aggiungi un decorator (puoi selezionarne piu' di uno, in ordine di applicazione):");
        System.out.println("1 - Maiuscolo");
        System.out.println("2 - Minuscolo");
        System.out.println("3 - Timestamp");
        System.out.println("0 - Fine");
    }

    private static List<String> chooseDecorators() {
        List<String> preferences = new ArrayList<>();
        int decoratorChoice = -1;

        while (decoratorChoice != 0) {
            printDecoratorMenu();
            decoratorChoice = inInt.nextInt();

            switch (decoratorChoice) {
                case 1:
                    preferences.add("uppercase");
                    break;
                case 2:
                    preferences.add("lowercase");
                    break;
                case 3:
                    preferences.add("timestamp");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }

        return preferences;
    }

    public static void main(String[] args) {
        int choice = -1;

        while (choice != 0) {
            System.out.println("===MENU===");
            System.out.println("1 - Aggiungi un nuovo utente");
            System.out.println("2 - Invia una notifica");
            System.out.println("3 - Rimuovi un utente");
            System.out.println("4 - Lista utenti registrati");
            System.out.println("0 - Esci");

            choice = inInt.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Inserisci il nome: ");
                    String name = inString.nextLine();

                    List<String> preferences = chooseDecorators();

                    User user = new User(name, preferences);
                    notificationManager.addUser(user);
                    System.out.println("Utente '" + name + "' registrato.");
                    break;
                }

                case 2: {
                    if (notificationManager.getUsers().isEmpty()) {
                        System.out.println("Nessun utente registrato.");
                        break;
                    }

                    System.out.print("Inserisci il messaggio da inviare: ");
                    String message = inString.nextLine();
                    notificationManager.newNotify(message);
                    break;
                }

                case 3: {
                    ArrayList<User> users = notificationManager.getUsers();

                    if (users.isEmpty()) {
                        System.out.println("Nessun utente registrato.");
                        break;
                    }

                    System.out.println("Utenti registrati:");
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println((i + 1) + " - " + users.get(i).getName());
                    }

                    System.out.print("Indice utente da rimuovere: ");
                    int index = inInt.nextInt();

                    if (index < 1 || index > users.size()) {
                        System.out.println("Indice non valido.");
                        break;
                    }

                    User removed = users.get(index - 1);
                    notificationManager.removeUser(removed);
                    System.out.println("Utente '" + removed.getName() + "' rimosso.");
                    break;
                }

                case 4: {
                    ArrayList<User> users = notificationManager.getUsers();

                    if (users.isEmpty()) {
                        System.out.println("Nessun utente registrato.");
                        break;
                    }

                    System.out.println("Utenti registrati:");
                    for (int i = 0; i < users.size(); i++) {
                        User u = users.get(i);
                        System.out.println((i + 1) + " - " + u.getName() + " " + u.getDecoratorPreferences());
                    }

                    break;
                }

                case 0:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }
}
