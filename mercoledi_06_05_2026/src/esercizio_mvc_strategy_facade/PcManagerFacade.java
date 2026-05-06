package esercizio_mvc_strategy_facade;

import esercizio_mvc_strategy_facade.controllers.BiosController;
import esercizio_mvc_strategy_facade.controllers.HardDiskController;
import esercizio_mvc_strategy_facade.controllers.OperativeSystemController;
import esercizio_mvc_strategy_facade.interfaces.BootStrategy;
import esercizio_mvc_strategy_facade.models.BiosModel;
import esercizio_mvc_strategy_facade.models.HardDiskModel;
import esercizio_mvc_strategy_facade.models.OperativeSystemModel;
import esercizio_mvc_strategy_facade.views.BiosView;
import esercizio_mvc_strategy_facade.views.HardDiskView;
import esercizio_mvc_strategy_facade.views.OperativeSystemView;

public class PcManagerFacade {
    private BiosController bios = new BiosController(new BiosModel(), new BiosView());
    private HardDiskController hardDisk = new HardDiskController(new HardDiskModel(), new HardDiskView());
    private OperativeSystemController operativeSystem = new OperativeSystemController(new OperativeSystemModel(),
            new OperativeSystemView());

    private BootStrategy bootStrategy = new NormalBootStrategy();

    public void setBootStrategy(BootStrategy bootStrategy) {
        this.bootStrategy = bootStrategy;
    }

    public void turnOn() {
        bootStrategy.boot(bios, hardDisk, operativeSystem);
    }
}
