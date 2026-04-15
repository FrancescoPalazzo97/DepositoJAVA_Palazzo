import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int attempts = 3; // Diachiaro la costante che rappresenta il numero di tentativi disponibili
        final String password = "java123"; // Diachiaro la costante che rappresenta la password
        boolean isLogged = false; // Variabile flag per vedere se l'utente è loggato
        int i = 0; // Variabile indice

        // Ciclo while che viene eseguito fino a che i (l'indice) sia minore del numero
        // di tentavi disponibili e ilLogged sia false
        while (i < attempts && isLogged == false) {
            System.out.println("Inserisci password"); // Faccio inserire la password all'utente
            String userInput = in.nextLine();

            // Blocco condizionale per vedere se la password inserita sia corretta
            if (userInput.equals(password)) {
                isLogged = true;
            } else {
                System.out.println("password errata.");
            }

            i++; // Incremento l'indice

            // Se raggiungo il limite e non sono ancora loggato (isLogged == false) stampo
            // messaggio di errore
            if (i == 3 && !isLogged) {
                System.out.println("Hai terminato i tentativi");
            }
        }

        if (isLogged) {
            String userInput;
            // Prendo l'input dell'utente fino a quando non iserisce un input valido
            do {
                System.out.println("Vuoi accedere al sistema? (s / n)");
                userInput = in.nextLine();
            } while (!userInput.equals("s") && !userInput.equals("n"));

            // Switch per stampare il messaggio corretto in base all'input inserito
            // precedentente
            switch (userInput) {
                case "s":
                    System.out.println("Accesso al sistema effettuato");
                    break;

                case "n":
                    System.out.println("Accesso non effetuato");
                    break;

                default:
                    break;
            }
        }
        in.close();
    }
}
