import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Person> people = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        seedData();

        boolean run = true;

        while (run) {
            showMenu();
            int choice = readInt("Choose option: ");

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewAllPeople();
                    break;
                case 5:
                    demonstratePolymorphism();
                    break;
                case 6:
                    viewByType();
                    break;
                case 7:
                    addAppointment();
                    break;
                case 8:
                    viewAppointments();
                    break;
                case 9:
                    cancelAppointmentById();
                    break;
                case 10:
                    rescheduleAppointmentById();
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

    static void showMenu() {
        System.out.println("\n========================================");
        System.out.println("           HOSPITAL SYSTEM (Week 4)");
        System.out.println("========================================");
        System.out.println("1. Add Person (Parent Object)");
        System.out.println("2. Add Patient (Child Type 1)");
        System.out.println("3. Add Doctor (Child Type 2)");
        System.out.println("4. View All People (Polymorphic)");
        System.out.println("5. Demonstrate Polymorphism (work())");
        System.out.println("6. View by Type (instanceof)");
        System.out.println("7. Add Appointment");
        System.out.println("8. View Appointments");
        System.out.println("9. Cancel Appointment (by ID)");
        System.out.println("10. Reschedule Appointment (by ID)");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    static void seedData() {
        // parent object
        people.add(new Person(1, "Sam", 30, "+77000000001"));

        // children objects in the SAME list (polymorphism)
        people.add(new Patient(2, "Aruzhan T.", 17, "+77000000002", "O+"));
        people.add(new Doctor(3, "Dr. Ali", 40, "+77000000003", "Surgeon", 12));

        appointments.add(new Appointment(5001, "Aruzhan T.", "Dr. Ali", "20.03.2025"));
    }

    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // important
        return value;
    }

    static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    static void addPerson() {
        System.out.println("\n--- ADD PERSON (Parent) ---");
        int id = readInt("ID: ");
        String name = readLine("Name: ");
        int age = readInt("Age: ");
        String phone = readLine("Phone: ");

        people.add(new Person(id, name, age, phone));
        System.out.println("Person added.");
    }

    static void addPatient() {
        System.out.println("\n--- ADD PATIENT (Child) ---");
        int id = readInt("ID: ");
        String name = readLine("Full name: ");
        int age = readInt("Age: ");
        String phone = readLine("Phone: ");
        String blood = readLine("Blood type: ");

        Person p = new Patient(id, name, age, phone, blood); // parent reference
        people.add(p);

        System.out.println("Patient added.");
    }

    static void addDoctor() {
        System.out.println("\n--- ADD DOCTOR (Child) ---");
        int id = readInt("ID: ");
        String name = readLine("Name: ");
        int age = readInt("Age: ");
        String phone = readLine("Phone: ");
        String spec = readLine("Specialization: ");
        int exp = readInt("Experience years: ");

        Person d = new Doctor(id, name, age, phone, spec, exp); // parent reference
        people.add(d);

        System.out.println("Doctor added.");
    }

    static void viewAllPeople() {
        System.out.println("\n--- ALL PEOPLE ---");
        if (people.size() == 0) {
            System.out.println("No people found.");
            return;
        }

        for (int i = 0; i < people.size(); i++) {
            System.out.println((i + 1) + ") " + people.get(i));
        }
    }

    static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO (work()) ---");
        if (people.size() == 0) {
            System.out.println("No people found.");
            return;
        }

        for (int i = 0; i < people.size(); i++) {
            Person x = people.get(i);
            System.out.print(x.getRole() + ": ");
            x.work();
        }
    }

    static void viewByType() {
        System.out.println("\n--- VIEW BY TYPE ---");
        System.out.println("1. Only Patients");
        System.out.println("2. Only Doctors");
        System.out.print("Choose: ");

        int option = readInt("");

        if (option == 1) {
            System.out.println("\n--- PATIENTS ---");
            for (int i = 0; i < people.size(); i++) {
                Person x = people.get(i);
                if (x instanceof Patient) {
                    Patient p = (Patient) x;
                    System.out.println(p);
                    System.out.println("   Minor: " + p.isMinor() + ", Category: " + p.getAgeCategory());
                }
            }
        } else if (option == 2) {
            System.out.println("\n--- DOCTORS ---");
            for (int i = 0; i < people.size(); i++) {
                Person x = people.get(i);
                if (x instanceof Doctor) {
                    Doctor d = (Doctor) x;
                    System.out.println(d);
                    System.out.println("   Experienced: " + d.isExperienced() + ", Can surgery: " + d.canPerformSurgery());
                }
            }
        } else {
            System.out.println("Wrong option.");
        }
    }

    static void addAppointment() {
        System.out.println("\n--- ADD APPOINTMENT ---");
        int id = readInt("Appointment ID: ");
        String patientName = readLine("Patient name: ");
        String doctorName = readLine("Doctor name: ");
        String date = readLine("Date: ");

        appointments.add(new Appointment(id, patientName, doctorName, date));
        System.out.println("Appointment added.");
    }

    static void viewAppointments() {
        System.out.println("\n--- APPOINTMENTS ---");
        if (appointments.size() == 0) {
            System.out.println("No appointments found.");
            return;
        }

        for (int i = 0; i < appointments.size(); i++) {
            System.out.println((i + 1) + ") " + appointments.get(i));
        }
    }

    static Appointment findAppointmentById(int id) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId() == id) {
                return appointments.get(i);
            }
        }
        return null;
    }

    static void cancelAppointmentById() {
        System.out.println("\n--- CANCEL APPOINTMENT ---");
        int id = readInt("Enter appointment ID: ");
        Appointment a = findAppointmentById(id);

        if (a == null) {
            System.out.println("Appointment not found.");
            return;
        }

        a.cancel();
        System.out.println("Cancelled: " + a);
    }

    static void rescheduleAppointmentById() {
        System.out.println("\n--- RESCHEDULE APPOINTMENT ---");
        int id = readInt("Enter appointment ID: ");
        Appointment a = findAppointmentById(id);

        if (a == null) {
            System.out.println("Appointment not found.");
            return;
        }

        String newDate = readLine("Enter new date: ");
        a.reschedule(newDate);
        System.out.println("Rescheduled: " + a);
    }
}