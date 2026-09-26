import java.util.Scanner;

class BankAccount {
    private String customerName;
    private double balance;

    public BankAccount(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }
}

public class ATMWithdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdrawal Amount: ");
        double amount = sc.nextDouble();

        BankAccount account = new BankAccount(name, balance);
        System.out.println("Customer: " + account.getCustomerName());

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal Successful");
            System.out.println("Withdrawn Amount: " + amount);
            System.out.println("Remaining Balance: " + account.getBalance());
        } else {
            System.out.println("Withdrawal Failed. Insufficient Balance");
        }
        sc.close();
    }
}
