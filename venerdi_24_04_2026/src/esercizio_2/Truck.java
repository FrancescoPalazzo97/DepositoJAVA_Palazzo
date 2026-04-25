package esercizio_2;

public class Truck extends Vehicle {

    private double cargoWeight;
    private String cargoType;

    public Truck(String plate, double speed, int axles, double cargoWeight, String cargoType) {
        super(plate, speed, axles);
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public double getCargoWeight() {
        return this.cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return this.cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public double calculateToll() {
        return getAxles() * 2.50 + cargoWeight * 0.001;
    }

    @Override
    public String printInfo() {
        return "Camion"
                + "\n    Tipo carico: " + this.cargoType
                + "\n    Peso carico: " + this.cargoWeight + " kg\n    " + super.printInfo();
    }

}
