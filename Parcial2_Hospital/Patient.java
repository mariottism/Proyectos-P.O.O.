import java.util.ArrayList;

public class Patient {
    // Atributos simples
    private int id;
    
    // Relaciones 1 a 1 (Agregación: el objeto viene de afuera)
    private Ward ward;
    private Team team;
    
    // Relaciones 1 a muchos (Multiplicidad 0..* por ende usamos ArrayList)
    private ArrayList<Doctor> doctors;
    private ArrayList<Appoiment> appoiments; // Nota: El main lo escribe 'Appoiment'

  // Constructor
    public Patient(int id) {
        this.id = id;
        // Inicializar listas SIEMPRE en el constructor
        this.doctors = new ArrayList<>();
        this.appoiments = new ArrayList<>();
    }

    // Métodos para establecer las relaciones (Agregación)
    public void setWard(Ward ward) { 
      this.ward = ward;
    }
    public void setTeam(Team team) { 
      this.team = team; 
    }

    // Métodos para añadir a las listas (Paso a paso del Main)
    public void addDoctor(Doctor d) {
        this.doctors.add(d);
    }

    public void addAppoiment(Appoiment a) {
        this.appoiments.add(a);
    }

    // Getters necesarios para los reportes finales
    public int getId() {
      return id; 
    }
    public ArrayList<Doctor> getDoctors() { 
      return doctors; 
    }
    public ArrayList<Appoiment> getAppoiments() {
      return appoiments;
    }
  
}
