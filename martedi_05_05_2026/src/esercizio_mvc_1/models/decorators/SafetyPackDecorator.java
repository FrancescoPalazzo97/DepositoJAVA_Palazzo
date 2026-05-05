package esercizio_mvc_1.models.decorators;

import esercizio_mvc_1.models.AbstractVehicle;

public class SafetyPackDecorator extends VehicleDecorator {

    public SafetyPackDecorator(AbstractVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String toString() {
        return super.toString() + ", con pacchetto sicurezza";
    }
}
