
package clases;

/**
 *
 * @author caemci
 */
public class Modelo {
    
    public final int DIMENSION;
    private Tablero tableroGanador;
    private Tablero tableroActual;

    public Modelo() {
        this.DIMENSION = 3; // Es una matriz de 3x3
        this.tableroGanador = new Tablero(this.DIMENSION); // Piezas en su lugar
        this.tableroActual = new Tablero(this.DIMENSION); // Sujeto a movimientos
    }
    
    public Tablero getTableroActual() {
        return this.tableroActual;
    }
    
}
