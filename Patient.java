public class Patient extends Person {

    private String bloodType;

    public Patient(int id, String name, int age, String phone, String bloodType) {
        super(id, name, age, phone); // super() first
        this.bloodType = bloodType;
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public void work() {
        System.out.println(name + " is getting treatment.");
    }

    public boolean isMinor() {
        return age < 18;
    }

    public String getAgeCategory() {
        if (age < 18) return "Child";
        else if (age < 60) return "Adult";
        else return "Senior";
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return getRole() + " {" + basicInfo() + ", BloodType: " + bloodType + "}";
    }
}