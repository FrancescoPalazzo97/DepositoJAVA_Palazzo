// Esercizio 2
public class Person {
    private String name;
    private int age;
    private String city;

    public Person() {
        this.name = "Sconosciuto";
        this.age = 0;
        this.city = "Sconosciuta";
    }

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
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

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  name='" + getName() + "',\n" +
                "  age='" + getAge() + "',\n" +
                "  city='" + getCity() + "',\n" +
                "}\n";
    }

}
