import java.util.Scanner;

public class StudentResultDashboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Java marks: ");
        int java = sc.nextInt();

        System.out.print("Enter DBMS marks: ");
        int dbms = sc.nextInt();

        System.out.print("Enter Maths marks: ");
        int maths = sc.nextInt();

        int total = java + dbms + maths;
        double percentage = total / 3.0;

        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage + "%");

        if (java >= 40 && dbms >= 40 && maths >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        sc.close();
    }
}
