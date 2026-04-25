package esercizio_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighwayManager {
    private static Scanner inInt = new Scanner(System.in);
    private static Scanner inString = new Scanner(System.in);
    private static Scanner inDouble = new Scanner(System.in);

    private static String readPlate(String vehicleType) {
        System.out.print("Inserisci targa del " + vehicleType + ": ");
        return inString.nextLine();
    }

    private static double readSpeed(String vehicleType) {
        System.out.print("Inserisci velocità del " + vehicleType + " (km/h): ");
        return inDouble.nextDouble();
    }

    private static int readAxles(String vehicleType) {
        System.out.print("Inserisci numero di assi del " + vehicleType + ": ");
        return inInt.nextInt();
    }

    private static Car addNewCar() {
        String plate = readPlate("auto");
        double speed = readSpeed("auto");
        int axles = readAxles("auto");
        System.out.print("Inserisci cilindrata dell'auto (cc): ");
        int displacement = inInt.nextInt();
        return new Car(plate, speed, axles, displacement);
    }

    private static Truck addNewTruck() {
        String plate = readPlate("camion");
        double speed = readSpeed("camion");
        int axles = readAxles("camion");
        System.out.print("Inserisci peso del carico (kg): ");
        double cargoWeight = inDouble.nextDouble();
        System.out.print("Inserisci tipo di carico: ");
        String cargoType = inString.nextLine();
        return new Truck(plate, speed, axles, cargoWeight, cargoType);
    }

    private static Motorcycle addNewMotorcycle() {
        String plate = readPlate("moto");
        double speed = readSpeed("moto");
        int axles = readAxles("moto");
        System.out.print("Inserisci cilindrata della moto (cc): ");
        int engineSize = inInt.nextInt();
        return new Motorcycle(plate, speed, axles, engineSize);
    }

    private static void addNewVehicle(ArrayList<Vehicle> vehicles) {
        System.out.println("===============");
        System.out.println("1 - Auto");
        System.out.println("2 - Camion");
        System.out.println("3 - Moto");
        System.out.println("===============");

        int userChoice = inInt.nextInt();

        switch (userChoice) {
            case 1:
                vehicles.add(addNewCar());
                break;
            case 2:
                vehicles.add(addNewTruck());
                break;
            case 3:
                vehicles.add(addNewMotorcycle());
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }

    private static void showVehicleMenu(ArrayList<Vehicle> vehicles) {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + " - Targa: " + vehicles.get(i).getPlate());
        }
    }

    private static boolean isValidInput(int userChoice, int min, int max) {
        return userChoice >= min && userChoice <= max;
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>(List.of(
                new Car("AB123CD", 130.0, 2, 1600),
                new Car("EF456GH", 110.0, 2, 2000),
                new Truck("MI789TK", 90.0, 4, 8000.0, "Alimentari"),
                new Truck("TO321LM", 80.0, 6, 15000.0, "Materiali edili"),
                new Motorcycle("MO001AB", 150.0, 2, 600),
                new Motorcycle("MO002CD", 120.0, 2, 1000)));

        boolean flagRun = true;

        while (flagRun) {
            System.out.println("===============");
            System.out.println("1 - Aggiungi veicolo");
            System.out.println("2 - Calcola pedaggio");
            System.out.println("3 - Stampa info veicolo");
            System.out.println("4 - Stampa tutti i veicoli");
            System.out.println("0 - Esci");
            System.out.println("===============");

            int userChoice = inInt.nextInt();

            if (!isValidInput(userChoice, 0, 4)) {
                System.out.println("Input non valido. Riprova");
                continue;
            }

            switch (userChoice) {
                case 0:
                    flagRun = false;
                    break;
                case 1:
                    addNewVehicle(vehicles);
                    break;
                case 2: {
                    showVehicleMenu(vehicles);
                    int userInput = inInt.nextInt();

                    if (!isValidInput(userInput, 1, vehicles.size())) {
                        System.out.println("Selezione non valida");
                        break;
                    }

                    Vehicle selected = vehicles.get(userInput - 1);
                    System.out.println("Pedaggio per " + selected.getPlate() + ": "
                            + String.format("%.2f", selected.calculateToll()) + "$");
                    break;
                }
                case 3: {
                    showVehicleMenu(vehicles);
                    int userInput = inInt.nextInt();

                    if (!isValidInput(userInput, 1, vehicles.size())) {
                        System.out.println("Selezione non valida");
                        break;
                    }

                    System.out.println(vehicles.get(userInput - 1).printInfo());
                    break;
                }
                case 4:
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle.printInfo());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
