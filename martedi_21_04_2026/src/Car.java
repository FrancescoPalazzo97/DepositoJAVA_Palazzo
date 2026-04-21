public class Car {
    private String plate;
    private String model;

    public Car() {
    }

    public Car(String plate, String model) {
        this.plate = plate;
        this.model = model;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "{" +
                " plate='" + getPlate() + "'" +
                ", model='" + getModel() + "'" +
                "}";
    }

}
