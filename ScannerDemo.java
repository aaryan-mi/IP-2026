import java.util.Scanner;
public class ScannerDemo {
    public static void main(String[] args) {
        int num1 = 0;
        String firstName;
        String secondName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        num1 = sc.nextInt();
        System.out.println("Entered number is "+num1);
        System.out.println("First Name? : ");
        firstName = sc.next();
        System.out.println("Second Name? : ");
        secondName = sc.next();
        System.out.println("First Name is "+firstName);
        System.out.println("Second Name is "+secondName);
    }
}
