
package clases;

/**
 *
 * @author caemci
 */
public class Modelo {
    
    public final int DIMENSION;
    private Tablero tableroGanador;
    private Tablero tableroActual;
    private int cantidadDeMovimientos;
    private boolean modoMoverVacia;
    private String sonidoBeep;
    private String sonidoGanador;

    public Modelo() {
        this.DIMENSION = 3; // Es una matriz de 3x3
        this.tableroGanador = new Tablero(this.DIMENSION); // Piezas en su lugar
        this.tableroActual = new Tablero(this.DIMENSION); // Sujeto a movimientos
        this.establecerCategoriaDeSonidos(1);
    }
    
    public Tablero getTableroActual() {
        return this.tableroActual;
    }
    
    public boolean gano() {
        // Si las representaciones son identicas, se concluye que llego a la solucion
        return this.tableroActual.toString().equals(this.tableroGanador.toString());
    }
    
    public int getCantidadDeMovimientos() {
        return cantidadDeMovimientos;
    }

    public void contarMovimiento() {
        this.cantidadDeMovimientos++;
    }
    
    public void resetearMovimientos() {
        this.cantidadDeMovimientos = 0;
    }
    
    public boolean isModoMoverVacia() {
        return modoMoverVacia;
    }

    public void actualizarModo() {
        this.modoMoverVacia = !this.modoMoverVacia;
    }
    
    public String getSonidoBeep() {
        return sonidoBeep;
    }

    public String getSonidoGanador() {
        return sonidoGanador;
    }
    
    public void establecerCategoriaDeSonidos (int cat) {
        switch (cat) {
            case 1: efectuarCambio("emoticon"); break;
            case 2: efectuarCambio("guitarra"); break;
            case 3: efectuarCambio("futbol"); break;
        }
    }

    private void efectuarCambio(String nombre) {
        this.sonidoBeep = nombre + "-beep.wav";
        this.sonidoGanador = nombre + "-win.wav";
    }
}
