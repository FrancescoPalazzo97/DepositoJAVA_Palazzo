package esercizio_decorator_2;

public class Burger implements BurgerInterface {
    private String description;
    private double price;

    public Burger(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

}
