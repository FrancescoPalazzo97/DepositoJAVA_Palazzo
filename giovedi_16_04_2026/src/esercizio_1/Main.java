package esercizio_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inString = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        while (true) {
            System.out.println("Nome da aggiungere: ");
            String name = inString.nextLine();
            if (name.equalsIgnoreCase("fine")) {
                break;
            }
            names.add(name);
        }

        names.sort(null);

        while (true) {
            if (names.size() == 0) {
                System.out.println("La lista è vuota");
                break;
            }

            System.out.println("");
            System.out.println("Sono presenti " + names.size() + " nomi nella lista");

            System.out.println("I nomi nella lista sono: ");
            for (String name : names) {
                System.out.println(name);
            }

            System.out.println(
                    "Inserisci i nomi da eliminare uno alla volta. Oppure inserisci 'tutti' per svuotare la lista");
            String input = inString.nextLine();

            if (input.trim().equalsIgnoreCase("tutti")) {
                names.clear();
                System.out.println("Sono presenti " + names.size() + " nomi nella lista");
                System.out.println("Lista svuotata");
                break;
            }

            if (names.contains(input.trim())) {
                names.remove(input.trim());
            } else {
                System.out.println("Nome inserito non trovato. Inserisci un nome valido");
            }
        }
        inString.close();
    }
}
