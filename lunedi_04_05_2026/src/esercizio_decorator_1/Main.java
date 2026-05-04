package esercizio_decorator_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);

        int choice = -1;

        while (choice != 0) {
            System.out.print("inserisci una parola o una frase: ");
            MessageInterface message = new Message(inString.nextLine());

            System.out.println("1 - Nessuna modifica");
            System.out.println("2 - Uppercase");
            System.out.println("3 - Lowercase");
            System.out.print("Scelta: ");
            choice = inInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(message.getContent());
                    break;

                case 2:
                    MessageInterface messageUppercase = new Uppercase(message);
                    System.out.println(messageUppercase.getContent());
                    break;

                case 3:
                    MessageInterface messageLowercase = new Lowercase(message);
                    System.out.println(messageLowercase.getContent());
                    break;

                default:
                    break;
            }
        }

        inInt.close();
        inString.close();
    }
}
