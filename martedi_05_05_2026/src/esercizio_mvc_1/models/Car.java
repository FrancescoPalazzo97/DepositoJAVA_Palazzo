package esercizio_mvc_1.models;

public class Car extends AbstractVehicle {

    public Car(String model, String plate) {
        super(model, plate);
    }

    @Override
    public String toString() {
        return "CAR: " + super.toString();
    }

}
