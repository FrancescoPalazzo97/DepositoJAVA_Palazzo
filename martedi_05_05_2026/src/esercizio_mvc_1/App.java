package esercizio_mvc_1;

import java.util.Scanner;

import esercizio_mvc_1.controllers.VehicleFactoryController;
import esercizio_mvc_1.models.AbstractVehicle;
import esercizio_mvc_1.models.Car;
import esercizio_mvc_1.models.Moto;
import esercizio_mvc_1.models.decorators.NavigatorDecorator;
import esercizio_mvc_1.models.decorators.SafetyPackDecorator;
import esercizio_mvc_1.models.decorators.SportPaintDecorator;
import esercizio_mvc_1.views.VehicleFactoryView;

public class App {
    private static final Scanner inInt = new Scanner(System.in);
    private static final Scanner inString = new Scanner(System.in);

    public static void main(String[] args) {
        VehicleFactoryView vehicleFactoryView = new VehicleFactoryView();
        VehicleFactoryController vehicleFactoryController = new VehicleFactoryController(vehicleFactoryView);

        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            int choice = inInt.nextInt();

            switch (choice) {
                case 1:
                    produceCar(vehicleFactoryController);
                    break;

                case 2:
                    produceMoto(vehicleFactoryController);
                    break;

                case 3:
                    vehicleFactoryController.printView();
                    break;

                case 0:
                    isRunning = false;
                    System.out.println("Chiusura applicazione.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }

        inString.close();
        inInt.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("==== Fabbrica veicoli ====");
        System.out.println("1 - Produci auto");
        System.out.println("2 - Produci moto");
        System.out.println("3 - Visualizza veicoli prodotti");
        System.out.println("0 - Esci");
        System.out.print("Scegli un'opzione: ");
    }

    private static void produceCar(VehicleFactoryController vehicleFactoryController) {
        String model = readText("Modello auto: ");
        String plate = readText("Targa auto: ");

        AbstractVehicle vehicle = new Car(model, plate);
        vehicle = addAccessories(vehicle);

        vehicleFactoryController.addNewVehicle(vehicle);
    }

    private static void produceMoto(VehicleFactoryController vehicleFactoryController) {
        String model = readText("Modello moto: ");
        String plate = readText("Targa moto: ");

        AbstractVehicle vehicle = new Moto(model, plate);
        vehicle = addAccessories(vehicle);

        vehicleFactoryController.addNewVehicle(vehicle);
    }

    private static AbstractVehicle addAccessories(AbstractVehicle vehicle) {
        if (readYesNo("Aggiungere navigatore? (s/n): ")) {
            vehicle = new NavigatorDecorator(vehicle);
        }

        if (readYesNo("Aggiungere verniciatura sportiva? (s/n): ")) {
            vehicle = new SportPaintDecorator(vehicle);
        }

        if (readYesNo("Aggiungere pacchetto sicurezza? (s/n): ")) {
            vehicle = new SafetyPackDecorator(vehicle);
        }

        return vehicle;
    }

    private static String readText(String message) {
        String text;

        do {
            System.out.print(message);
            text = inString.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Il valore non è valido!.");
            }
        } while (text.isEmpty());

        return text;
    }

    private static boolean readYesNo(String message) {
        while (true) {
            System.out.print(message);
            String answer = inString.nextLine().trim().toLowerCase();

            if (answer.equals("s")) {
                return true;
            }

            if (answer.equals("n")) {
                return false;
            }

            System.out.println("Rispondi con s oppure n.");
        }
    }
}
