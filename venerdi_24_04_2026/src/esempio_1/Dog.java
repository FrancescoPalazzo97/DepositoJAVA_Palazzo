package esempio_1;

public class Dog extends Animal implements Movement {

    @Override
    public void sound() {
        System.out.println("Woof");
    }

    @Override
    public void move() {
        System.out.println("Il cane cammina");
    }

    @Override
    public void run() {
        System.out.println("Il cane corre");
    }

}
