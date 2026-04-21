// Esercizio 3
public class BankAccount {
    private String accountHolderName;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        System.out.println("Deposito effettuato");
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Impossibile effettuare il prelievo. Saldo non diponibile");
            return;
        }

        this.balance -= amount;
        System.out.println("Prelievo effettuato");
    }

    public void displayBalance() {
        System.out.println("Saldo disponibile: " + this.balance);
    }

    @Override
    public String toString() {
        return "{" +
                " accountHolderName='" + getAccountHolderName() + "'" +
                ", balance='" + getBalance() + "'" +
                "}";
    }

}
