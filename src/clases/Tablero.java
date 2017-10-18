
package clases;

/**
 *
 * @author caemci
 */
public class Tablero {
    private final Pieza[][] piezas; // Matriz de piezas
    private int vaciaX; // Coordenada X de pieza vacia
    private int vaciaY; // Coordenada Y de pieza vacia

    public Tablero(int dim) { // Dimension (por defecto 3)
        this.piezas = new Pieza[dim][dim]; // Nueva matriz (por defecto, 3x3)
        crearPiezas();
        establecerCoordenadasPiezaVacia( dim-1 , dim-1 ); // Posicion inicial de la pieza vacia (por defecto, 2;2)
    }

    private void crearPiezas() {
        // IMPLEMENTAR
    }
    
    public Pieza devolverPieza(int i, int j) { // Mediante coordenadas en matriz
        // IMPLEMENTAR
        return null;
    }
    
    public Pieza devolverPieza(int n) { // Mediante numero de pieza
        // IMPLEMENTAR
        return null;
    }
    
    public void establecerCoordenadasPiezaVacia (int x, int y) {
        this.vaciaX = x;
        this.vaciaY = y;
    }

    public int getVaciaX() {
        return vaciaX;
    }

    public int getVaciaY() {
        return vaciaY;
    }

    @Override
    public String toString() {
        String representacion = "";
        for (int i = 0; i < this.piezas.length; i++) {
            for (int j = 0; j < this.piezas[0].length; j++) {
                representacion += this.piezas[i][j] + " ";
            }
            representacion += "\n";
        }
        return representacion;
    }
}
