package esercizio_mvc_1.models.decorators;

import esercizio_mvc_1.models.AbstractVehicle;

public class NavigatorDecorator extends VehicleDecorator {

    public NavigatorDecorator(AbstractVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String toString() {
        return super.toString() + ", con navigatore";
    }

}
