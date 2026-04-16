package esempi_funzioni;

public class Main {
    static void hello() {
        System.out.println("Hello Java!");
    }

    static int sum(int firstNum, int secondNum) {
        return firstNum + secondNum; // return della somma dei 2 numeri
    }

    static void show(int num) {
        System.out.println("Numero: " + num);
    }

    static void show(String txt) {
        System.out.println("Testo: " + txt);
    }

    public static void main(String[] args) {
        hello();

        System.out.println("Somma: " + sum(2, 3)); // Output: Somma: 5

        show(5);

        show("Hello world");
    }
}
