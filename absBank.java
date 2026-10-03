abstract class BankAccount {

    protected double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    void showBalance() {
        System.out.println("Balance: " + balance);
    }
}


// Savings Account
class SavingsAccount extends BankAccount {

    SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Savings deposit: " + amount);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Savings withdrawal: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}


// Current Account
class CurrentAccount extends BankAccount {

    CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Current deposit: " + amount);
    }

    @Override
    void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Current withdrawal: " + amount);
    }
}


// Main class
public class absBank {

    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount(5000);

        savings.deposit(2000);
        savings.withdraw(1000);
        savings.showBalance();

        System.out.println();

        CurrentAccount current = new CurrentAccount(5000);

        current.deposit(3000);
        current.withdraw(2000);
        current.showBalance();
    }
}