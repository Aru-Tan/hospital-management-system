public class Appointment {

    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String date;
    private String status;

    public Appointment(int appointmentId, String patientName, String doctorName, String date) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.status = "Scheduled";
    }

    public void reschedule(String newDate) {
        this.date = newDate;
        this.status = "Rescheduled";
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + appointmentId +
                ", patient='" + patientName + '\'' +
                ", doctor='" + doctorName + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
