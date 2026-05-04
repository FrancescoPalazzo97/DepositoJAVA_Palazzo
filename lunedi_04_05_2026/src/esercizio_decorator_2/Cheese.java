package esercizio_decorator_2;

public class Cheese extends BurgerDecorator {

    public Cheese(BurgerInterface burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " + Formaggio";
    }

    @Override
    public double getPrice() {
        return burger.getPrice() + 0.50;
    }

}
