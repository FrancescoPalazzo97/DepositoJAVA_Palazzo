package esempio_1;

// Classe Pig che eredita AbstractAnimal
public class Pig extends AbstractAnimal implements AnimalActions {

    public void sound() {
        System.out.println("Oink!");
    }

    @Override
    public void sleep() {
        System.out.println("The pig is sleeping");
    }

    @Override
    public void run() {
        System.out.println("The pig is running");
    }

}
