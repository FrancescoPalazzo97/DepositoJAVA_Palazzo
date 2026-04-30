package esercizio_observer_1;

public class Smartphone implements I_Display {
    private String owner;

    public Smartphone(String owner) {
        this.owner = owner;
    }

    @Override
    public void update(float temperature) {
        System.out.println("Lo smartphone di " + owner + " mostra la nuova temperatura: " + temperature + "C");
    }
}
