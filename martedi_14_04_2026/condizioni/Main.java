public class Main {
    public static void main(String[] args) {
        int x = 20;
        int y = 10;

        // if
        if (x > y) {
            System.out.println("x is greater than y");
        }

        // if - else
        int time = 10;
        if (time < 20) {
            System.out.println("Good day");
        } else {
            System.out.println("Good evening");
        }

        // if - else if
        int hour = 22;

        if (hour < 10) {
            System.out.println("Good morning");
        } else if (hour < 18) {
            System.out.println("Good day");
        } else {
            System.out.println("Good evening");
        }

    }
}
