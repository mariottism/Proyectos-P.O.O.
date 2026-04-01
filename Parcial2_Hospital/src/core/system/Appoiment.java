package core.hospital.system;

import core.person.Doctor;
import core.person.Patient;
/**
 * Esta clase funciona como una "Clase de Asociación".
 * Su objetivo es conectar a un Doctor con un Patient en un evento específico (una cita).
 */
public class Appoiment {
    
    // 1. ATRIBUTOS: Las dos partes que se unen en la cita.
    private Doctor doctor;
    private Patient patient;

    // 2. CONSTRUCTOR: Recibe los dos objetos ya creados (Agregación).
    public Appoiment(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        
        /* *  3. NOTIFICACIÓN BIDIRECCIONAL (Fundamental):
         * Una cita no existe si las partes no se enteran. 
         * Al crear la cita, este objeto se "anuncia" a sí mismo ante el doctor
         * y ante el paciente usando 'this'.
         */
        this.doctor.addAppoiment(this);
        this.patient.addAppoiment(this);
    }

    // 4. GETTERS:
    // El Hospital lo usará para saber qué doctor está en la cita y sacar su ID.
    public Doctor getDoctor() {
        return doctor;
    }
    
}
