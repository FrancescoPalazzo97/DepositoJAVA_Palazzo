package esercizio_observer_singleton_4;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificator = NotificationManager.getIstance();
        int choice = -1;

        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("=====MENU=====");
            System.out.println("1 - Crea un nuovo utente");
            System.out.println("2 - Rimuovi utente");
            System.out.println("3 - Crea un nuovo post");
            System.out.println("0 - Esci");

            choice = inInt.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Arrivederci");
                    break;

                case 1: {
                    System.out.print("Inserisci nome utente: ");
                    String name = inString.nextLine();
                    notificator.addUser(new User(name));
                    System.out.println("L'utente [ " + name + " ] è stato creato");
                    break;
                }

                case 2: {
                    System.out.println("Inserisci il nome dell'utente da eliminare");
                    String name = inString.nextLine();
                    boolean isUserDeleted = notificator.removeUser(name);

                    if (!isUserDeleted) {
                        System.out.println("Utente non trovato");
                        continue;
                    }

                    System.out.println("Utente eliminato con successo!");
                    break;
                }

                case 3:
                    System.out.println("Inserisci contenuto del post");
                    String content = inString.nextLine();
                    notificator.addNewPost(new Post(content, new Date()));
                    break;

                default:
                    break;
            }
        }

        inInt.close();
        inString.close();
    }
}
