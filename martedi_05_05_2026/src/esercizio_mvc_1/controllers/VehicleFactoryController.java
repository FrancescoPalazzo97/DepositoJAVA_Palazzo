package esercizio_mvc_1.controllers;

import esercizio_mvc_1.models.AbstractVehicle;
import esercizio_mvc_1.models.VehicleFactory;
import esercizio_mvc_1.views.VehicleFactoryView;

public class VehicleFactoryController {
    private VehicleFactory model;
    private VehicleFactoryView view;

    public VehicleFactoryController(VehicleFactoryView vehicleFactoryView) {
        this.model = VehicleFactory.getInstance();
        this.view = vehicleFactoryView;
        this.model.addView(vehicleFactoryView);
    }

    public void addNewVehicle(AbstractVehicle newVehicle) {
        model.produceVehicle(newVehicle);
    }

    public void printView() {
        view.printVehicles(model.getVehicles());
    }
}
