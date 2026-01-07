public class Doctor extends Person {

    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, int age, String phone, String specialization, int experienceYears) {
        super(id, name, age, phone); // super() first
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void work() {
        System.out.println(name + " is treating patients (" + specialization + ").");
    }

    public boolean isExperienced() {
        return experienceYears >= 10;
    }

    public boolean canPerformSurgery() {
        return specialization != null && specialization.equalsIgnoreCase("Surgeon");
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return getRole() + " {" + basicInfo() +
                ", Specialization: " + specialization +
                ", ExperienceYears: " + experienceYears + "}";
    }
}
