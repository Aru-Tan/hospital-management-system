import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // test data
        patients.add(new Patient(1, "Aruzhan T.", 17, "O+"));
        doctors.add(new Doctor(101, "Dr. Ali", "Surgeon", 12));
        appointments.add(new Appointment(5001, "Aruzhan T.", "Dr. Ali", "20.03.2025"));

        boolean run = true;

        while (run) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Add Appointment");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // important

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    addAppointment();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 0:
                    System.out.println("Program finished.");
                    run = false;
                    break;
                default:
                    System.out.println("Wrong option.");
            }
        }

        scanner.close();
    }

    static void addPatient() {
        System.out.print("Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Full name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Blood type: ");
        String blood = scanner.nextLine();

        Patient p = new Patient(id, name, age, blood);
        patients.add(p);

        System.out.println("Patient added.");
    }

    static void viewPatients() {
        System.out.println("\n--- Patients ---");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i));
        }
    }

    static void addDoctor() {
        System.out.print("Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        Doctor d = new Doctor(id, name, spec, exp);
        doctors.add(d);

        System.out.println("Doctor added.");
    }

    static void viewDoctors() {
        System.out.println("\n--- Doctors ---");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println(doctors.get(i));
        }
    }

    static void addAppointment() {
        System.out.print("Appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Patient name: ");
        String patientName = scanner.nextLine();

        System.out.print("Doctor name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Date: ");
        String date = scanner.nextLine();

        Appointment a = new Appointment(id, patientName, doctorName, date);
        appointments.add(a);

        System.out.println("Appointment added.");
    }

    static void viewAppointments() {
        System.out.println("\n--- Appointments ---");
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println(appointments.get(i));
        }
    }
}
