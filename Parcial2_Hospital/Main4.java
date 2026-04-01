public class Main4 {
    
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        hospital.addTeam(0, 0 + 10); // 0 is the Team id, the Team id plus 10 is the ConsultantDoctor id.
        hospital.addJuniorDoctor(hospital.getTeam(0), 0 + 1); // Receives the Team. The Team id plus value is the JuniorDoctor id.
        hospital.addJuniorDoctor(hospital.getTeam(0), 0 + 2);
        hospital.addJuniorDoctor(hospital.getTeam(0), 0 + 3);
        hospital.addJuniorDoctor(hospital.getTeam(0), 0 + 4);

        hospital.addTeam(100, 100 + 10);
        hospital.addJuniorDoctor(hospital.getTeam(100), 100 + 1);
        hospital.addJuniorDoctor(hospital.getTeam(100), 100 + 2);
        hospital.addJuniorDoctor(hospital.getTeam(100), 100 + 3);
        hospital.addJuniorDoctor(hospital.getTeam(100), 100 + 4);

        hospital.addTeam(200, 200 + 10);
        hospital.addJuniorDoctor(hospital.getTeam(200), 200 + 1);
        hospital.addJuniorDoctor(hospital.getTeam(200), 200 + 2);
        hospital.addJuniorDoctor(hospital.getTeam(200), 200 + 3);
        hospital.addJuniorDoctor(hospital.getTeam(200), 200 + 4);

        hospital.addWard(10);

        hospital.addPatient(hospital.getWard(10), hospital.getTeam(0), 0 + 10); // Receives the Ward, the Team and the Patient id.
        hospital.assignPatientDoctor(hospital.getPatient(0 + 10), 1); // Receives the Patient and the Doctor id is the Patient Team id plus the second function parameter (int).
        hospital.assignPatientDoctor(hospital.getPatient(0 + 10), 2);
        hospital.assignAppoiment(hospital.getPatient(0 + 10), 2); // The parameter values are the same as assignPatientDoctor.
        hospital.assignAppoiment(hospital.getPatient(0 + 10), 2);
        hospital.assignAppoiment(hospital.getPatient(0 + 10), 2);

        hospital.addPatient(hospital.getWard(10), hospital.getTeam(100), 1 + 10);
        hospital.assignPatientDoctor(hospital.getPatient(1 + 10), 1);

        hospital.addPatient(hospital.getWard(10), hospital.getTeam(100), 2 + 10);
        hospital.assignPatientDoctor(hospital.getPatient(2 + 10), 1);
        hospital.assignAppoiment(hospital.getPatient(2 + 10), 1);
        hospital.assignAppoiment(hospital.getPatient(2 + 10), 1);
        hospital.assignAppoiment(hospital.getPatient(2 + 10), 1);
        hospital.assignAppoiment(hospital.getPatient(2 + 10), 1);
        hospital.assignPatientDoctor(hospital.getPatient(2 + 10), 2);
        hospital.assignPatientDoctor(hospital.getPatient(2 + 10), 3);
        hospital.assignAppoiment(hospital.getPatient(2 + 10), 3);
        hospital.assignAppoiment(hospital.getPatient(2 + 10), 3);

        hospital.addPatient(hospital.getWard(10), hospital.getTeam(0), 3 + 10);
        hospital.assignPatientDoctor(hospital.getPatient(3 + 10), 1);
        hospital.assignAppoiment(hospital.getPatient(3 + 10), 1);

        hospital.addWard(50);

        hospital.addPatient(hospital.getWard(50),hospital.getTeam(0), 0 + 50);
        hospital.assignPatientDoctor(hospital.getPatient(0 + 50), 1);
        hospital.assignPatientDoctor(hospital.getPatient(0 + 50), 2);
        hospital.assignAppoiment(hospital.getPatient(0 + 50), 1);
        hospital.assignAppoiment(hospital.getPatient(0 + 50), 1);
        hospital.assignAppoiment(hospital.getPatient(0 + 50), 1);
        hospital.assignPatientDoctor(hospital.getPatient(0 + 50), 3);
        hospital.assignPatientDoctor(hospital.getPatient(0 + 50), 4);

        hospital.addPatient(hospital.getWard(50), hospital.getTeam(100), 1 + 50);
        hospital.assignPatientDoctor(hospital.getPatient(1 + 50), 1);

        hospital.addPatient(hospital.getWard(50), hospital.getTeam(200), 2 + 50);
        hospital.assignPatientDoctor(hospital.getPatient(2 + 50), 1);
        hospital.assignPatientDoctor(hospital.getPatient(2 + 50), 2);

        hospital.addPatient(hospital.getWard(50), hospital.getTeam(0), 3 + 50);
        hospital.assignPatientDoctor(hospital.getPatient(3 + 50), 3);
        hospital.assignAppoiment(hospital.getPatient(3 + 50), 3);
        hospital.assignAppoiment(hospital.getPatient(3 + 50), 3);
        hospital.assignAppoiment(hospital.getPatient(3 + 50), 3);
        hospital.assignAppoiment(hospital.getPatient(3 + 50), 3);
        hospital.assignAppoiment(hospital.getPatient(3 + 50), 3);

        System.out.println("Number of doctors per patient:");
        hospital.numberDoctorsPatient();

        System.out.println("\nNumber of patients per team:");
        hospital.numberPatientsTeam();

        System.out.println("\nList of appointments in the system:");
        hospital.relationAppoiments();
    }
    
}

/**
------------- Resultados -------------

Number of doctors per patient:
Patient 10 has 2 doctors
Patient 11 has 1 doctors
Patient 12 has 3 doctors
Patient 13 has 1 doctors
Patient 50 has 4 doctors
Patient 51 has 1 doctors
Patient 52 has 2 doctors
Patient 53 has 1 doctors

Number of patients per team:
Team 0 has 4 patients
Team 100 has 3 patients
Team 200 has 1 patients

List of appointments in the system:
Patient 10 has 3 appoiments
Patient 10 has an appoiment with the doctor 2
Patient 10 has an appoiment with the doctor 2
Patient 10 has an appoiment with the doctor 2
Patient 11 has 0 appoiments
Patient 12 has 6 appoiments
Patient 12 has an appoiment with the doctor 101
Patient 12 has an appoiment with the doctor 101
Patient 12 has an appoiment with the doctor 101
Patient 12 has an appoiment with the doctor 101
Patient 12 has an appoiment with the doctor 103
Patient 12 has an appoiment with the doctor 103
Patient 13 has 1 appoiments
Patient 13 has an appoiment with the doctor 1
Patient 50 has 3 appoiments
Patient 50 has an appoiment with the doctor 1
Patient 50 has an appoiment with the doctor 1
Patient 50 has an appoiment with the doctor 1
Patient 51 has 0 appoiments
Patient 52 has 0 appoiments
Patient 53 has 5 appoiments
Patient 53 has an appoiment with the doctor 3
Patient 53 has an appoiment with the doctor 3
Patient 53 has an appoiment with the doctor 3
Patient 53 has an appoiment with the doctor 3
Patient 53 has an appoiment with the doctor 3
*/
