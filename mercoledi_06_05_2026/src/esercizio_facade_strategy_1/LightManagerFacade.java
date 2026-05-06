package esercizio_facade_strategy_1;

public class LightManagerFacade {
    private LightInterface kitchenLight = new KitchenLight();
    private LightInterface roomLight = new RoomLight();
    private Context colorContext = new Context(new WarmColorStrategy());

    public void turnOnAll() {
        kitchenLight.turnOn();
        roomLight.turnOn();
    }

    public void setColorStrategy(Strategy strategy) {
        colorContext.setStrategy(strategy);
    }

    public void changeColorAll() {
        colorContext.applyStrategy(kitchenLight);
        colorContext.applyStrategy(roomLight);
    }
}
