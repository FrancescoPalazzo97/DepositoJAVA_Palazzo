package esercizio_facade_strategy_1;

public class KitchenLight implements LightInterface {
    private String color = "bianca";

    @Override
    public void turnOn() {
        System.out.println("Luce della cucina accesa! Colore: " + color);
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Colore luce cucina impostato su: " + color);
    }
}
