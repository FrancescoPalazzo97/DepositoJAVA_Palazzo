package esercizio_mvc_1.models.decorators;

import esercizio_mvc_1.models.AbstractVehicle;

public abstract class VehicleDecorator extends AbstractVehicle {
    private AbstractVehicle vehicle;

    public VehicleDecorator(AbstractVehicle vehicle) {
        super(vehicle.getModel(), vehicle.getPlate());
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return vehicle.toString();
    }

}
