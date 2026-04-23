import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // ===================ESERCIZIO=1==============================
        // Student student1 = new Student("Francesco", 10);

        // System.out.println(student1.toString());

        // student1.setVote(8);

        // System.out.println(student1.toString());

        // ArrayList<Student> students = new ArrayList<>(List.of(
        // new Student("Gianni", 6),
        // new Student("Francesco", 10),
        // new Student("Daniele", 8),
        // new Student("Antonio", 9)));

        // Scanner inString = new Scanner(System.in);

        // System.out.println("Inserisci nome da cercare: ");
        // String name = inString.nextLine();

        // for (Student student : students) {
        // if (student.getName().equalsIgnoreCase(name)) {
        // System.out.println("Studente trovato: " + student.toString());
        // break;
        // }
        // }

        // inString.close();

        // ==========================ESERCIZIO=2========================================

        Plane plane1 = new Plane("Aereo 1", 100, "1234");
        Plane plane2 = new Plane("Aereo 2", 250, "0987");
        Plane plane3 = new Plane("Aereo 3", 50, "8653");

        Pilot pilot1 = new Pilot("Armando", "34EB54", 120);
        Pilot pilot2 = new Pilot("Ferdinando", "56TY80", 210);

        PlaneCompany company1 = new PlaneCompany("Compagnia 1");
        PlaneCompany company2 = new PlaneCompany("Compagnia 2");

        company1.addPlane(plane1);
        company1.addPlane(plane2);
        company2.addPlane(plane3);

        company1.addPilot(pilot2);
        company2.addPilot(pilot1);

        company1.printCompany();
        company2.printCompany();
    }
}
