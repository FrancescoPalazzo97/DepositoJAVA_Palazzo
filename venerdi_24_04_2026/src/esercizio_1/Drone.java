package esercizio_1;

public class Drone extends DeliveryVehicle implements Trackable {

    public Drone(String plate, float maxLoad) {
        super(plate, maxLoad);
    }

    @Override
    public void trackDelivery(String trackingCode) {
        if (trackingCode == null || trackingCode.trim().equals("")) {
            System.out.println("Il codice non è valido");
            return;
        }

        System.out.println("Il drone è attualmente in consegna");
    }

    @Override
    void packDelivery(String destination) {
        System.out.println("Il drone sta consegnando presso questa destinazione: " + destination);
    }

    @Override
    public String printInfo() {
        return super.printInfo();
    }

}
