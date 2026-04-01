/**
 * Esta es una CLASE ABSTRACTA. 
 * Significa que sirve como un "molde" base para otros tipos de doctores.
 * No se puede hacer 'new Doctor()', solo 'new JuniorDoctor()' o 'new ConsultantDoctor()'.
 */
public abstract class Doctor {
    
    // ATRIBUTOS PROTECTED: 
    // Se usa 'protected' en lugar de 'private' para que sus hijos 
    // (Junior y Consultant) puedan acceder a estas variables directamente.
    protected int id;
    protected Team team;
    protected ArrayList<Appoiment> appoiments;
    protected ArrayList<Patient> patients;

    // CONSTRUCTOR: 
    // Aunque la clase sea abstracta, tiene constructor para que sus hijos
    // lo llamen usando la palabra clave 'super'.
    public Doctor(int id, Team team) {
        this.id = id;
        this.team = team;
        
        // Inicialización de colecciones.
        this.appoiments = new ArrayList<>();
        this.patients = new ArrayList<>();
        
        /* * 3. REGISTRO AUTOMÁTICO (Bidireccionalidad):
         * Apenas se crea cualquier tipo de Doctor, él mismo se agrega 
         * a la lista de doctores de su equipo correspondiente.
         */
        this.team.addDoctor(this);
    }

    // MÉTODOS DE COMPORTAMIENTO (Se heredan a los hijos)
    
    public int getId() {
        return id;
    }
    
    // addAppoiment: Permite que el doctor sepa qué citas tiene programadas.
    public boolean addAppoiment(Appoiment appoiment) {
        if (!this.appoiments.contains(appoiment)) {
            this.appoiments.add(appoiment);
            return true;
        }
        return false;
    }
    
    // addPatient: El doctor guarda una lista de los pacientes que tiene a su cargo.
    public boolean addPatient(Patient patient) {
        if (!this.patients.contains(patient)) {
            this.patients.add(patient);
            return true;
        }
        return false;
    }
}
