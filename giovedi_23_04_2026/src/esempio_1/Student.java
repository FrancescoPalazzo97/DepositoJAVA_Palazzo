package esempio_1;

public class Student extends Person {
    private String school;

    public Student(String name, String school) {
        super(name);
        this.school = school;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void hello() {
        super.hello();
        System.out.println("Vado alla scuola " + this.school);
    }
}
