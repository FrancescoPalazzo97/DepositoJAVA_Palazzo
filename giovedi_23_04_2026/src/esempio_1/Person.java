package esempio_1;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Ciao sono " + this.name);
    }
}
