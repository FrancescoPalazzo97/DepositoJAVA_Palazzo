public class Main {

    public static void main(String[] args) {
        // println stampa la stringa nella console e va a capo
        System.out.println("Hello world");

        // print stampa sulla stessa riga
        System.out.print("Hello world! ");
        System.out.print("I will print on the same line");

        // Stampo numeri
        System.out.println(123);

        // stampo numeri come stringa
        System.out.println("123");

        // Stampo operazione matematiche
        System.out.println(2 + 3);
        System.out.println(2 * 3);

        // Dichiarazione con inizializzazione
        // type variableName = value;
        int num = 1;
        String text = "Hello";
        boolean bool = true;

        // Dichiarazione senza inizializzazione
        // type variableName;
        int n;
        String txt;
        boolean bool2;

        // Questa è una costante
        final int n2 = 1; // n2 = 2 => errore

        // Si può combinare il testo con una variabile
        System.out.println(text + " world!");

        // Si può fare anche all'interno di una variabile e anche tra variabili
        String firstName = "Francesco";
        String lastName = "Palazzo";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        // Per dichiarare più variabili dello stesso tipo è possibile utlizzare un
        // elenco separato dia virgole. monoriga
        int x = 1, y = 2, z = 3;
        System.out.println(x + y + z);

        // a cascata
        int x2, y2, z2;
        x2 = y2 = z2 = 1;
        System.out.println(x2 + y2 + z2);

        // float
        float myFloat = 5.5f;

        // Double
        double myDouble = 5.50d;

        // un numero in virgola mobile può essere rappresentato in base scientifica
        // ovvero ocn una "e" per indicare la potenza di 10
        float myFloat2 = 35e3f;
        double myDouble2 = 12E4d;

        // booleani: possono essere solo true e false
        // vengono utilizzati principalmente per indicare condizioni
        boolean isJava = true;
        boolean isFerrari = false;

        // char
        char myChar = 'A';
        // Si possono usare anche gli ASCII
        char myVar = 65;

        System.out.println(myChar + " = " + myVar);

    }

}
