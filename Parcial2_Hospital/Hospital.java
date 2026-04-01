public class Hospital {
    private ArrayList<Team> teams;
    private ArrayList<Ward> wards;
    private ArrayList<Patient> patients;

  //Constructor con listas inicializadas para evitar errores
    public Hospital() {
        this.teams = new ArrayList<>();
        this.wards = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
  
  //setter
  // El main dice: hospital.addTeam(0, 10); - El primer número es el ID del equipo y el segundo es el ID del médico líder.
  //Es una composición porque el Hospital crea el equipo y el equipo nace con su líder.
  public void addTeam(int teamId, int leaderId) {
    // Creamos al líder (ConsultantDoctor)
    ConsultantDoctor leader = new ConsultantDoctor(leaderId);
    
    // Creamos el equipo y le pasamos su líder
    Team newTeam = new Team(teamId, leader);
    
    // Lo guardamos en la lista del Hospital
    this.teams.add(newTeam);
}
  // Método de Búsqueda. El main usa mucho hospital.getTeam(0)
  public Team getTeam(int id) {
    for (Team t : teams) {
        if (t.getId() == id) {
            return t; // Retorna el objeto completo, no solo el ID
        }
    }
    return null; // Si no lo encuentra
}
  // En el main --> hospital.addPatient(hospital.getWard(10), hospital.getTeam(0), 20);.
  // Aquí el Hospital no crea el Ward ni el Team en ese momento, sino que recibe los que ya existen.
  public void addPatient(Ward w, Team t, int patientId) {
    Patient newPatient = new Patient(patientId);
      
    // Establecemos las relaciones (Agregación)
    newPatient.setWard(w);
    newPatient.setTeam(t);
    
    // Importante: El hospital guarda al paciente en su lista general
    this.patients.add(newPatient);
}
  // El main pide hospital.numberDoctorsPatient();.
  public void numberDoctorsPatient() {
      //Para cada elemento p de tipo Patient que esté en mi Lista patients, haz lo siguiente...
    for (Patient p : patients) {
        // p.getDoctors() devuelve el ArrayList de doctores del paciente
        int cantidad = p.getDoctors().size(); 
        System.out.println("Patient " + p.getId() + " has " + cantidad + " doctors");
    }
}
}
