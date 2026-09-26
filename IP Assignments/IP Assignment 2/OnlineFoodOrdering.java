import java.util.Scanner;

class Order {
    double placeOrder(double price) {
        return price;
    }

    double placeOrder(double price, int quantity) {
        return price * quantity;
    }

    double placeOrder(double price, int quantity, double customizationCharge) {
        return (price * quantity) + customizationCharge;
    }
}

public class OnlineFoodOrdering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Item: ");
        String item = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Customization Charge: ");
        double customization = sc.nextDouble();

        Order order = new Order();
        double foodAmount = order.placeOrder(price, quantity);
        double finalAmount = order.placeOrder(price, quantity, customization);

        System.out.println("Item: " + item);
        System.out.println("Quantity: " + quantity);
        System.out.println("Food Amount: " + foodAmount);
        System.out.println("Customization: " + customization);
        System.out.println("Final Amount: " + finalAmount);
        sc.close();
    }
}
