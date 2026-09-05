import java.util.Scanner;

public class DailyStepGoalTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;
        for (int i = 1; i <= 7; i++) {
            System.out.print("Day " + i + ": ");
            int steps = sc.nextInt();
            total = total + steps;
        }

        double average = total / 7.0;

        System.out.println("Total Steps: " + total);
        System.out.printf("Average Steps: %.2f%n", average);

        if (total >= 70000) {
            System.out.println("Weekly Goal: ACHIEVED");
        } else {
            System.out.println("Weekly Goal: NOT ACHIEVED");
        }

        sc.close();
    }
}
