import java.util.Scanner;

class Recharge {
    void recharge(double amount) {
        System.out.println("Recharge Amount: " + amount);
        System.out.println("Recharge Successful");
    }

    void recharge(double amount, String mobileNumber) {
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Recharge Amount: " + amount);
        System.out.println("Recharge Successful");
    }

    void recharge(double amount, String mobileNumber, String planName) {
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Plan: " + planName);
        System.out.println("Recharge Amount: " + amount);
        System.out.println("Recharge Successful");
    }
}

public class MobileRecharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mobile Number: ");
        String mobile = sc.nextLine();
        System.out.print("Plan Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Plan Name: ");
        String planName = sc.nextLine();

        Recharge recharge = new Recharge();
        recharge.recharge(amount, mobile, planName);
        sc.close();
    }
}
