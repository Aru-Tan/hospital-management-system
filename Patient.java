public class Patient {

    private int patientId;
    private String fullName;
    private int age;
    private String bloodType;

    public Patient(int patientId, String fullName, int age, String bloodType) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.bloodType = bloodType;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isMinor() {
        return age < 18;
    }

    public String getAgeCategory() {
        if (age < 18) return "Child";
        else if (age < 60) return "Adult";
        else return "Senior";
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + patientId +
                ", name='" + fullName + '\'' +
                ", age=" + age +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
