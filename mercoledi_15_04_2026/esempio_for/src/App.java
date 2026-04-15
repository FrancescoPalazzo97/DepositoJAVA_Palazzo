import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Richiede un numero all'utente
        System.out.println("Inserisci un numero: ");
        int num = in.nextInt();

        // Stampa la tabellina del numero
        System.out.println("Tabellina del " + num + ":");

        // Cicle dor per moltiplicare il numero da 1 a 10
        for (int i = 0; i < 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        in.close();
    }
}
