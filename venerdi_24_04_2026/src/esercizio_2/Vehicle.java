package esercizio_2;

public abstract class Vehicle {

    private String plate;
    private double speed;
    private int axles;

    public Vehicle(String plate, double speed, int axles) {
        this.plate = plate;
        setSpeed(speed);
        this.axles = axles;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        if (speed < 0) {
            System.out.println("Errore: la velocità non può essere negativa");
            return;
        }
        this.speed = speed;
    }

    public int getAxles() {
        return this.axles;
    }

    public void setAxles(int axles) {
        this.axles = axles;
    }

    public abstract double calculateToll();

    public String printInfo() {
        return "Targa: " + this.plate
                + "\n    Velocità: " + this.speed + " km/h"
                + "\n    Numero di assi: " + this.axles
                + "\n    Pedaggio: " + String.format("%.2f", calculateToll()) + " €"
                + "\n=============================";
    }

}
