package esercizio_mvc_strategy_facade.controllers;

import esercizio_mvc_strategy_facade.models.BiosModel;
import esercizio_mvc_strategy_facade.views.BiosView;

public class BiosController {
    private BiosModel model;
    private BiosView view;

    public BiosController(BiosModel model, BiosView view) {
        this.model = model;
        this.view = view;
    }

    public void turnOn() {
        model.setIsInitialized(!model.getIsInitialized());
    }

    public void printView() {
        view.initialize();
    }
}
