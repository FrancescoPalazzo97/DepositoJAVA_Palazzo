public class Pilot {
    private String name;
    private String patentNumber;
    private int flightHours;

    public Pilot() {
    }

    public Pilot(String name, String patentNumber, int flightHours) {
        this.name = name;
        this.patentNumber = patentNumber;
        this.flightHours = flightHours;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatentNumber() {
        return this.patentNumber;
    }

    public void setPatentNumber(String patentNumber) {
        this.patentNumber = patentNumber;
    }

    public int getFlightHours() {
        return this.flightHours;
    }

    public void setFlightHours(int flightHours) {
        if (flightHours < 0) {
            System.out.println("Le ore di volo non sono settabili con numeri negativi");
            return;
        }

        this.flightHours = flightHours;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", patentNumber='" + getPatentNumber() + "'" +
                ", flightHours='" + getFlightHours() + "'" +
                "}";
    }

}
