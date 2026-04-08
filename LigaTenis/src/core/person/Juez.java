package core.person;

import core.league.game.Juego;
import java.util.ArrayList;


public class Juez extends Persona {
    
    private int edad;
    private ArrayList<Juego> juegos;
    
  

    public Juez(String nombre, int edad) {
        super(nombre);
        this.edad = edad;
        this.juegos = new ArrayList<>();
    }
    
    public boolean addJuego(Juego juego) {
        if (!this.juegos.contains(juego)) {
            this.juegos.add(juego);
            return true;
        }
        return false;
    }
    
}
public Juez juezMasActivo() {
    // 1. Validamos que la lista no esté vacía para evitar errores
    if (jueces == null || jueces.isEmpty()) return null;

    // 2. Suponemos que el primero es el que más tiene (nuestro "campeón" inicial)
    Juez juezMax = jueces.get(0);

    // 3. Recorremos la lista para ver si alguien le gana al campeón
    for (Juez j : jueces) {
        // Comparamos el tamaño de la lista de juegos del juez actual 'j' 
        // contra el tamaño de la lista de nuestro 'juezMax'
        if (j.getJuegos().size() > juezMax.getJuegos().size()) {
            juezMax = j; // Si el actual tiene más, ahora él es el nuevo campeón
        }
    }

    return juezMax;
}
   

