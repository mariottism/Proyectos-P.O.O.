public class Appoiment {
    
    private Doctor doctor;
    private Patient patient;

    public Appoiment(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        
        this.doctor.addAppoiment(this);
        this.patient.addAppoiment(this);
    }

    public Doctor getDoctor() {
        return doctor;
    }
    
}
