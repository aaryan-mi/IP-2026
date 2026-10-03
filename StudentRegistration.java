import java.util.Scanner;

public class StudentRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // =========================
        // NAME VALIDATION
        // =========================

        String name;

        while (true) {

            System.out.print("Enter Student Name: ");
            name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            }
            else if (!name.matches("[a-zA-Z ]+")) {
                System.out.println(
                    "Name can contain only alphabets and spaces."
                );
            }
            else {
                break;
            }
        }


        // =========================
        // AGE VALIDATION
        // =========================

        int age;

        while (true) {

            System.out.print("Enter Age: ");

            if (sc.hasNextInt()) {

                age = sc.nextInt();

                if (age >= 17 && age <= 60) {
                    break;
                }

                System.out.println(
                    "Age must be between 17 and 60."
                );

            } else {

                System.out.println(
                    "Please enter a valid integer."
                );

                sc.next();
            }
        }

        sc.nextLine(); // consume newline


        // =========================
        // EMAIL VALIDATION
        // =========================

        String email;

        while (true) {

            System.out.print("Enter Email: ");
            email = sc.nextLine().trim();

            if (email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                break;

            } else {

                System.out.println(
                    "Please enter a valid email."
                );
            }
        }


        // =========================
        // MOBILE VALIDATION
        // =========================

        String mobile;

        while (true) {

            System.out.print("Enter Mobile Number: ");
            mobile = sc.nextLine().trim();

            if (mobile.matches("[0-9]{10}")) {
                break;
            }

            System.out.println(
                "Mobile number must contain exactly 10 digits."
            );
        }


        // =========================
        // GENDER VALIDATION
        // =========================

        String gender;

        while (true) {

            System.out.print("Enter Gender (M/F/O): ");
            gender = sc.nextLine().trim().toUpperCase();

            if (gender.equals("M") ||
                gender.equals("F") ||
                gender.equals("O")) {

                break;

            } else {

                System.out.println(
                    "Please enter M, F or O."
                );
            }
        }


        // =========================
        // COURSE VALIDATION
        // =========================

        String course;

        while (true) {

            System.out.print(
                "Enter Course (Java/Angular/React): "
            );

            course = sc.nextLine().trim();

            if (course.equalsIgnoreCase("Java")) {

                course = "Java";
                break;

            }
            else if (course.equalsIgnoreCase("Angular")) {

                course = "Angular";
                break;

            }
            else if (course.equalsIgnoreCase("React")) {

                course = "React";
                break;

            }
            else {

                System.out.println(
                    "Invalid course. Choose Java, Angular or React."
                );
            }
        }


        // =========================
        // MARKS VALIDATION
        // =========================

        double marks;

        while (true) {

            System.out.print("Enter Marks (0-100): ");

            if (sc.hasNextDouble()) {

                marks = sc.nextDouble();

                if (marks >= 0 && marks <= 100) {
                    break;
                }

                System.out.println(
                    "Marks must be between 0 and 100."
                );

            } else {

                System.out.println(
                    "Please enter a valid number."
                );

                sc.next();
            }
        }


        // =========================
        // DISPLAY RESULT
        // =========================

        System.out.println("\n==============================");
        System.out.println("     STUDENT REGISTRATION");
        System.out.println("==============================");

        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Email   : " + email);
        System.out.println("Mobile  : " + mobile);
        System.out.println("Gender  : " + gender);
        System.out.println("Course  : " + course);
        System.out.println("Marks   : " + marks);

        System.out.println("==============================");

        sc.close();
    }
}