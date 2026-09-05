import java.util.Scanner;

public class ParkingLotCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        int bikes = 0;
        int cars = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Vehicle " + i + " type: ");
            int type = sc.nextInt();

            if (type == 1) {
                bikes++;
            } else if (type == 2) {
                cars++;
            }
        }

        System.out.println("Total Bikes: " + bikes);
        System.out.println("Total Cars: " + cars);

        sc.close();
    }
}
