
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
        int indiceDelGuion = this.nombreDeLaImagen.indexOf('-');
        String resto = this.nombreDeLaImagen.substring(indiceDelGuion);
        this.nombreDeLaImagen = categoria + resto;
    }

    @Override
    public String toString() {
        return "P" + this.numeroDePieza;
    }
    
    
}
