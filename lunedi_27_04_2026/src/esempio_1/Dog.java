package esempio_1;

// Classe Dog che eredita AbstractAnimal
public class Dog extends AbstractAnimal implements AnimalActions {

    public void sound() {
        System.out.println("Woof!");
    }

    @Override
    public void sleep() {
        System.out.println("The dog is sleeping");
    }

    @Override
    public void run() {
        System.out.println("The dog is running");
    }

}
