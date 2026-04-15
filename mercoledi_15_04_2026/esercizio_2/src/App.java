import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nVote; // Quantità dei voti da inserire
        int validVotesCounter = 0; // Contatore dei voti validi

        do {
            // Chiedo la quantità di voti inseribili fino a quando l'input non è valido
            System.out.println("Quanti voti vuoi inserire?");
            nVote = in.nextInt();
        } while (nVote < 0);

        for (int i = 0; i < nVote; i++) {
            System.out.println("Inserisci il voto numero " + (i + 1));
            int vote = in.nextInt();

            boolean isValidVote = vote >= 0 && vote <= 30; // flag per favorire la lettura

            if (!isValidVote) { // if not is valid do this
                System.out.println("Voto non valido");
                continue; // Stacca questo ciclo e vai al prossima iterazione
            }

            validVotesCounter++; // Incremento il contatore

            if (vote >= 18 && vote < 24) {
                System.out.println("Sufficiente");
            } else if (vote >= 24) {
                System.out.println("Ottimo");
            } else {
                System.out.println("Insufficiente");
            }

        }

        System.out.println("i voti validi inseriti sono: " + validVotesCounter);

        in.close();
    }
}
