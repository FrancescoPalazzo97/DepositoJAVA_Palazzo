package esercizio_mvc_1.models.decorators;

import esercizio_mvc_1.models.AbstractVehicle;

public class SportPaintDecorator extends VehicleDecorator {

    public SportPaintDecorator(AbstractVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String toString() {
        return super.toString() + ", con verniciatura sportiva";
    }

}
