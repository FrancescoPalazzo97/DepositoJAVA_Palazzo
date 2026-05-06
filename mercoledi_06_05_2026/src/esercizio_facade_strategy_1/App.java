package esercizio_facade_strategy_1;

public class App {
    public static void main(String[] args) {
        LightManagerFacade lightManager = new LightManagerFacade();
        lightManager.turnOnAll();

        System.out.println("=======");

        lightManager.changeColorAll();
        lightManager.turnOnAll();

        System.out.println("=======");

        lightManager.setColorStrategy(new PartyColorStrategy());
        lightManager.changeColorAll();
        lightManager.turnOnAll();
    }
}
