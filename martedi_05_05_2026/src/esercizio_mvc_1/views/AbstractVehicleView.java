package esercizio_mvc_1.views;

import esercizio_mvc_1.models.AbstractVehicle;

public abstract class AbstractVehicleView {

    public void printDetails(AbstractVehicle vehicle) {
        System.out.println(vehicle.toString());
    };

}
