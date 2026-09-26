import java.util.Scanner;

abstract class Payment {
    abstract void pay(double amount);
}

class UPIPayment extends Payment {
    void pay(double amount) {
        System.out.println("UPI Payment Successful");
    }
}

class CreditCardPayment extends Payment {
    void pay(double amount) {
        System.out.println("Credit Card Payment Successful");
    }
}

class NetBankingPayment extends Payment {
    void pay(double amount) {
        System.out.println("Net Banking Payment Successful");
    }
}

public class OnlinePaymentGateway {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Payment Method: ");
        String method = sc.nextLine();

        Payment payment;
        if (method.equalsIgnoreCase("UPI")) {
            payment = new UPIPayment();
        } else if (method.equalsIgnoreCase("Credit Card")) {
            payment = new CreditCardPayment();
        } else {
            payment = new NetBankingPayment();
        }

        System.out.println("Payment Amount: " + amount);
        System.out.println("Payment Method: " + method);
        payment.pay(amount);
        sc.close();
    }
}
