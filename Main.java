public class Main {
    public static void main(String[] args) {

        System.out.println("=== Hospital Management System ===\n");

        Patient p1 = new Patient(1, "Aruzhan T.", 17, "O+");
        Doctor d1 = new Doctor(101, "Dr. Ali", "Surgeon", 12);
        Appointment a1 = new Appointment(
                5001,
                p1.getFullName(),
                d1.getName(),
                "20.03.2025"
        );

        System.out.println(p1);
        System.out.println("Is minor: " + p1.isMinor());
        System.out.println("Category: " + p1.getAgeCategory());

        System.out.println();

        System.out.println(d1);
        System.out.println("Experienced: " + d1.isExperienced());
        System.out.println("Can perform surgery: " + d1.canPerformSurgery());

        System.out.println();

        System.out.println(a1);
        a1.reschedule("25.03.2025");
        System.out.println("After reschedule: " + a1);

        System.out.println("\n=== Program Complete ===");
    }
}
