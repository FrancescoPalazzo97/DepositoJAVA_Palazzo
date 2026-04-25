package esercizio_2;

public class Car extends Vehicle {

    private int displacement;

    public Car(String plate, double speed, int axles, int displacement) {
        super(plate, speed, axles);
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    @Override
    public double calculateToll() {
        return getAxles() * 1.00 + displacement * 0.0005;
    }

    @Override
    public String printInfo() {
        return "Auto"
                + "\n    Cilindrata: " + this.displacement + " cc\n    " + super.printInfo();
    }

}
