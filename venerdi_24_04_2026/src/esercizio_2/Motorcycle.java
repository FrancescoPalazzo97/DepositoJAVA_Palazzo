package esercizio_2;

public class Motorcycle extends Vehicle {

    private int engineSize;

    public Motorcycle(String plate, double speed, int axles, int engineSize) {
        super(plate, speed, axles);
        this.engineSize = engineSize;
    }

    public int getEngineSize() {
        return this.engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public double calculateToll() {
        return 0.75 + engineSize * 0.0001;
    }

    @Override
    public String printInfo() {
        return "Moto"
                + "\n    Cilindrata: " + this.engineSize + " cc\n    " + super.printInfo();
    }

}
