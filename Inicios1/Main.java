public class Main {

    public static void main(String[] args) {

        // Crear objetos para instanciar la clase Mascota
        Mascota m1 = new Mascota("Luna", "Perro", 3);
        Mascota m2 = new Mascota("Max", "Gato", 2);

        // Mostrar información inicial
        System.out.println("=== INFORMACIÓN INICIAL ===");
        m1.mostrarInfo();
        m2.mostrarInfo();

        // Uso de métodos para ver el comportamiento del objeto
        System.out.println("\n=== ACCIONES ===");
        m1.jugar(30);       // reduce energía
        m1.comer(20);       // aumenta energía
        m1.irAlVeterinario(); // cambia estado

        // Uso de setters → modificar atributos con validación
        m2.setNombre("Michi");
        m2.setEdad(4);

        // Intento inválido (para ver validación)
        m2.setEdad(-1);

        // Uso de getters nos permiten obtener valores
        System.out.println("\nEnergía de " + m1.getNombre() + ": " + m1.getEnergia());

        // Mostrar información final
        System.out.println("\n=== INFORMACIÓN FINAL ===");
        m1.mostrarInfo();
        m2.mostrarInfo();

        // Interacción simple entre objetos
        System.out.println("\n=== INTERACCIÓN ===");
        System.out.println(m1.getNombre() + " está jugando con " + m2.getNombre());
    }
}
