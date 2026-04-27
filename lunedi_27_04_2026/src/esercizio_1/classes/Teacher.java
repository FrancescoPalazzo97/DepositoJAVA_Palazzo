package esercizio_1.classes;

import java.util.ArrayList;

import esercizio_1.interfaces.Registrable;

public class Teacher extends AbstractPerson implements Registrable {
    private String course;
    private ArrayList<Student> students;

    public Teacher(String name, int age, String course) {
        super(name, age);
        this.course = course;
        this.students = new ArrayList<>();
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void assignVote(Student s, int vote) {
        if (students.contains(s)) {
            s.addVote(vote);
            System.out.println("Voto " + vote + " assegnato a " + s.getName() + ".");
        } else {
            System.out.println("Lo studente " + s.getName() + " non è in questa lista.");
        }
    }

    @Override
    public void describeRole() {
        System.out.println("Sono un docente di " + course);
    }

    @Override
    public void registration() {
        System.out.println("Registrazione tramite segreteria didattica");
    }

}
