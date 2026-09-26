import java.util.Scanner;

abstract class BankAccountBase {
    private String customerName;
    private double balance;

    public BankAccountBase(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
    }

    protected void addToBalance(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void deposit(double amount) {
        addToBalance(amount);
    }

    public void deposit(double amount, String chequeNumber) {
        addToBalance(amount);
    }

    abstract double calculateInterest(double rate);
}

class SavingsAccount extends BankAccountBase {
    public SavingsAccount(String customerName, double balance) {
        super(customerName, balance);
    }

    double calculateInterest(double rate) {
        return getBalance() * rate / 100;
    }
}

class CurrentAccount extends BankAccountBase {
    public CurrentAccount(String customerName, double balance) {
        super(customerName, balance);
    }

    double calculateInterest(double rate) {
        return 0;
    }
}

public class SmartBanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Customer: ");
        String name = sc.nextLine();
        System.out.print("Account Type: ");
        String type = sc.nextLine();
        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Deposit: ");
        double deposit = sc.nextDouble();
        System.out.print("Interest Rate: ");
        double rate = sc.nextDouble();

        BankAccountBase account;
        if (type.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(name, balance);
        } else {
            account = new CurrentAccount(name, balance);
        }

        System.out.println("Customer: " + account.getCustomerName());
        System.out.println("Account Type: " + type);
        System.out.println("Initial Balance: " + balance);

        account.deposit(deposit);
        System.out.println("Deposit: " + deposit);
        System.out.println("Current Balance: " + account.getBalance());

        double interest = account.calculateInterest(rate);
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("Calculated Interest: " + interest);

        account.deposit(interest);
        System.out.println("Final Balance: " + account.getBalance());
        sc.close();
    }
}
