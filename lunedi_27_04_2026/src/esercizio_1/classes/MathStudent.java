package esercizio_1.classes;

public class MathStudent extends Student {

    public MathStudent(String name, int age, String classroom) {
        super(name, age, classroom);
    }

    @Override
    public void describeRole() {
        System.out.println("Sono uno studente di Matematica della classe " + getClassroom());
    }

}
