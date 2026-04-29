package esercizio_1;

public class Main {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();

        log1.writeMsg("Hello from log1");

        Logger log2 = Logger.getInstance();

        log2.writeMsg("Hello from log2");

        System.out.println();
        System.out.println(log1.toString());
        System.out.println(log2.toString());
        System.out.println(
                log1.toString().equals(log2.toString())
                        ? "Sono la stessa istanza"
                        : "Sono due istanze diverse");

        User u1 = User.getInstance();
        User u2 = User.getInstance();

        System.out.println();
        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println(
                u1.toString().equals(u2.toString())
                        ? "User1 e User2 hanno la stessa istanza"
                        : "User1 e User2 non hanno la stessa istanza");
    }
}
