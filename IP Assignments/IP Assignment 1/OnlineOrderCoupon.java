import java.util.Scanner;

public class OnlineOrderCoupon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter order amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter coupon code: ");
        String coupon = sc.next();

        double discount = 0;

        if (amount >= 1000 && coupon.equals("SAVE10")) {
            discount = amount * 0.10;
        }

        double finalAmount = amount - discount;

        System.out.println("Discount: " + discount);
        System.out.println("Final Payable Amount: " + finalAmount);

        sc.close();
    }
}
