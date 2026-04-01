package core.person;

import core.hospital.system.Team;
/**
 * Esta clase HEREDA de Doctor.
 * Un JuniorDoctor ES UN Doctor. 
 * A diferencia del ConsultantDoctor, no tiene la responsabilidad de liderar un equipo.
 */
public class JuniorDoctor extends Doctor {
    
    // 1. CONSTRUCTOR:
    public JuniorDoctor(int id, Team team) {
        /* * LA PALABRA 'super':
         * Es OBLIGATORIA aquí porque la clase padre (Doctor) no tiene un 
         * constructor vacío. 
         * 'super' envía el ID y el Equipo a la clase Doctor para que ella 
         * se encargue de inicializar todo y de anotar al junior en la lista del equipo.
         */
        super(id, team);
    }
    
    // Nota: No hay atributos ni métodos extra. Toda su funcionalidad
    // (id, lista de pacientes, lista de citas) ya está definida en Doctor.
}
