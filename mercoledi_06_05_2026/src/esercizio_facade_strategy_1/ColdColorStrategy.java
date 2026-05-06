package esercizio_facade_strategy_1;

public class ColdColorStrategy implements Strategy {

    @Override
    public void changeColor(LightInterface light) {
        light.setColor("bianco freddo");
    }
}
