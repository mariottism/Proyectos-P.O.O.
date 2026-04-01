package core.person;

import core.hospital.system.Team;

/**
 * Esta clase HEREDA de Doctor.
 * Un ConsultantDoctor ES UN Doctor, pero con el rol adicional de líder.
 */
public class ConsultantDoctor extends Doctor {
    
    // 1. ATRIBUTO DE ESPECIALIZACIÓN:
    // A diferencia de un doctor común, el consultor tiene un equipo a su cargo.
    private Team leaderOf;
    
    // 2. CONSTRUCTOR:
    public ConsultantDoctor(int id, Team team) {
        /* * LA PALABRA 'super':
         * Llama al constructor de la clase padre (Doctor).
         * Esto inicializa el ID, las listas de pacientes y citas, 
         * y registra al doctor en la lista general de doctores del equipo.
         */
        super(id, team);
        
        // Asignamos el equipo que este doctor va a liderar.
        this.leaderOf = team;
        
        /* * 3. ESTABLECER EL LIDERAZGO (Bidireccionalidad):
         * No basta con que el Doctor sepa que manda en el Equipo.
         * ¡El Equipo debe saber quién es su jefe!
         * Usamos 'this' para enviarle al equipo este objeto actual como su líder.
         */
        this.leaderOf.setTeamLeader(this);
    }
}
