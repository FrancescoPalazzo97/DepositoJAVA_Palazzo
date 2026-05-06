package esercizio_mvc_strategy_facade;

import esercizio_mvc_strategy_facade.controllers.BiosController;
import esercizio_mvc_strategy_facade.controllers.HardDiskController;
import esercizio_mvc_strategy_facade.controllers.OperativeSystemController;
import esercizio_mvc_strategy_facade.interfaces.BootStrategy;

public class NormalBootStrategy implements BootStrategy {

    @Override
    public void boot(BiosController bios, HardDiskController hardDisk, OperativeSystemController operativeSystem) {
        bios.turnOn();
        bios.printView();

        hardDisk.turnOn();
        hardDisk.printView();

        operativeSystem.turnOn();
        operativeSystem.printView();
    }

}
