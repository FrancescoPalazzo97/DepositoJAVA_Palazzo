package esercizio_observer_1;

public class Display implements I_Display {
    private String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println("[ " + name + " ]: Nuovo aggiornamento temperatura: " + temperature + "C");
    }

}
