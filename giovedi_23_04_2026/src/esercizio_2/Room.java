package esercizio_2;

public class Room {
    private int number;
    private float price;

    public Room() {
        this.number = (int) (Math.random() * 900) + 100;
        this.price = Math.round((Math.random() * 450 + 50) * 100) / 100.0f;
    }

    public Room(int number, float price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void printDetails() {
        System.out.println("Stanza numero: " + this.number + " | Prezzo: " + this.price + "$");
    }

    public void printDetails(boolean showPrice) {
        if (!showPrice) {
            System.out.println("Stanza numero: " + this.number);
            return;
        }

        printDetails();
    }

}
