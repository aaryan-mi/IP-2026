import java.util.Scanner;

abstract class Vehicle {
    abstract double calculateRent(int days, double ratePerDay);
}

class Car extends Vehicle {
    double calculateRent(int days, double ratePerDay) {
        return days * ratePerDay;
    }
}

class Bike extends Vehicle {
    double calculateRent(int days, double ratePerDay) {
        return days * ratePerDay;
    }
}

class Scooter extends Vehicle {
    double calculateRent(int days, double ratePerDay) {
        return days * ratePerDay;
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vehicle Type: ");
        String type = sc.nextLine();
        System.out.print("Number of Days: ");
        int days = sc.nextInt();
        System.out.print("Rate Per Day: ");
        double rate = sc.nextDouble();

        Vehicle vehicle;
        if (type.equalsIgnoreCase("Car")) {
            vehicle = new Car();
        } else if (type.equalsIgnoreCase("Bike")) {
            vehicle = new Bike();
        } else {
            vehicle = new Scooter();
        }

        double totalRent = vehicle.calculateRent(days, rate);

        System.out.println("Vehicle Type: " + type);
        System.out.println("Rental Days: " + days);
        System.out.println("Rate Per Day: " + rate);
        System.out.println("Total Rental Amount: " + totalRent);
        sc.close();
    }
}
