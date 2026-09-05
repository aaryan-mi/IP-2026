import java.util.Scanner;

public class ElectricityUsageMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        if (units <= 100) {
            System.out.println("Usage Category: Low Usage");
        } else if (units <= 300) {
            System.out.println("Usage Category: Moderate Usage");
        } else if (units <= 500) {
            System.out.println("Usage Category: High Usage");
        } else {
            System.out.println("Usage Category: Very High Usage");
        }

        sc.close();
    }
}
