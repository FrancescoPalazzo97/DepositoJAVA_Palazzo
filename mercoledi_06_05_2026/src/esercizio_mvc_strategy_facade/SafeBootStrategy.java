package esercizio_mvc_strategy_facade;

import esercizio_mvc_strategy_facade.controllers.BiosController;
import esercizio_mvc_strategy_facade.controllers.HardDiskController;
import esercizio_mvc_strategy_facade.controllers.OperativeSystemController;
import esercizio_mvc_strategy_facade.interfaces.BootStrategy;

public class SafeBootStrategy implements BootStrategy {

    @Override
    public void boot(BiosController bios, HardDiskController hardDisk, OperativeSystemController operativeSystem) {
        System.out.println("Avvio in modalita' provvisoria");

        bios.turnOn();
        bios.printView();

        hardDisk.turnOn();
        hardDisk.printView();

        System.out.println("Caricamento solo dei servizi essenziali");
        operativeSystem.turnOn();
        operativeSystem.printView();
    }

}
