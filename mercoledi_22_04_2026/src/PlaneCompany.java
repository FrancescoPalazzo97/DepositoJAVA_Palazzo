import java.util.ArrayList;

public class PlaneCompany {
    private String name;
    private ArrayList<Plane> fleet;
    private ArrayList<Pilot> pilots;

    public PlaneCompany() {
    }

    public PlaneCompany(String name) {
        this.name = name;
        this.fleet = new ArrayList<>();
        this.pilots = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Plane> getFleet() {
        return this.fleet;
    }

    public void setFleet(ArrayList<Plane> fleet) {
        this.fleet = fleet;
    }

    public ArrayList<Pilot> getPilots() {
        return this.pilots;
    }

    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }

    public void addPlane(Plane newPlane) {
        if (!(newPlane instanceof Plane)) {
            System.out.println("Errore di sistema");
            return;
        }
        System.out.println("Nuovo aereo: " + newPlane.getModel() + " con codice " + newPlane.getPlaneCode()
                + " è stato aggiunto alla flotta di " + this.getName());
        fleet.add(newPlane);
    }

    public void addPilot(Pilot newPilot) {
        if (!(newPilot instanceof Pilot)) {
            System.out.println("Errore di sistema");
            return;
        }

        System.out.println("Nuovo pilota: " + newPilot.getName() + " con codice patente " + newPilot.getPatentNumber()
                + " è stato aggiunto alla flotta di " + this.getName());
        pilots.add(newPilot);
    }

    public void printCompany() {
        String s = "====Compagnia " + this.getName() + "====\n";
        s += "----Piloti----\n";
        for (Pilot pilot : pilots) {
            s += pilot.toString() + "\n";
        }
        s += "----Aerei----\n";
        for (Plane plane : fleet) {
            s += plane.toString() + "\n";
        }
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", fleet='" + getFleet() + "'" +
                ", pilots='" + getPilots() + "'" +
                "}";
    }

}
