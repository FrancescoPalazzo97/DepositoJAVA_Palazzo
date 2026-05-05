package esercizio_mvc_1.views;

import java.util.ArrayList;

import esercizio_mvc_1.models.AbstractVehicle;

public class VehicleFactoryView implements ObserverInterface {

    public void printVehicles(ArrayList<AbstractVehicle> vehicles) {
        System.out.println("====Veicoli====");
        for (int i = 0; i < vehicles.size(); i++) {
            AbstractVehicle vehicle = vehicles.get(i);
            System.out.println((i + 1) + " - " + vehicle.toString());
        }
    }

    @Override
    public void notifyView(AbstractVehicle vehicle) {
        System.out.println("Nuovo veicolo prodotto:");
        System.out.println(vehicle.toString());
    }

}
