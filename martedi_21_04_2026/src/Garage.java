import java.util.ArrayList;

public class Garage {
    ArrayList<Car> cars = new ArrayList<>();

    public void addNewCar(Car newCar) {
        cars.add(newCar);
    }

    public void printGarage() {
        System.out.println("----MY-GARAGE----");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
