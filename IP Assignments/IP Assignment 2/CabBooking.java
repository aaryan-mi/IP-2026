import java.util.Scanner;

abstract class Cab {
    abstract double calculateFare(double distance, double rate);
}

class MiniCab extends Cab {
    double calculateFare(double distance, double rate) {
        return distance * rate;
    }
}

class SedanCab extends Cab {
    double calculateFare(double distance, double rate) {
        return distance * rate;
    }
}

class SUVCab extends Cab {
    double calculateFare(double distance, double rate) {
        return distance * rate;
    }
}

public class CabBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cab Type: ");
        String type = sc.nextLine();
        System.out.print("Distance: ");
        double distance = sc.nextDouble();
        System.out.print("Rate: ");
        double rate = sc.nextDouble();

        Cab cab;
        if (type.equalsIgnoreCase("Mini")) {
            cab = new MiniCab();
        } else if (type.equalsIgnoreCase("Sedan")) {
            cab = new SedanCab();
        } else {
            cab = new SUVCab();
        }

        double fare = cab.calculateFare(distance, rate);

        System.out.println("Cab Type: " + type);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Rate: " + rate + "/km");
        System.out.println("Total Fare: " + fare);
        sc.close();
    }
}
