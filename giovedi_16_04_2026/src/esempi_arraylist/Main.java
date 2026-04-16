package esempi_arraylist;

import java.util.ArrayList; // import

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        // metodo add per aggiungere elementi alle ArrayList
        nums.add(10);
        nums.add(20);
        nums.add(30);

        ArrayList<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Carlo");

        for (int i = 0; i < names.size(); i++) {
            System.out.println("Nome N " + (i + 1) + ": " + names.get(i)); // metodo get per andare a prendere
                                                                           // l'elemento in base all'indice
        }

        // Alternativa con for each
        for (String name : names) {
            System.out.println(name);
        }
    }
}
