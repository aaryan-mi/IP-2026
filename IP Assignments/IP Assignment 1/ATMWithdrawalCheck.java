import java.util.Scanner;

public class ATMWithdrawalCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter balance: ");
        int balance = sc.nextInt();

        System.out.print("Enter withdrawal amount: ");
        int withdrawal = sc.nextInt();

        if (withdrawal % 100 != 0) {
            System.out.println("Transaction Rejected");
            System.out.println("Amount must be a multiple of 100");
        } else if (withdrawal > balance) {
            System.out.println("Transaction Rejected");
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - withdrawal;
            System.out.println("Transaction Successful");
            System.out.println("Remaining Balance: " + balance);
        }

        sc.close();
    }
}
