public class Ward {
    
    private int id;
    private ArrayList<Patient> patients;
    // Constructor
    public Ward(int id) {
        this.id = id;
        this.patients = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
    
    public boolean addPatient(Patient patient) {
        if (!this.patients.contains(patient)) {
            this.patients.add(patient);
            return true;
        }
        return false;
    }
    
}
