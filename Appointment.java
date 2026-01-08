public class Appointment {

    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String date;
    private String status;

    public Appointment(int appointmentId, String patientName, String doctorName, String date) {
        setAppointmentId(appointmentId);
        setPatientName(patientName);
        setDoctorName(doctorName);
        setDate(date);
        setStatus("Scheduled");
    }

    public int getAppointmentId() { return appointmentId; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getDate() { return date; }
    public String getStatus() { return status; }

    public void setAppointmentId(int appointmentId) {
        if (appointmentId > 0) this.appointmentId = appointmentId;
        else {
            System.out.println("Invalid appointment ID. Setting appointmentId = 1");
            this.appointmentId = 1;
        }
    }

    public void setPatientName(String patientName) {
        if (patientName != null && !patientName.trim().isEmpty()) this.patientName = patientName.trim();
        else {
            System.out.println("Invalid patient name. Setting patientName = Unknown");
            this.patientName = "Unknown";
        }
    }

    public void setDoctorName(String doctorName) {
        if (doctorName != null && !doctorName.trim().isEmpty()) this.doctorName = doctorName.trim();
        else {
            System.out.println("Invalid doctor name. Setting doctorName = Unknown");
            this.doctorName = "Unknown";
        }
    }

    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()) this.date = date.trim();
        else {
            System.out.println("Invalid date. Setting date = Unknown");
            this.date = "Unknown";
        }
    }

    public void setStatus(String status) {
        if (status == null) {
            this.status = "Scheduled";
            return;
        }
        String s = status.trim();
        if (s.equalsIgnoreCase("Scheduled") ||
                s.equalsIgnoreCase("Rescheduled") ||
                s.equalsIgnoreCase("Cancelled")) {
            this.status = capitalize(s);
        } else {
            System.out.println("Invalid status. Setting status = Scheduled");
            this.status = "Scheduled";
        }
    }

    public void reschedule(String newDate) {
        setDate(newDate);
        setStatus("Rescheduled");
    }

    public void cancel() {
        setStatus("Cancelled");
    }

    private String capitalize(String s) {
        if (s.isEmpty()) return s;
        String lower = s.toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
