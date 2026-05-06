package esercizio_facade_strategy_1;

public class WarmColorStrategy implements Strategy {

    @Override
    public void changeColor(LightInterface light) {
        light.setColor("giallo caldo");
    }
}
