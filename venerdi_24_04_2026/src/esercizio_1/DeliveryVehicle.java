package esercizio_1;

public abstract class DeliveryVehicle {

    private String plate;
    private float maxLoad;

    public DeliveryVehicle(String plate, float maxLoad) {
        this.plate = plate;
        this.maxLoad = maxLoad;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public float getMaxLoad() {
        return this.maxLoad;
    }

    public void setMaxLoad(float maxLoad) {
        this.maxLoad = maxLoad;
    }

    abstract void packDelivery(String destination);

    public String printInfo() {
        return "Veicolo con targa: " + this.plate + "\n    Carico massimo: "
                + this.maxLoad + "\n=============================";
    }

}
