package esempio_1;

// Definzinoe della classe Singleton
public class Singleton {
    // Instanza privata statica della classe Singleton
    private static Singleton instance;

    // Costruttore privato per impedire l'instanziazione diretta
    private Singleton() {
    }

    // Metodo pubblico statico per ottenere l'unica ustanza della classe
    public static Singleton getInstance() {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
            instance = new Singleton();
        }
        // Restituisce l'istanza esistene o appena creata
        return instance;
    }

    // Metodo di esmpio che può essere chiamato sull'istanza Singleton
    public void DoSomething() {
        System.out.println("Singleton: DoSomething() called");
    }

}
