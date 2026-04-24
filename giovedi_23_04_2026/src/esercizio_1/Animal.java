package esercizio_1;

public class Animal {
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sound() {
        System.out.println("Verso generico...");
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                "}";
    }

}
