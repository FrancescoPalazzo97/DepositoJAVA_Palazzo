package esercizio_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>(List.of(
                new Dog("Pino", 5),
                new Cat("Gina", 2)));

        for (Animal animal : animals) {
            System.out.println("Nome: " + animal.getName() + ", Età: " + animal.getAge());
            System.out.print("Verso: ");
            animal.sound();
        }

        Scanner inputString = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);

        Zoo zoo = new Zoo();

        System.out.println("Quanti animali vuoi inserire?");

        int numbersOfAnimals = inputInt.nextInt();

        for (int i = 0; i < numbersOfAnimals; i++) {

            System.out.println("=========Animale " + (i + 1) + "===========");
            System.out.println("Di che tipo di animale si tratta?");
            System.out.println("1 - Gatto");
            System.out.println("2 - Cane");
            System.out.println("====================");

            int userChoice = inputInt.nextInt();

            zoo.addNewAnimal(userChoice);
        }

        zoo.printZoo();

        inputString.close();
        inputInt.close();

    }
}
