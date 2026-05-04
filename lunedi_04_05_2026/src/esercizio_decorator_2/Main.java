package esercizio_decorator_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);

        int choice = -1;

        while (choice != 0) {
            System.out.println("====Menu====");
            System.out.println("1 - Hamburger di bovino");
            System.out.println("2 - Hamburger di maiale");
            System.out.println("0 - Esci");
            System.out.print("Scelta: ");
            choice = inInt.nextInt();

            BurgerInterface burger;

            switch (choice) {
                case 1:
                    burger = new Burger("Hamburger di bovino", 10);
                    break;

                case 2:
                    burger = new Burger("Hamburger di maiale", 12);
                    break;

                default:
                    burger = new Burger("Hamburger di bovino", 10);
                    break;
            }

            choice = -1;

            while (choice != 0 && choice != 1) {
                System.out.println("Vuoi aggiungere un supplemento?");
                System.out.println("1 - no");
                System.out.println("2 - Formaggio");
                System.out.println("3 - Bacon");
                System.out.println("0 - Esci");

                choice = inInt.nextInt();

                switch (choice) {
                    case 1:
                        break;

                    case 2:
                        burger = new Cheese(burger);
                        break;

                    case 3:
                        burger = new Bacon(burger);

                    default:
                        break;
                }
            }

            System.out.println("Il tuo ordine è: " + burger.getDescription() + " | Prezzo: "
                    + String.format("%.2f", burger.getPrice()));
        }

        inInt.close();
        inString.close();
    }
}
