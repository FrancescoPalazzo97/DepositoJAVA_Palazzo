package esercizio_facade_strategy_1;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void applyStrategy(LightInterface light) {
        strategy.changeColor(light);
    }
}
