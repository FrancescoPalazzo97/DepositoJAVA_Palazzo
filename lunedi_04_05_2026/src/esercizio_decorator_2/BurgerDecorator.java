package esercizio_decorator_2;

public abstract class BurgerDecorator implements BurgerInterface {
    protected BurgerInterface burger;

    public BurgerDecorator(BurgerInterface burger) {
        this.burger = burger;
    }

}
