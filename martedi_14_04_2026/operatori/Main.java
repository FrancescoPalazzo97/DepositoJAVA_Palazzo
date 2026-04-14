public class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        // Uguaglianza
        System.out.println(x == y);
        // Maggiore
        System.out.println(x > y);
        // maggiore uguale
        System.out.println(x >= y);
        // Minore
        System.out.println(x < y);
        // Minore uguale
        System.out.println(x <= y);
        // Diverso
        System.out.println(x != y);

        // Operatore && (and)
        System.out.println(x < y && x > y);

        // Operatore || (or)
        System.out.println(x < y || x > y);

        // Operatore ! (not)
        System.out.println(!(x < y));

        // Operatore && e !
        System.out.println(!(x < y && x > y));

        // Operatore || e !
        System.out.println(!(x < y || x > y));
    }
}
