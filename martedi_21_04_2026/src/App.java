import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // ==========================EX 1=================================

        // Book book1 = new Book("Il colore venuto dallo spazio", "Lovecraft", 20);

        // System.out.println(book1.toString());

        // Book book2 = new Book("Il signore degli anelli", "Tolkien", 20);

        // System.out.println(book2.toString());

        // =======================EX 2===============================

        // Person[] people = {
        // new Person("Francesco", 28, "Ragalna"),
        // new Person()
        // };

        // for (Person person : people) {
        // System.out.println(person.toString());
        // }

        // =====================EX 3=============================

        // Garage myGarage = new Garage();
        // Scanner inInt = new Scanner(System.in);
        // Scanner inString = new Scanner(System.in);
        // boolean flag = false;

        // while (!flag) {
        // System.out.println("--------------");
        // System.out.println("1 - Aggiungi una nuova macchina");
        // System.out.println("2 - Visualizza le macchine presenti nel carage");
        // System.out.println("0 - Esci");
        // System.out.println("--------------");

        // int userChoice = inInt.nextInt();

        // switch (userChoice) {
        // case 0:
        // flag = true;
        // break;

        // case 1:
        // System.out.print("Inserisci targa: ");
        // String plate = inString.nextLine();
        // System.out.print("\nInserisci modello: ");
        // String model = inString.nextLine();
        // Car newCar = new Car(plate, model);
        // myGarage.addNewCar(newCar);
        // break;

        // case 2:
        // myGarage.printGarage();
        // break;

        // default:
        // break;
        // }
        // }

        // inInt.close();
        // inString.close();

        // ===================================EX
        // 4==============================================

        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);
        Scanner inDouble = new Scanner(System.in);
        boolean flagRun = false;
        ArrayList<BankAccount> accounts = new ArrayList<>();
        boolean isLogged = false;
        int indexAccount = -1;

        while (!flagRun) {
            System.out.println("--------------");
            System.out.println("1 - Accedi");
            System.out.println("2 - Registrati");
            System.out.println("0 - Esci");
            System.out.println("--------------");

            int userChoice = inInt.nextInt();

            switch (userChoice) {
                case 0:
                    isLogged = false;
                    flagRun = true;
                    break;

                case 1:
                    System.out.println("Inserisci nome utente:");
                    String name = inString.nextLine();
                    for (int i = 0; i < accounts.size(); i++) {
                        BankAccount account = accounts.get(i);
                        if (account.getAccountHolderName().equalsIgnoreCase(name)) {
                            indexAccount = i;
                            isLogged = true;
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Inserisci nome: ");
                    String newName = inString.nextLine();
                    BankAccount newAccount = new BankAccount(newName, 0);
                    accounts.add(newAccount);
                    break;

                default:
                    break;
            }

            boolean isIndexAccountValid = indexAccount >= 0 && indexAccount < accounts.size();

            while (isLogged && isIndexAccountValid) {
                BankAccount account = accounts.get(indexAccount);

                System.out.println("--------------");
                System.out.println("1 - Mostra saldo");
                System.out.println("2 - Deposito");
                System.out.println("3 - Prelievo");
                System.out.println("0 - Esci");
                System.out.println("--------------");

                int userChoice2 = inInt.nextInt();

                switch (userChoice2) {
                    case 0:
                        isLogged = false;
                        break;

                    case 1:
                        account.displayBalance();
                        break;

                    case 2:
                        System.out.print("Inserisci somma da depositare: ");
                        double newAmount = inDouble.nextDouble();
                        account.deposit(newAmount);
                        break;

                    case 3:
                        System.out.print("Inserisci la somma da prelevare: ");
                        double amount = inDouble.nextDouble();
                        account.withdraw(amount);
                        break;

                    default:
                        break;
                }

            }

        }

        inInt.close();
        inString.close();
        inDouble.close();
    }
}
