Architettura MVC

fabrica -> Singleton

AbstracVehicle:
    String model;
    String plate;

AbstracVehicle -> Car / Moto

VehicleFactory -> contiene lista veicoli prodotti
VehicleFactory -> notifica le view quando produce

VehicleObserver interface
VehicleFactoryView implements VehicleObserver

viewCar <-> viewMoto

ogni volta che viene prodotto un nuovo veicolo le view devono essere notificate

VehicleObserver

Controller:
    riceve richiesta
    crea/accetta veicolo
    chiama factory.produceVehicle(...)

Decorator:
    arricchisce AbstractVehicle con accessori/info extra

extra:
    magazzino
    storico