package esercizio_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {
    private ArrayList<Animal> animals;
    private static final Scanner inputString = new Scanner(System.in);
    private static final Scanner inputInt = new Scanner(System.in);

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public Zoo(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void addNewAnimal(int userChoice) {
        if (userChoice < 1 && userChoice > 2) {
            System.out.println("Input non valido");
            return;
        }

        System.out.print("Inserisci nome: ");
        String inputName = inputString.nextLine();
        System.out.print("Inserisci età: ");
        int inputAge = inputInt.nextInt();

        switch (userChoice) {
            case 1:
                this.animals.add(new Cat(inputName, inputAge));
                break;

            case 2:
                this.animals.add(new Dog(inputName, inputAge));
                break;

            default:
                break;
        }
    }

    public void printZoo() {
        boolean foundCat = false;
        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                if (!foundCat) {
                    System.out.println("===Gatti===");
                    foundCat = true;
                }
                System.out.println(animal.toString());
            }
        }

        boolean foundDog = false;
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                if (!foundDog) {
                    System.out.println("===Cani===");
                    foundDog = true;
                }
                System.out.println(animal.toString());
            }
        }
    }

}
