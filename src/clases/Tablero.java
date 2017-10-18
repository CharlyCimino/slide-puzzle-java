
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
        this.crearPiezas();
        this.establecerCoordenadasPiezaVacia( dim-1 , dim-1 ); // Posicion inicial de la pieza vacia (por defecto, 2;2)
    }

    private void crearPiezas() {
        int contador = 0; // Lleva la cuenta para saber en qué posicion estoy
        for (int i = 0; i < this.piezas.length; i++) {
            for (int j = 0; j < this.piezas[0].length; j++) {
                this.piezas[i][j] = new Pieza(contador); // Asigna una nuevo objeto Pieza en la posicion [i][j]
                contador++; // Incremento en 1 el contador
            }
        }
    }
    
    public Pieza devolverPieza(int i, int j) { // Mediante coordenadas en matriz
        return this.piezas[i][j]; // Devuelve el objeto Pieza en la posicion [i][j]
    }
    
    public Pieza devolverPieza(int n) { // Mediante numero de pieza
        int contador = 0; // Lleva la cuenta para saber en qué posicion estoy
        for (int i = 0; i < this.piezas.length; i++) {
            for (int j = 0; j < this.piezas[0].length; j++) {
                if (contador == n) { // Si encuentra a la pieza
                    return this.piezas[i][j]; // Devuelve el objeto Pieza en la posicion [i][j]
                }
                else {
                    contador++; // Incremento en 1 el contador
                }
            }
        }
        return null; // Se supone que nunca llega hasta aquí, pero si no se coloca un return, no compila
    }
    
    public void intercambiar (int x1, int y1, int x2, int y2) {
        Pieza aux = this.piezas[x1][y1];
        this.piezas[x1][y1] = this.piezas[x2][y2];
        this.piezas[x2][y2] = aux;
        establecerCoordenadasPiezaVacia(x2, y2);
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
    
    public void cambiarImagenDePiezas(int numero) {
        switch (numero) {
            case 1: efectuarCambio("emoticon"); break;
            case 2: efectuarCambio("guitarra"); break;
            case 3: efectuarCambio("futbol"); break;
        }
    }
    
    private void efectuarCambio (String categoria) {
        for (int i = 0; i < this.piezas.length; i++) {
            for (int j = 0; j < this.piezas[0].length; j++) {
                this.piezas[i][j].cambiarImagen(categoria);
            }
        }
    }

    @Override
    public String toString() {
        // Para que al mostrar un tablero en la consola, se represente como una verdadera matriz cuadrada
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
