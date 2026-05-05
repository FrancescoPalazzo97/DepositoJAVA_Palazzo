package esercizio_mvc_1.views;

import esercizio_mvc_1.models.AbstractVehicle;

public interface ObserverInterface {
    public void notifyView(AbstractVehicle vehicle);
}
