package esercizio_mvc_strategy_facade.controllers;

import esercizio_mvc_strategy_facade.models.HardDiskModel;
import esercizio_mvc_strategy_facade.views.HardDiskView;

public class HardDiskController {
    private HardDiskModel model;
    private HardDiskView view;

    public HardDiskController(HardDiskModel model, HardDiskView view) {
        this.model = model;
        this.view = view;
    }

    public void turnOn() {
        model.setIsloaded(!model.getIsloaded());
    }

    public void printView() {
        view.load();
    }
}
