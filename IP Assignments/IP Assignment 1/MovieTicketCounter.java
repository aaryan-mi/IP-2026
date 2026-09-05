import java.util.Scanner;

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();

        int price;
        if (age >= 18) {
            price = 200;
        } else {
            price = 120;
        }

        int total = price * tickets;

        System.out.println("Ticket Price: " + price);
        System.out.println("Total Cost: " + total);

        sc.close();
    }
}
