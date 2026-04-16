package esercizio_3_parole_chiavi_e_modificatori_funzioni;

public class Main {

    static void printArray(int[] arr) {
        for (int el : arr) {
            System.out.println(el);
        }
    }

    static int sum(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    static int multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    static float multiply(float firstNum, float secondNum) {
        return firstNum * secondNum;
    }

    static int sommaNaturali(int n) {
        if (n <= 1) {
            return 1;
        }
        return n + sommaNaturali(n - 1);
    }

    static void modify(int a, int b) {
        System.out.println("Prima: " + "firstNum = " + a + "secondNum = " + b);
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("Dopo: " + "firstNum = " + a + "secondNum = " + b);
    }

    static void modifyArray(int[] arr, int newValue, int i) {
        System.out.println("Prima della modifica");
        printArray(arr);
        if (i < 0 || i >= arr.length) {
            System.out.println("Il valore i non è valido");
            return;
        }
        arr[i] = newValue;
        System.out.println("Dopo la modifica");
        printArray(arr);
    }

    public static void main(String[] args) {
        System.out.println("--------------------------");
        System.out.println("Somma: " + sum(2, 3)); // Output: "Somma: 5"
        System.out.println("--------------------------");
        System.out.println("Moltiplicazione interi: " + multiply(2, 3)); // Moltiplicazione interi: 5
        System.out.println("--------------------------");
        System.out.println("Moltiplicazione decimali: " + multiply(2.4f, 2.4f));
        System.out.println("--------------------------");
        System.out.println(sommaNaturali(5)); // 5+4+3+2+1 = 15
        System.out.println("--------------------------");

        int firstNum = 20;
        int secondNum = 45;
        modify(firstNum, secondNum);

        System.out.println("--------------------------");

        int[] nums = { 1, 2, 3 };
        int newValue = 12;
        int indexToModify = 2;
        modifyArray(nums, newValue, indexToModify);
    }
}
