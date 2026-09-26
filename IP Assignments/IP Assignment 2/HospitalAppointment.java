import java.util.Scanner;

abstract class Doctor {
    String patient;
    String time;

    void bookAppointment(String patient, String time) {
        this.patient = patient;
        this.time = time;
    }

    abstract void showAppointment();
}

class GeneralPhysician extends Doctor {
    void showAppointment() {
        System.out.println("Patient: " + patient);
        System.out.println("Doctor Type: General Physician");
        System.out.println("Appointment Time: " + time);
        System.out.println("Appointment Confirmed");
    }
}

class Dentist extends Doctor {
    void showAppointment() {
        System.out.println("Patient: " + patient);
        System.out.println("Doctor Type: Dentist");
        System.out.println("Appointment Time: " + time);
        System.out.println("Appointment Confirmed");
    }
}

class Cardiologist extends Doctor {
    void showAppointment() {
        System.out.println("Patient: " + patient);
        System.out.println("Doctor Type: Cardiologist");
        System.out.println("Appointment Time: " + time);
        System.out.println("Appointment Confirmed");
    }
}

public class HospitalAppointment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Doctor Type: ");
        String type = sc.nextLine();
        System.out.print("Patient: ");
        String patient = sc.nextLine();
        System.out.print("Appointment Time: ");
        String time = sc.nextLine();

        Doctor doctor;
        if (type.equalsIgnoreCase("Dentist")) {
            doctor = new Dentist();
        } else if (type.equalsIgnoreCase("Cardiologist")) {
            doctor = new Cardiologist();
        } else {
            doctor = new GeneralPhysician();
        }

        doctor.bookAppointment(patient, time);
        doctor.showAppointment();
        sc.close();
    }
}
