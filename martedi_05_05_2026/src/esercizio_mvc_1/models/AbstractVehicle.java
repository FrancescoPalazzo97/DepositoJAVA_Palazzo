package esercizio_mvc_1.models;

public abstract class AbstractVehicle {
    private String model;
    private String plate;

    public AbstractVehicle(String model, String plate) {
        this.model = model;
        this.plate = plate;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "{" +
                " model='" + getModel() + "'" +
                ", plate='" + getPlate() + "'" +
                "}";
    }

}
