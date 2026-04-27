package esercizio_1.classes;

public class HistoryStudent extends Student {

    public HistoryStudent(String name, int age, String classroom) {
        super(name, age, classroom);
    }

    @Override
    public void describeRole() {
        System.out.println("Sono uno studente di Storia della classe " + getClassroom());
    }
}
