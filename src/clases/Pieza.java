
package clases;

/**
 *
 * @author caemci
 */
public class Pieza {
    private final int numeroDePieza;
    private final String nombreDeLaImagen;

    public Pieza(int n) {
        this.numeroDePieza = n;
        this.nombreDeLaImagen = "img-" + n + ".jpg";
    }

    public int getNumeroDePieza() {
        return numeroDePieza;
    }

    public String getNombreDeLaImagen() {
        return nombreDeLaImagen;
    }

    @Override
    public String toString() {
        return "P" + this.numeroDePieza;
    }
    
    
}
