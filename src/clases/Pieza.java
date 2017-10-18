
package clases;

/**
 *
 * @author caemci
 */
public class Pieza {
    private final int numeroDePieza;
    private String nombreDeLaImagen;

    public Pieza(int n) {
        this.numeroDePieza = n;
        this.nombreDeLaImagen = "emoticon-" + n + ".jpg";
    }

    public int getNumeroDePieza() {
        return numeroDePieza;
    }

    public String getNombreDeLaImagen() {
        return nombreDeLaImagen;
    }
    
    public void cambiarImagen (String categoria) {
        // IMPLEMENTAR. Cambiar el nombre actual "emoticon-0.jpg" por "categoria-0.jpg"
        // donde categoria es el valor que llega por parametro
        // (no existe una imagen llamada literalmente "categoria-0.jpg", se debe usar el valor que llega por parametro)
    }

    @Override
    public String toString() {
        return "P" + this.numeroDePieza;
    }
    
    
}
