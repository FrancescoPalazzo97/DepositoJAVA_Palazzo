package esercizio_decorator_2;

public class Bacon extends BurgerDecorator {

    public Bacon(BurgerInterface burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " + Bacon";
    }

    @Override
    public double getPrice() {
        return burger.getPrice() + 0.80;
    }
}
