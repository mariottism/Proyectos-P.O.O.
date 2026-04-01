# Proyectos-P.O.O.

¿Por qué se hizo así y cómo se conecta con el Main?
En el constructor (this.team.addPatient(this)): * En el Main: Cuando llamas a hospital.addPatient(...).

Por qué: Gracias a esto, cuando el Hospital recorre los equipos para contar pacientes, el paciente ya aparece en la lista del equipo automáticamente. Si no se hace esto, el reporte numberPatientsTeam() saldría en 0.

El uso de contains:

En el Main: se ve que a veces se intenta asignar el mismo doctor varias veces.

Por qué: Es un mecanismo de seguridad. En POO siempre se debe validar que los datos no se dupliquen si la lógica del negocio no lo permite.

El método getDoctorsId:

En el Main: Se usa en la parte final: hospital.relationAppoiments().

Por qué: Es más eficiente devolver una lista de números (Integer) que una lista de objetos pesados si solo vas a imprimir el número.

La clase Patient implementa una asociación bidireccional con Team y Ward. Se utiliza el método contains() para asegurar la integridad de las listas de doctores y citas, evitando duplicados."
