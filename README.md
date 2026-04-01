# Proyectos-P.O.O.
----CLASE PATIENT----
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

----CLASE TEAM----
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

----Clase JuniorDoctor----
¿Por qué es clave esta clase para el Main?
Polimorfismo en acción:

En el Main: Verás que el Hospital tiene métodos para añadir juniors. Aunque el objeto es de tipo JuniorDoctor, el sistema lo trata como un Doctor general cuando se guarda en las listas.

Por qué: Esto permite que una sola lista de tipo ArrayList<Doctor> pueda guardar tanto a los jefes (Consultant) como a los novatos (Junior).

La simplicidad de la Herencia:

Si el profesor te pide en el parcial: "Cree una clase para doctores en prácticas que funcione igual que los demás", solo tendrías que hacer un extends Doctor y el super. No tienes que volver a escribir nada de los IDs o las listas.

Conexión con el Equipo:

Gracias al super(id, team), cuando se crea un JuniorDoctor, este aparece automáticamente en el reporte de team.getDoctors(). Esto pasa porque el constructor del padre tiene la línea this.team.addDoctor(this).

La clase JuniorDoctor representa una Especialización Básica de la clase Doctor. Demuestra el uso de la palabra clave super para delegar la inicialización a la superclase abstracta, cumpliendo con el principio de reutilización de código sin añadir lógica de estado adicional.

----CLASE Doctor----
¿Por qué es clave esta clase para el Main?
El poder de la Herencia:

En el Main: Cuando el profesor escribe hospital.addJuniorDoctor(...), por detrás se está ejecutando el constructor de Doctor.

Por qué: Esto evita repetir el código de "id", "team" y las "listas" en cada tipo de doctor. Todo lo que sea común se escribe una sola vez aquí.

Uso de this.team.addDoctor(this):

Esto es lo que permite que el método del Hospital getDoctor(int doctorId) funcione. Como el doctor se añade al equipo al nacer, el Hospital puede encontrarlo recorriendo los equipos.

La palabra protected:

Si en el futuro necesitas que el ConsultantDoctor haga algo especial con su lista de pacientes, puede hacerlo porque es protected. Si fuera private, el hijo no podría ver los datos de su propio padre.

La clase Doctor actúa como una Superclase Abstracta. Define el comportamiento base y los atributos compartidos para todos los facultativos del hospital. Implementa el registro automático en el Team asignado, asegurando que la jerarquía de objetos se mantenga sincronizada desde la instanciación.

----CLASE ConsultantDoctor----
¿Por qué se hizo así y cómo se conecta con el Main4?
El uso de super(id, team):

En el Main: Cuando el Hospital ejecuta addTeam(0, 10), por dentro se crea este Consultor.

Por qué es clave: Si olvidas poner super, Java te dará un error porque Doctor no tiene un constructor vacío. super asegura que el Consultor nazca con todas las herramientas de un Doctor normal.

La relación leaderOf.setTeamLeader(this):

En el Main: Esto sucede en la línea hospital.addTeam(0, 10).

Por qué: Al pasarle this (que representa a este consultor específico), el objeto Team guarda la referencia en su atributo teamLeader. Así, cuando consultes al equipo, él sabrá decirte quién es su jefe.

Diferencia con JuniorDoctor:

Mientras que un JuniorDoctor solo hereda y se guarda en la lista de doctores, el ConsultantDoctor tiene este paso extra de "tomar el mando". Por eso tiene un atributo extra (leaderOf) que un Junior no tiene.

Implementación de Herencia con Especialización. ConsultantDoctor extiende la funcionalidad de Doctor al establecer una relación de liderazgo con un Team. Utiliza la palabra clave super para la reutilización de código y mantiene la integridad referencial mediante el método setTeamLeader.

----CLASE Ward----
¿Por qué es clave esta clase para el Main?
Navegación para Reportes:

En el Main: Al final se ejecutan métodos como numberDoctorsPatient().

Por qué: Si miras el código del Hospital que pasamos antes, verás que el profesor hace un for (Ward ward : this.wards). El Hospital entra a cada pabellón, le pide su lista de pacientes (getPatients()) y luego analiza a cada paciente. Sin esta clase, no habría forma de llegar a los pacientes desde el Hospital.

El "Match" con el Constructor de Patient:

Cuando el Main ejecuta hospital.addPatient(hospital.getWard(10), ...), el Hospital busca el objeto Ward con ID 10 y se lo pasa al nuevo paciente. El paciente, al nacer, se mete a sí mismo en la lista de ese Ward usando el método que acabamos de comentar.

La clase Ward representa la unidad organizativa de pacientes en el sistema. Implementa la gestión de colecciones mediante ArrayList y asegura la integridad referencial permitiendo que los objetos Patient se registren a sí mismos en el pabellón asignado durante su creación.


----CLASE Appoiment---
