package esercizio_observer_1;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Display displayMonitor = new Display("Monitor");
        Display displayMobile = new Display("Mobile");

        // weatherStation.addDisplay(displayMobile);
        // weatherStation.setState(25);
        // weatherStation.setState(30);

        // weatherStation.addDisplay(displayMonitor);
        // weatherStation.setState(26);

        TV tvSalotto = new TV("Salotto");
        Smartphone smartphone1 = new Smartphone("Francesco");
        Smartphone smartphone2 = new Smartphone("Ferdinando");

        weatherStation.addDisplay(smartphone1);
        weatherStation.setState(24);
        System.out.println("=============");
        weatherStation.addDisplay(tvSalotto);
        weatherStation.setState(30);
        System.out.println("=============");
        weatherStation.removeDisplay(smartphone1);
        weatherStation.addDisplay(smartphone2);
        weatherStation.setState(20);
    }
}
