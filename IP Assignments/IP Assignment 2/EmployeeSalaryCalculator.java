import java.util.Scanner;

abstract class Employee {
    abstract double calculateSalary(double value1, double value2);
}

class FullTimeEmployee extends Employee {
    double calculateSalary(double monthlySalary, double bonus) {
        return monthlySalary + bonus;
    }
}

class PartTimeEmployee extends Employee {
    double calculateSalary(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate;
    }
}

class Intern extends Employee {
    double calculateSalary(double stipend, double unused) {
        return stipend;
    }
}

public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Employee Type: ");
        String type = sc.nextLine();
        System.out.print("Hours Worked: ");
        double hours = sc.nextDouble();
        System.out.print("Hourly Rate: ");
        double rate = sc.nextDouble();

        Employee employee;
        if (type.equalsIgnoreCase("Part-Time")) {
            employee = new PartTimeEmployee();
        } else if (type.equalsIgnoreCase("Full-Time")) {
            employee = new FullTimeEmployee();
        } else {
            employee = new Intern();
        }

        double salary = employee.calculateSalary(hours, rate);

        System.out.println("Employee Type: " + type);
        System.out.println("Hours Worked: " + hours);
        System.out.println("Hourly Rate: " + rate);
        System.out.println("Salary: " + salary);
        sc.close();
    }
}
