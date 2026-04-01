package core.hospital;

import core.hospital.system.Appoiment;
import core.hospital.system.Team;
import core.hospital.system.Ward;
import core.person.ConsultantDoctor;
import core.person.Doctor;
import core.person.JuniorDoctor;
import core.person.Patient;
import java.util.ArrayList;

public class Hospital {
    
    private ArrayList<Team> teams;
    private ArrayList<Ward> wards;
    
    // Inicialización Obligatoria de listas para evitar errores
    public Hospital() {
        this.teams = new ArrayList<>();
        this.wards = new ArrayList<>();
    }
    
    private Doctor getDoctor(int doctorId) {
        for (Team team : this.teams) {
            for (Doctor doctor : team.getDoctors()) {
                if (doctor.getId() == doctorId) {
                    return doctor;
                }
            }
        }
        return null;
    }
    
    public Patient getPatient(int patientId) {
    // Busca en cada equipo del hospital...
    for (Team team : this.teams) {
        // ... y en cada paciente de ese equipo
        for (Patient patient : team.getPatients()) {
            if (patient.getId() == patientId) {
                return patient; // Si lo encuentra, lo devuelve
            }
        }
    }
    return null; // Si termina y no lo vio, devuelve nada
}
    
    public Team getTeam(int teamId) {
        for (Team team : this.teams) {
            if (team.getId() == teamId) {
                return team;
            }
        }
        return null;
    }
    
    public Ward getWard(int wardId) {
        for (Ward ward : this.wards) {
            if (ward.getId() == wardId) {
                return ward;
            }
        }
        return null;
    }
    
    public boolean addJuniorDoctor(Team team, int doctorId) {
        JuniorDoctor juniorDoctor = new JuniorDoctor(doctorId, team);
        return true;
    }
    
    public boolean addPatient(Ward ward, Team team, int patientId) {
        Patient patient = new Patient(patientId, team, ward);
        return true;
    }
    // Composicipón: En addTeam, el Hospital crea el equipo y, al mismo tiempo, nace el médico líder
    public boolean addTeam(int teamId, int consultantDoctorId) {
      Team team = new Team(teamId); // Nace el equipo
      // El líder nace asociado a ese equipo inmediatamente
      ConsultantDoctor consultantDoctor = new ConsultantDoctor(consultantDoctorId, team);
      this.teams.add(team); // Se guarda en la lista del Hospital
      return true;
}
    
    public boolean addWard(int wardId) {
        this.wards.add(new Ward(wardId));
        return true;
    }
    
    public boolean assignAppoiment(Patient patient, int idDoctorPlus) {
        int teamId = patient.getTeam().getId();
        Doctor doctor = this.getDoctor(teamId + idDoctorPlus);
        
        Appoiment appoiment = new Appoiment(doctor, patient);
        
        return true;
    }
    
   // Agregación
   public boolean assignPatientDoctor(Patient patient, int idDoctorPlus) {
      int teamId = patient.getTeam().getId();
      // Usa el método de búsqueda interna getDoctor
      Doctor doctor = this.getDoctor(teamId + idDoctorPlus);
    
      // Establece la relación en ambos sentidos (Bidireccional)
      patient.addDoctor(doctor);
      doctor.addPatient(patient);
      return true;
}
    
   public void numberDoctorsPatient() {
    for (Ward ward : this.wards) {
        for (Patient patient : ward.getPatients()) {
            // Llama a un método que debe estar dentro de la clase Patient
            System.out.println("Patient " + patient.getId() + " has " + patient.numberOfDoctors() + " doctors");
            //Nota: el profesor usó  patient.numberOfDoctors() en lugar de patient.getDoctors().size()
        }
    }
}
    
    public void numberPatientsTeam() {
        for (Team team : this.teams) {
            System.out.println("Team " + team.getId() + " has " + team.numberOfPatients() + " patients");
        }
    }
    
    public void relationAppoiments() {
        for (Ward ward : this.wards) {
            for (Patient patient : ward.getPatients()) {
                int numberOfAppoiments = patient.numberOfAppoiments();
                System.out.println("Patient " + patient.getId() + " has " + numberOfAppoiments + " appoiments");
                if (numberOfAppoiments > 0) {
                    ArrayList<Integer> doctorsId = patient.getDoctorsId();
                    for (Integer doctorId : doctorsId) {
                        System.out.println("Patient " + patient.getId() + " has an appoiment with the doctor " + doctorId);
                    }
                }
            }
        }
    }
    
}
