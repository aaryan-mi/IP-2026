import java.util.Scanner;

public class FoodDeliveryFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance: ");
        int distance = sc.nextInt();

        int charge;
        if (distance <= 3) {
            charge = 40;
        } else {
            charge = 40 + (distance - 3) * 10;
        }

        System.out.println("Delivery Charge: " + charge);

        sc.close();
    }
}
