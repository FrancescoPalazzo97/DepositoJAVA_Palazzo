package esercizio_2;

public class Main {

    static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    static void factorial(String s) {
        System.out.println("Inserisci un numero valido");
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // Output: 120
        System.out.println(factorial(0)); // Output: 1
        factorial("ciao"); // Output: "Inserisci un numero valido"
    }
}
