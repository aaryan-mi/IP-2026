import java.util.Scanner;

public class MiniBankingMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 10000;
        int choice;

        do {
            System.out.println("\n1 = Deposit");
            System.out.println("2 = Withdraw");
            System.out.println("3 = Check Balance");
            System.out.println("4 = Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                double deposit = sc.nextDouble();
                balance = balance + deposit;
                System.out.println("Amount Deposited: " + deposit);
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double withdraw = sc.nextDouble();
                if (withdraw > balance) {
                    System.out.println("Insufficient Balance");
                } else {
                    balance = balance - withdraw;
                    System.out.println("Amount Withdrawn: " + withdraw);
                }
            } else if (choice == 3) {
                System.out.println("Current Balance: " + balance);
            } else if (choice == 4) {
                System.out.println("Thank you for using the banking system.");
            } else {
                System.out.println("Invalid Choice");
            }
        } while (choice != 4);

        sc.close();
    }
}
