package esempio_1;

public class Pig extends Animal implements Movement {

    @Override
    public void sound() {
        System.out.println("Oink");
    }

    @Override
    public void move() {
        System.out.println("Il maiale cammina");
    }

    @Override
    public void run() {
        System.out.println("Il maialle corre");
    }

}
