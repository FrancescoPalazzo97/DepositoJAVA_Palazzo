package esercizio_mvc_strategy_facade;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PcManagerFacade pc = new PcManagerFacade();
        Scanner inInt = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Scegli un'opzione: ");
            int choice = inInt.nextInt();

            switch (choice) {
                case 1:
                    pc.setBootStrategy(new NormalBootStrategy());
                    pc.turnOn();
                    break;

                case 2:
                    pc.setBootStrategy(new SafeBootStrategy());
                    pc.turnOn();
                    break;

                case 0:
                    running = false;
                    System.out.println("Chiusura applicazione.");
                    break;

                default:
                    System.out.println("Opzione non valida.");
                    break;
            }
        }

        inInt.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== PC Manager ===");
        System.out.println("1. Avvio normale");
        System.out.println("2. Avvio in modalita' provvisoria");
        System.out.println("0. Esci");
    }
}
