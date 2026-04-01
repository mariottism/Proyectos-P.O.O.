/* Como se ve una clase Básica
Aqui entendemos:
Encapsulamiento → private
Constructor → inicializa objetos
this → referencia al objeto actual
Getters → leer datos
Setters → modificar con control
Métodos → comportamiento del objeto */

public class Mascota {

    // Atributos privados → encapsulamiento
    // No se pueden modificar directamente desde fuera de la clase
    private String nombre;
    private String especie;
    private int edad;
    private String estadoSalud;
    private int energia;

    // Para crear el Constructor ponemos mismo nombre que la clase y sin tipo de retorno
    // Se ejecuta automáticamente al crear un objeto
    public Mascota(String nombre, String especie, int edad) {
        // "this" se usa para diferenciar el atributo del objeto del parámetro
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;

        // Valores iniciales por defecto
        this.estadoSalud = "Saludable";
        this.energia = 100;
    }

    // Método para mostrar la información del objeto
    // No retorna nada solo imprime en consola
    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Especie: " + this.especie);
        System.out.println("Edad: " + this.edad);
        System.out.println("Estado de salud: " + this.estadoSalud);
        System.out.println("Energía: " + this.energia);
    }

    // Método que modifica el estado del objeto (energía)
    public void comer(int cantidad) {
        if (cantidad > 0) {
            this.energia += cantidad;

            // Validación para que no supere el máximo
            if (this.energia > 100) {
                this.energia = 100;
            }

            System.out.println(this.nombre + " está comiendo.");
        } else {
            System.out.println("Cantidad no válida");
        }
    }

    // Método que reduce la energía → simula que juega
    public void jugar(int cantidad) {
        // Validación: no puede gastar más energía de la que tiene
        if (cantidad > 0 && cantidad <= this.energia) {
            this.energia -= cantidad;
            System.out.println(this.nombre + " está jugando.");
        } else {
            System.out.println("No tiene suficiente energía");
        }
    }

    // Método que cambia el estado de salud
    public void irAlVeterinario() {
        this.estadoSalud = "En revisión";
        System.out.println(this.nombre + " fue al veterinario.");
    }

    // Getter nos permite obtener el valor de un atributo
    // Siempre retorna el mismo tipo de dato del atributo
    public String getNombre() {
        return this.nombre;
    }

    public int getEnergia() {
        return this.energia;
    }

    // Setter nos permite modificar atributos con validación
    // No retorna nada por eso es "void"
    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("Edad inválida");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre inválido");
        }
    }
}
