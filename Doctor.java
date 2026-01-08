public class Doctor extends Person {

    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, int age, String phone, String specialization, int experienceYears) {
        super(id, name, age, phone);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
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
        if (specialization != null && !specialization.trim().isEmpty()) this.specialization = specialization.trim();
        else {
            System.out.println("Invalid specialization. Setting specialization = General");
            this.specialization = "General";
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) this.experienceYears = experienceYears;
        else {
            System.out.println("Invalid experience. Setting experienceYears = 0");
            this.experienceYears = 0;
        }
    }

    @Override
    public String toString() {
        return getRole() + " {" + basicInfo() +
                ", Specialization: " + specialization +
                ", ExperienceYears: " + experienceYears + "}";
    }
}
