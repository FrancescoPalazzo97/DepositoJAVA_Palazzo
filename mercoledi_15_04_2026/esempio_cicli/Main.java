import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Ciclo while
        int i = 1;

        while (i <= 5) {
            i++;
            System.out.println(i);
        }

        // Ciclo do-while
        Scanner in = new Scanner(System.in);
        int num;
        do {
            System.out.println("Inserisci in numero (0 per uscire)");
            num = in.nextInt();
        } while (num != 0);

        System.out.println("Hai inserito 0. Programma terminato");
        in.close();
    }
}
