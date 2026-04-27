package esempio_1;

public class Main {
    public static void main(String[] args) {
        // AbstractAnimal myAnimal = new AbstractAnimal(); // Cannot instantiate the
        // type AbstractAnimal

        AbstractAnimal myPig = new Pig();
        AbstractAnimal myDog = new Dog();

        // myAnimal.sound();
        myPig.sound();
        myDog.sound();
    }
}
