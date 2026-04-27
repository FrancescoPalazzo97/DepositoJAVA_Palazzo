package esercizio_1.classes;

import java.util.ArrayList;
import esercizio_1.interfaces.Registrable;

public class Student extends AbstractPerson implements Registrable {

    private String classroom;
    private ArrayList<Integer> votes;

    public Student(String name, int age, String classroom) {
        super(name, age);
        this.classroom = classroom;
        this.votes = new ArrayList<>();
    }

    public String getClassroom() {
        return this.classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public ArrayList<Integer> getVotes() {
        return this.votes;
    }

    public void addVote(int vote) {
        this.votes.add(vote);
    }

    @Override
    public void registration() {
        System.out.println("Registrazione tramite modulo online");
    }

    @Override
    public void describeRole() {
        System.out.println("Sono uno studente della classe " + classroom);
    }

    public void printVotes() {
        if (votes.isEmpty()) {
            System.out.println(getName() + " non ha ancora ricevuto voti.");
            return;
        }
        System.out.print("Voti di " + getName() + ": ");
        for (int i = 0; i < votes.size(); i++) {
            System.out.print(votes.get(i));
            if (i < votes.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }

}
