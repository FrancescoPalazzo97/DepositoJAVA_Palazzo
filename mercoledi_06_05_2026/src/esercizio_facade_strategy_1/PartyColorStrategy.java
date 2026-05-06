package esercizio_facade_strategy_1;

public class PartyColorStrategy implements Strategy {

    @Override
    public void changeColor(LightInterface light) {
        light.setColor("multicolore");
    }
}
