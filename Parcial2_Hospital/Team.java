public class Team {
    
    // ATRIBUTOS: Definen la estructura del equipo médico.
    private int id;
    private ConsultantDoctor teamLeader; // Relación 1:1 (Composición/Agregación)
    
    // Multiplicidad 0..*: El equipo contiene una lista de doctores y una de sus pacientes.
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    // CONSTRUCTOR: Prepara el equipo con su ID.
    public Team(int id) {
        this.id = id;
        this.teamLeader = null; // Inicia sin líder hasta que se asigne uno.
        
        // Inicializar listas para evitar errores
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    /* MÉTODOS DE ACCIÓN: addDoctor y addPatient
     * Estos métodos son llamados por el Hospital o por el Paciente (en su constructor).
     * El uso de 'contains' asegura que no añadamos dos veces al mismo objeto.
     */
    public boolean addDoctor(Doctor doctor) {
        if (!this.doctors.contains(doctor)) {
            this.doctors.add(doctor);
            return true;
        }
        return false;
    }

    public boolean addPatient(Patient patient) {
        if (!this.patients.contains(patient)) {
            this.patients.add(patient);
            return true;
        }
        return false;
    }

    /* MÉTODOS PARA REPORTES (Lo que el Main imprime)
     * Este método es usado específicamente por 'hospital.numberPatientsTeam()'.
     */
    public int numberOfPatients() {
        return this.patients.size();
    }

    // GETTERS Y SETTERS ESTÁNDAR
    public int getId() { return id; }

    public ConsultantDoctor getTeamLeader() { 
      return teamLeader; 
    }

    public void setTeamLeader(ConsultantDoctor teamLeader) {
        this.teamLeader = teamLeader;
    }
    
    public ArrayList<Doctor> getDoctors() {
      return doctors;
    }

    public ArrayList<Patient> getPatients() { 
      return patients;
    }
}
