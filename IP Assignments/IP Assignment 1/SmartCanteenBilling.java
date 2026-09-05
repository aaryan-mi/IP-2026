import java.util.Scanner;

public class SmartCanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter item price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        double originalAmount = price * quantity;
        double discount = 0;

        if (originalAmount >= 500) {
            discount = originalAmount * 0.10;
        }

        double finalAmount = originalAmount - discount;

        System.out.println("Original Amount: " + originalAmount);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + finalAmount);

        sc.close();
    }
}
