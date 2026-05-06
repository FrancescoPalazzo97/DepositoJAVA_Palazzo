package esercizio_mvc_strategy_facade.interfaces;

import esercizio_mvc_strategy_facade.controllers.BiosController;
import esercizio_mvc_strategy_facade.controllers.HardDiskController;
import esercizio_mvc_strategy_facade.controllers.OperativeSystemController;

public interface BootStrategy {
    public void boot(BiosController bios, HardDiskController hardDisk, OperativeSystemController operativeSystem);
}
