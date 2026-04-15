import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner inString = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);

        final int MAX = 10;// Definisco una costante che rappresenta il massimo di dolci ordinabili

        int userInputSizeOrder = 0;
        boolean isValidInput;

        // Con un ciclo do-while chiedo all'utente di inserire un numero. Il quale se
        // non valido fa ripetere il ciclo fino a quando non viene inserito un valore
        // valido
        do {
            System.out.println("Quanti dolci vuoi ordinare? (max 10)");
            userInputSizeOrder = inInt.nextInt();

            isValidInput = (userInputSizeOrder >= 0 && userInputSizeOrder <= MAX) ? true : false;

            if (!isValidInput) {
                System.out.println("Input non valido inserisci un valore compreso tra 0 e 10");
            }
        } while (!isValidInput);

        // Inizializzo 2 array di dimensione "userInputSizeOrder", cioè l'input inserito
        // dall'utente
        String[] names = new String[userInputSizeOrder];
        int[] quantities = new int[userInputSizeOrder];

        // Con quest ociclo facio inserire all'utente i nomi dei dolci e le loro
        // rispettive quantità
        for (int i = 0; i < userInputSizeOrder; i++) {
            System.out.println("Inserisci il nome del dolce");
            String name = inString.nextLine();

            System.out.println("Inserisci la quantità");
            int quantity = inInt.nextInt();

            names[i] = name;
            quantities[i] = quantity;
        }

        // Costruisco un stringa che rappresenta il messaggio finale che andrò a
        // stampare
        String list = "Hai ordinato:\n";

        for (String name : names) {
            list += name + "\n";
        }

        int total = 0;

        for (int q : quantities) {
            total += q;
        }

        list += "Per un quantità totale di: " + total;

        System.out.println(list);

        inInt.close();
        inString.close();
    }
}
