public class Plane {
    private String model;
    private int availableSeats;
    private String planeCode;

    public Plane() {
    }

    public Plane(String model, int availableSeats, String planeCode) {
        this.model = model;
        this.availableSeats = availableSeats;
        this.planeCode = planeCode;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        if (availableSeats < 0) {
            System.out.println("Il numero dei posti disponibili non è settabile con numeri negativi");
            return;
        }

        this.availableSeats = availableSeats;
    }

    public String getPlaneCode() {
        return this.planeCode;
    }

    public void setPlaneCode(String planeCode) {
        this.planeCode = planeCode;
    }

    @Override
    public String toString() {
        return "{" +
                " model='" + getModel() + "'" +
                ", availableSeats='" + getAvailableSeats() + "'" +
                ", planeCode='" + getPlaneCode() + "'" +
                "}";
    }

}
