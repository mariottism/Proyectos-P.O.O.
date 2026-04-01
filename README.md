# Proyectos-P.O.O.
CLASE PATIENT
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

CLASE TEAM
Por qué es clave esta clase para el Main?
La relación con ConsultantDoctor:

En el código del Hospital: Cuando se hace new ConsultantDoctor(id, team), el constructor del doctor líder usualmente llama a team.setTeamLeader(this). Esto conecta al jefe con su equipo.

El método addPatient y la magia del this:

¿Recuerdas que en la clase Patient pusimos this.team.addPatient(this)? Ese método que se activa es este que acabamos de comentar.

Resultado: Gracias a que Patient se "anota" a sí mismo en el equipo, cuando el Hospital llama a team.numberOfPatients(), el conteo es correcto sin que el Hospital tenga que hacer nada extra.

Búsqueda de Doctores:

En el Main: Se pide asignar un doctor basado en un ID (teamId + offset).

Lógica: El Hospital usará team.getDoctors() para obtener esta lista y recorrerla con un for-each para encontrar al doctor con el ID exacto.

La clase Team funciona como un nodo de agrupación. Implementa métodos de gestión de colecciones (addDoctor, addPatient) con validación de duplicados, permitiendo que otras clases (como Hospital o Patient) interactúen con sus listas de manera segura.
