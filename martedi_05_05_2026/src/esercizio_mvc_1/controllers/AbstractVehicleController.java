package esercizio_mvc_1.controllers;

import esercizio_mvc_1.models.AbstractVehicle;
import esercizio_mvc_1.views.AbstractVehicleView;

public class AbstractVehicleController {
    private AbstractVehicle vehicle;
    private AbstractVehicleView vehicleView;

    public AbstractVehicleController(AbstractVehicle vehicle, AbstractVehicleView vehicleView) {
        this.vehicle = vehicle;
        this.vehicleView = vehicleView;
    }

    public AbstractVehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(AbstractVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public AbstractVehicleView getVehicleView() {
        return this.vehicleView;
    }

    public void setVehicleView(AbstractVehicleView vehicleView) {
        this.vehicleView = vehicleView;
    }

}
