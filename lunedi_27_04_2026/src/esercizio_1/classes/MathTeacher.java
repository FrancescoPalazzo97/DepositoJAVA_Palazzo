package esercizio_1.classes;

public class MathTeacher extends Teacher {

    public MathTeacher(String name, int age) {
        super(name, age, "Matematica");
    }

    @Override
    public void addStudent(Student student) {
        if (!(student instanceof MathStudent)) {
            System.out.println("Il docente " + getName() + " accetta solo studenti di Matematica!");
            return;
        }

        super.addStudent(student);
    }

    @Override
    public void describeRole() {
        System.out.println("Sono un insegnante di Matematica");
    }

}
