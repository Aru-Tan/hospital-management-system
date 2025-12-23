public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private int experienceYears;

    public Doctor(int doctorId, String name, String specialization, int experienceYears) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public boolean isExperienced() {
        return experienceYears >= 10;
    }

    public boolean canPerformSurgery() {
        return specialization.equalsIgnoreCase("Surgeon");
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + doctorId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experienceYears +
                '}';
    }
}
