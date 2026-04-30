package esercizio_observer_1;

public class TV implements I_Display {
    private String name;

    public TV(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println("Il televisore " + name + " mostra la nuova temperatura: " + temperature + "C");
    }

}
