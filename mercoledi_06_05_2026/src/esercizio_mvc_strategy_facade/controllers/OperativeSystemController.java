package esercizio_mvc_strategy_facade.controllers;

import esercizio_mvc_strategy_facade.models.OperativeSystemModel;
import esercizio_mvc_strategy_facade.views.OperativeSystemView;

public class OperativeSystemController {
    private OperativeSystemModel model;
    private OperativeSystemView view;

    public OperativeSystemController(OperativeSystemModel model, OperativeSystemView view) {
        this.model = model;
        this.view = view;
    }

    public void turnOn() {
        model.setIsStarted(!model.getIsStarted());
    }

    public void printView() {
        view.start();
    }
}
