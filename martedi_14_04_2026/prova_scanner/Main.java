import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Enter username");

        String username = scannerString.nextLine();
        System.out.println("Usernam is: " + username);

        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Entere a number");

        int number = scannerInt.nextInt();
        System.out.println("The number is " + number);

        scannerString.close();
        scannerInt.close();
    }

}
