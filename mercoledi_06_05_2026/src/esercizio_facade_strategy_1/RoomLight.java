package esercizio_facade_strategy_1;

public class RoomLight implements LightInterface {
    private String color = "bianca";

    @Override
    public void turnOn() {
        System.out.println("Luce della camera accesa! Colore: " + color);
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Colore luce camera impostato su: " + color);
    }
}
