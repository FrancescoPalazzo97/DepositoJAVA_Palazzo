package esercizio_mvc_1.models;

public class Moto extends AbstractVehicle {

    public Moto(String model, String plate) {
        super(model, plate);
    }

    @Override
    public String toString() {
        return "MOTO: " + super.toString();
    }
}
