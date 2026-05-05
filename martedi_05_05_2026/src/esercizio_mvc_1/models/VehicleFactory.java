package esercizio_mvc_1.models;

import java.util.ArrayList;

import esercizio_mvc_1.views.ObserverInterface;

public class VehicleFactory {
    private static VehicleFactory instance;
    private ArrayList<AbstractVehicle> vehicles = new ArrayList<>();
    private ArrayList<ObserverInterface> views = new ArrayList<>();

    private VehicleFactory() {
    }

    public static VehicleFactory getInstance() {
        if (instance == null) {
            instance = new VehicleFactory();
        }

        return instance;
    }

    public ArrayList<AbstractVehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(ArrayList<AbstractVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addView(ObserverInterface view) {
        views.add(view);
    }

    public void removeView(ObserverInterface view) {
        views.remove(view);
    }

    public void produceVehicle(AbstractVehicle vehicle) {
        vehicles.add(vehicle);
        notifyViews(vehicle);
    }

    public void notifyViews(AbstractVehicle vehicle) {
        for (ObserverInterface view : views) {
            view.notifyView(vehicle);
        }
    }
}
