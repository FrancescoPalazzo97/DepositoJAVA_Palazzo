package esercizio_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryManager {
    private static Scanner inInt = new Scanner(System.in);
    private static Scanner inString = new Scanner(System.in);
    private static Scanner inFloat = new Scanner(System.in);

    private static String readPlate(String vehicleType) {
        System.out.print("Inserisci targa del nuovo " + vehicleType + ": ");
        return inString.nextLine();
    }

    private static float readMaxLoad(String vehicleType) {
        System.out.print("Inserisci il carico massimo del nuovo " + vehicleType + " (kg): ");
        return inFloat.nextFloat();
    }

    private static Van addNewVan() {
        return new Van(readPlate("furgone"), readMaxLoad("furgone"));
    }

    private static Drone addNewDrone() {
        return new Drone(readPlate("drone"), readMaxLoad("drone"));
    }

    private static void addNewVehicle(ArrayList<DeliveryVehicle> vehicles) {
        System.out.println("===============");
        System.out.println("1 - Furgone");
        System.out.println("2 - Drone");
        System.out.println("===============");

        int userChoice = inInt.nextInt();

        switch (userChoice) {
            case 1:
                vehicles.add(addNewVan());
                break;
            case 2:
                vehicles.add(addNewDrone());
                break;
            default:
                break;
        }
    }

    private static void showVehicleMenu(ArrayList<DeliveryVehicle> vehicles) {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("\n" + (i + 1) + " - " + vehicles.get(i).printInfo());
        }
    }

    private static boolean isValidInput(int userChoice, int min, int max) {
        return userChoice >= min && userChoice <= max;
    }

    public static void main(String[] args) {
        ArrayList<DeliveryVehicle> vehicles = new ArrayList<>(List.of(
                new Van("AB123CD", 1000f),
                new Van("EF456GH", 1500f),
                new Van("IJ789KL", 800f),
                new Drone("DRONE-01", 5f),
                new Drone("DRONE-02", 3.5f),
                new Drone("DRONE-03", 7f)));

        boolean flagRun = true;

        while (flagRun) {
            System.out.println("===============");
            System.out.println("1 - Aggiungi nuovi veicoli");
            System.out.println("2 - Consegna un pacco");
            System.out.println("3 - Traccia una consegna");
            System.out.println("0 - Esci");
            System.out.println("===============");

            int userChoice = inInt.nextInt();

            if (!isValidInput(userChoice, 0, 3)) {
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
                    DeliveryVehicle selected = vehicles.get(userInput - 1);
                    System.out.print("Inserisci peso del pacco (kg): ");
                    float weight = inFloat.nextFloat();

                    if (weight > selected.getMaxLoad()) {
                        System.out.println("Errore: il peso supera il carico massimo del veicolo ("
                                + selected.getMaxLoad() + " kg)");
                        break;
                    }

                    System.out.print("Inserisci destinazione: ");
                    String dest = inString.nextLine();
                    selected.packDelivery(dest);
                    break;
                }
                case 3: {
                    showVehicleMenu(vehicles);
                    int userInput = inInt.nextInt();
                    DeliveryVehicle selected = vehicles.get(userInput - 1);

                    if (!(selected instanceof Trackable)) {
                        System.out.println("Questo veicolo non supporta il tracking");
                        break;
                    }

                    System.out.print("Inserisci codice tracking: ");
                    String code = inString.nextLine();
                    ((Trackable) selected).trackDelivery(code);
                    break;
                }
                default:
                    break;
            }
        }
    }
}
