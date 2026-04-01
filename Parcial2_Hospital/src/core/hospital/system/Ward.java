package core.hospital.system;

import core.person.Patient;
import java.util.ArrayList;

public class Ward {
    
    // ATRIBUTOS:
    private int id;
    
    // Multiplicidad 0..*: Un pabellón alberga a muchos pacientes.
    private ArrayList<Patient> patients;

    // CONSTRUCTOR:
    public Ward(int id) {
        this.id = id;
        // REGLA DE ORO: Inicialización de la lista. 
        // Sin esto, el método addPatient daría error al primer intento.
        this.patients = new ArrayList<>();
    }

    // MÉTODOS DE ACCIÓN:
    
    /* * Registro de Pacientes (Bidireccionalidad):
     * Este método es llamado por el constructor de Patient: 'this.ward.addPatient(this)'.
     * 'contains' verifica que el paciente no sea registrado dos veces en el mismo pabellón.
     */
    public boolean addPatient(Patient patient) {
        if (!this.patients.contains(patient)) {
            this.patients.add(patient);
            return true;
        }
        return false;
    }

    // GETTERS:
    public int getId() {
        return id;
    }

    /* * Uso en Reportes:
     * El Hospital usará este getter para obtener la lista y recorrerla 
     * con un for-each al imprimir 'numberDoctorsPatient()'.
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }
}
