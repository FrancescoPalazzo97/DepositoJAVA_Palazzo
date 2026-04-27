package esercizio_1;

import java.util.ArrayList;
import java.util.Scanner;

import esercizio_1.classes.AbstractPerson;
import esercizio_1.classes.HistoryStudent;
import esercizio_1.classes.HistoryTeacher;
import esercizio_1.classes.MathStudent;
import esercizio_1.classes.MathTeacher;
import esercizio_1.classes.Student;

public class SchoolManager {
    private static ArrayList<MathStudent> mathStudents = new ArrayList<>();
    private static ArrayList<HistoryStudent> historyStudents = new ArrayList<>();
    private static ArrayList<MathTeacher> mathTeachers = new ArrayList<>();
    private static ArrayList<HistoryTeacher> historyTeachers = new ArrayList<>();

    private static Scanner inInt = new Scanner(System.in);
    private static Scanner inString = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = inInt.nextInt();
            switch (choice) {
                case 1 -> addNewStudent("Matematica");
                case 2 -> addNewStudent("Storia");
                case 3 -> addNewTeacher("Matematica");
                case 4 -> addNewTeacher("Storia");
                case 5 -> assignStudentToTeacher();
                case 6 -> assignVote();
                case 7 -> printVotesOfStudent();
                case 0 -> System.out.println("Arrivederci!");
                default -> System.out.println("Scelta non valida!");
            }
        }
    }

    private static boolean isValidIndex(int i, ArrayList<?> list) {
        return i >= 0 && i < list.size();
    }

    private static String readName() {
        System.out.print("Nome: ");
        String name = inString.nextLine();
        return name;
    }

    private static int readAge() {
        System.out.print("Età: ");
        int age = inInt.nextInt();
        return age;
    }

    private static String readClassroom() {
        System.out.print("Classe: ");
        String classroom = inString.nextLine();
        return classroom;
    }

    private static void printMenu() {
        System.out.println("\n=== GESTIONE SCUOLA ===");
        System.out.println("1. Crea studente di Matematica");
        System.out.println("2. Crea studente di Storia");
        System.out.println("3. Crea insegnante di Matematica");
        System.out.println("4. Crea insegnante di Storia");
        System.out.println("5. Assegna studente a docente");
        System.out.println("6. Assegna voto");
        System.out.println("7. Stampa voti di uno studente");
        System.out.println("0. Esci");
        System.out.print("Scelta: ");
    }

    private static void addNewStudent(String type) {
        String name = readName();
        int age = readAge();
        String classroom = readClassroom();

        switch (type) {
            case "Matematica":
                mathStudents.add(new MathStudent(name, age, classroom));
                System.out.println("Studente di Matematica " + name + " creato!");
                break;

            case "Storia":
                historyStudents.add(new HistoryStudent(name, age, classroom));
                System.out.println("Studente di Storia " + name + " creato!");
                break;

            default:
                System.out.println("Tipo non valido!");
                break;
        }
    }

    private static void addNewTeacher(String type) {
        String name = readName();
        int age = readAge();

        switch (type) {
            case "Matematica":
                mathTeachers.add(new MathTeacher(name, age));
                System.out.println("Insegnante di Matematica " + name + " creato");
                break;

            case "Storia":
                historyTeachers.add(new HistoryTeacher(name, age));
                System.out.println("Insegnante di Storia " + name + " creato");
                break;

            default:
                System.out.println("Tipo non valido!");
                break;
        }
    }

    private static void printPeople(ArrayList<? extends AbstractPerson> people) {
        for (int i = 0; i < people.size(); i++) {
            System.out.println((i + 1) + " - " + people.get(i).getName());
        }
    }

    private static void assignStudentToTeacher() {
        System.out.println("\n--- Assegna studente a docente ---");
        System.out.println("1 - Matematica");
        System.out.println("2 - Storia");

        System.out.print("Scegli la materia: ");
        int courseChoice = inInt.nextInt();

        switch (courseChoice) {
            case 1: {
                if (mathStudents.isEmpty() || mathTeachers.isEmpty()) {
                    System.out.println("Serve almeno uno studente e un docente");
                    return;
                }

                System.out.println("Studenti di matematica:");
                printPeople(mathStudents);
                System.out.print("Scegli lo studente: ");
                int studentChoice = inInt.nextInt() - 1;

                System.out.println("Insegnanti di matematica");
                printPeople(mathTeachers);
                System.out.print("Scegli insegnante: ");
                int teacherChoice = inInt.nextInt() - 1;

                if (!isValidIndex(studentChoice, mathStudents) || !isValidIndex(teacherChoice, mathTeachers)) {
                    System.out.println("Indice non valido!");
                    return;
                }

                mathTeachers.get(teacherChoice).addStudent(mathStudents.get(studentChoice));
                System.out.println("Lo studente è stato assegnato!");
                break;
            }

            case 2: {
                if (historyStudents.isEmpty() || historyTeachers.isEmpty()) {
                    System.out.println("Serve almeno uno studente e un docente");
                    return;
                }

                System.out.println("Studenti di storia");
                printPeople(historyStudents);
                System.out.print("Scegli lo studente: ");
                int studentChoice = inInt.nextInt() - 1;

                System.out.println("Insegnanti di storia");
                printPeople(historyTeachers);
                System.out.print("Scegli insegnante: ");
                int teacherChoice = inInt.nextInt() - 1;

                if (!isValidIndex(studentChoice, historyStudents) || !isValidIndex(teacherChoice, historyTeachers)) {
                    System.out.println("Indice non valido!");
                    return;
                }

                historyTeachers.get(teacherChoice).addStudent(historyStudents.get(studentChoice));
                System.out.println("Lo studente è stato assegnato!");
                break;
            }

            default:
                System.out.println("Scelta non valida!");
                break;
        }
    }

    private static void assignVote() {
        System.out.println("\n--- Assegna voto ---");
        System.out.println("1 - Matematica");
        System.out.println("2 - Storia");

        System.out.print("Materia: ");
        int courseChoice = inInt.nextInt();

        switch (courseChoice) {
            case 1: {
                if (mathTeachers.isEmpty()) {
                    System.out.println("Nessun docente presente!");
                    return;
                }

                System.out.println("Insegnanti di matematica");
                printPeople(mathTeachers);
                System.out.print("Scegli insegnante: ");
                int teacherChoice = inInt.nextInt() - 1;

                if (!isValidIndex(teacherChoice, mathTeachers)) {
                    System.out.println("Indice non valido!");
                    return;
                }

                MathTeacher teacher = mathTeachers.get(teacherChoice);
                ArrayList<Student> students = teacher.getStudents();

                if (students.isEmpty()) {
                    System.out.println("Questo insegnante non ha studenti assegnati!");
                    return;
                }

                System.out.println("Studenti di " + teacher.getName() + ":");
                printPeople(students);
                System.out.print("Scegli lo studente: ");
                int mathStudentChoice = inInt.nextInt() - 1;

                System.out.print("Inserisci voto (1-10): ");
                int mathVote = inInt.nextInt();

                if (!isValidIndex(mathStudentChoice, students)) {
                    System.out.println("Indice non valido!");
                    return;
                }

                teacher.assignVote(students.get(mathStudentChoice), mathVote);
                break;
            }

            case 2: {
                if (historyTeachers.isEmpty()) {
                    System.out.println("Nessun docente presente!");
                    return;
                }

                System.out.println("Insegnanti di storia");
                printPeople(historyTeachers);
                System.out.print("Scegli insegnante: ");
                int historyTeacherChoice = inInt.nextInt() - 1;

                if (!isValidIndex(historyTeacherChoice, historyTeachers)) {
                    System.out.println("Indice non valido!");
                    return;
                }

                HistoryTeacher teacher = historyTeachers.get(historyTeacherChoice);
                ArrayList<Student> students = teacher.getStudents();

                if (students.isEmpty()) {
                    System.out.println("Questo docente non ha studenti assegnati");
                    return;
                }

                System.out.println("Studenti di " + teacher.getName() + ":");
                printPeople(students);
                System.out.print("Scegli lo studente: ");
                int studentChoice = inInt.nextInt() - 1;

                System.out.print("Inserisci voto (1-10): ");
                int historyVote = inInt.nextInt();

                if (!isValidIndex(studentChoice, students)) {
                    System.out.println("Indice non valido!");
                    return;
                }

                teacher.assignVote(students.get(studentChoice), historyVote);
                break;
            }

            default:
                System.out.println("Scelta non valida!");
                break;
        }
    }

    private static void printVotesOfStudent() {
        System.out.println("\n--- Stampa voti studente ---");
        System.out.println("1 - Matematica");
        System.out.println("2 - Storia");

        System.out.print("Materia: ");
        int courseChoice = inInt.nextInt();

        switch (courseChoice) {
            case 1: {
                if (mathStudents.isEmpty()) {
                    System.out.println("Nessuno studente di Matematica.");
                    return;
                }

                System.out.println("Studenti di Matematica:");
                printPeople(mathStudents);
                System.out.print("Scegli studente: ");
                int choice = inInt.nextInt() - 1;

                if (!isValidIndex(choice, mathStudents)) {
                    System.out.println("Indice non valido!");
                    return;
                }

                mathStudents.get(choice).printVotes();
                break;
            }

            case 2: {
                if (historyStudents.isEmpty()) {
                    System.out.println("Nessuno studente di Storia.");
                    return;
                }

                System.out.println("Studenti di Storia:");
                printPeople(historyStudents);
                System.out.print("Scegli studente: ");
                int choice = inInt.nextInt() - 1;

                if (!isValidIndex(choice, historyStudents)) {
                    System.out.println("Indice non valido!");
                    return;
                }

                historyStudents.get(choice).printVotes();
                break;
            }

            default:
                System.out.println("Scelta non valida!");
                break;
        }
    }
}
