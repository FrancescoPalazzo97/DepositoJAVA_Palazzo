package esempio_strategy_1;

// Context
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performTask() {
        strategy.execute();
    }
}
