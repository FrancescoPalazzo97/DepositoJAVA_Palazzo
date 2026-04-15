public class App {
    public static void main(String[] args) throws Exception {
        // Dichiarazione e inizializzazione
        int[] nums = new int[5]; // Array di dimensione 5

        // Inizializzazione diretta
        int[] values = { 1, 2, 3, 4, 5 };

        for (int i : values) {
            System.out.println(i);
        }

        // Dichiarazione e inizializzazione
        int[][] matrix = new int[3][3];

        // Inizializzazione diretta
        int[][] matrixDefault = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Stampa
        System.out.println("Elemento centrale: " + matrixDefault[1][1]);
    }
}
