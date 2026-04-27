package esercizio_1.classes;

public class HistoryTeacher extends Teacher {

    public HistoryTeacher(String name, int age) {
        super(name, age, "Storia");
    }

    @Override
    public void addStudent(Student student) {
        if (!(student instanceof HistoryStudent)) {
            System.out.println("Il docente " + getName() + " accetta solo gli studenti di Storia");
            return;
        }

        super.addStudent(student);
    }

    @Override
    public void describeRole() {
        System.out.println("Sono un insegnante di Storia");
    }

}
