public class Patient {
    
    // ATRIBUTOS: Representan las flechas que salen de Patient en el UML.
    private int id;
    private Team team; // Relación 1:1 con un equipo.
    private Ward ward; // Relación 1:1 con un pabellón.
    
    // Multiplicidad 0..*: Se usan listas para guardar muchas citas y muchos doctores.
    private ArrayList<Appoiment> appoiments;
    private ArrayList<Doctor> doctors;

    // CONSTRUCTOR: recibe el equipo y el pabellón de una vez.
    public Patient(int id, Team team, Ward ward) {
        this.id = id;
        this.team = team;
        this.ward = ward;
        
        // Inicializar SIEMPRE las listas para evitar NullPointerException.
        this.appoiments = new ArrayList<>();
        this.doctors = new ArrayList<>();
        
        /* RELACIÓN BIDIRECCIONAL es clave!
         * No basta con que el Paciente sepa en qué Equipo está. 
         * El Equipo también debe saber que tiene un nuevo Paciente
         * Al hacer 'this.team.addPatient(this)', el paciente se "anota" a sí mismo 
         * en la lista del equipo y del pabellón apenas nace.
         */
        this.team.addPatient(this);
        this.ward.addPatient(this);
    }

    // MÉTODOS DE ACCIÓN
    
    // addDoctor: Antes de añadir, verifica si el doctor ya estaba (contains).
    // Esto evita que un paciente tenga al mismo doctor repetido en su lista.
    public boolean addDoctor(Doctor doctor) {
        if (!this.doctors.contains(doctor)) {
            this.doctors.add(doctor);
            return true;
        }
        return false;
    }
    
    public boolean addAppoiment(Appoiment appoiment) {
        if (!this.appoiments.contains(appoiment)) {
            this.appoiments.add(appoiment);
            return true;
        }
        return false;
    }

    /* MÉTODOS PARA REPORTES (Lo que el Main imprime)
     * En lugar de devolver la lista completa, devolvemos solo lo que el Main pide.
     */
    
    // Recorre las citas y extrae solo los IDs de los doctores involucrados.
    // Útil para el listado final de "Patient X has an appoiment with doctor Y".
    public ArrayList<Integer> getDoctorsId() {
        ArrayList<Integer> doctorsId = new ArrayList<>();
        for (Appoiment appoiment : this.appoiments) {
            doctorsId.add(appoiment.getDoctor().getId());
        }
        return doctorsId;
    }

    // Encapsulamiento: El Hospital no cuenta las citas, le pregunta al Paciente cuántas tiene.
    public int numberOfAppoiments() {
        return this.appoiments.size();
    }

    public int numberOfDoctors() {
        return this.doctors.size();
    }
    
    // Getters estándar para que el Hospital pueda consultar datos.
    public int getId() { 
        return id;
    }
    public Team getTeam() { 
        return team; 
    }
    public Ward getWard() { 
        return ward;
    }
}
