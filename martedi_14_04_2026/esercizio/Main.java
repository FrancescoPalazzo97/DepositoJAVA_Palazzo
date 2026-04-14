import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inString = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);

        System.out.println("Inserisci età");
        int age = inInt.nextInt();

        System.out.println("Hai un biglietto valido? (Si o No)");
        String isValid = inString.nextLine();

        System.out.println("Sei accompagnato da un adulto? (Si o No)");
        String isAccompanied = inString.nextLine();

        System.out.println("Hai acquistato l'opzione salta fila? (Si o No)");
        String isPriority = inString.nextLine();

        String text = "Età: " + age + "\n";

        if (isValid.equals("Si")) {
            text += "Ticket: Valid\n";
        } else {
            text += "Ticket: Not Valid\n";
        }

        if (isAccompanied.equals("Si")) {
            text += "Sei accompagnato\n";
        } else {
            text += "Non sei accompagnato\n";
        }

        if (isPriority.equals("Si")) {
            text += "Hai la priorità";
        } else {
            text += "Non hai la priotità";
        }

        System.out.println(text);

        inInt.close();
        inString.close();
    }
}
