package esercizio_4;

import java.util.Scanner;

public class Main {

    static Scanner inInt = new Scanner(System.in);

    // Funzione con la quale chiedo input all'user
    static int askNumbersOfVotes() {
        System.out.println("Quanti voti vuoi inserire?");
        return inInt.nextInt();
    }

    // Funzione che mi restituisce la somma dato un array di interi in input
    static int getSum(int[] arr) {
        int sum = 0;
        for (int el : arr) {
            sum += el;
        }
        return sum;
    }

    // Funzione che mi restituisce la media dei voti
    static int getAverageVote(int sum, int numberOfVotes) {
        return sum / numberOfVotes;
    }

    // Funzione che mi restituisce il voto più alto
    static int getHigherVote(int[] arr) {
        int higherVote = 0;
        for (int el : arr) {
            if (el > higherVote) {
                higherVote = el;
            }
        }
        return higherVote;
    }

    // Funzione che mi restituisce il voto più basso
    static int getLowerVote(int[] arr) {
        int lowerVote = Integer.MAX_VALUE;
        for (int el : arr) {
            if (el < lowerVote) {
                lowerVote = el;
            }
        }
        return lowerVote;
    }

    // Funzione che mi restituisce un booleano in base al voto medio
    static boolean getPromotion(int averageVote) {
        if (averageVote >= 6) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int numberOfVote = askNumbersOfVotes(); // Prendo l'input dell'user
        int[] votes = new int[numberOfVote]; // Creo un array

        // Ciclo per inserire tutti i voti che l'user inserisce
        for (int i = 0; i < numberOfVote; i++) {
            System.out.println("Inserisci il voto numero " + (i + 1));
            int userInput = inInt.nextInt();
            votes[i] = userInput;
        }

        // Flag che uso per controllare il ciclo while
        boolean flag = true;

        while (flag) {
            // Menu
            System.out.println("--------------");
            System.out.println("1 - Calcola media");
            System.out.println("2 - Mostra voto più alto");
            System.out.println("3 - Mostra voto più basso");
            System.out.println("4 - Verifica promozione");
            System.out.println("5 - Esci");
            System.out.println("--------------");

            int userInput = inInt.nextInt(); // Prendo l'input dell'user

            // Switch per gestire la scelta dell'user
            switch (userInput) {
                case 1:
                    int sum = getSum(votes); // Prendo la somma
                    int averageVote = getAverageVote(sum, votes.length); // Prendo il voto medio
                    System.out.println("Il voto medio è: " + averageVote); // Stampo il messaggio
                    break;

                case 2:
                    int higherVote = getHigherVote(votes); // Prendo il voto più alto
                    System.out.println("Il voto più alto è: " + higherVote); // Stampo il messaggio
                    break;

                case 3:
                    int lowerVote = getLowerVote(votes); // Prendo il voto più basso
                    System.out.println("Il voto più basso è: " + lowerVote); // Stampo il messaggio
                    break;

                case 4:
                    boolean isPromoted = getPromotion(getAverageVote(getSum(votes), votes.length));
                    System.out.println(isPromoted ? "Sei promosso" : "Sei bocciato"); // Stampo il messaggio usando
                                                                                      // operatore ternario
                    break;

                case 5:
                    System.out.println("Arrivederci"); // Saluto l'user
                    flag = false; // Imposto la flag a false per uscire dal ciclo
                    break;

                default:
                    System.out.println("\nInput non valido!\n"); // Stampo messaggio di errore e ripeto il ciclo
                    break;
            }
        }

    }
}
