
package clases;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author caemci
 */
public class Controlador 
{
    private Modelo m;
    private Vista v;

    public void iniciar()
    {
        this.m = new Modelo(); // Nuevo Modelo
        this.v = new Vista( this.m ); // Nueva Vista con una referencia al Modelo
        this.v.tecladoListener( new TecladoHandler() ); // Manejar el evento de teclado
        this.v.iniciarVista(); // Le ordeno a la vista que se muestre
    }
    
    private void desplazarPiezaVacia(int sentidoX, int sentidoY) {
        int actualX = this.m.getTableroActual().getVaciaX(); // Coordenada X actual de pieza vacia
        int actualY = this.m.getTableroActual().getVaciaY(); // Coordenada Y actual de pieza vacia
        int nuevaX = actualX + sentidoX; // Nueva coordenada X de pieza vacia
        int nuevaY = actualY + sentidoY; // Nueva coordenada Y de pieza vacia
        if ( esCoordenadaValida(nuevaX, nuevaY) ) { // Si no se desborda
            // INTERCAMBIO LOGICO
            // IMPLEMENTAR. Debe intercambiar la pieza vacia con otra pieza en el modelo
            // INTERCAMBIO VISUAL
            // IMPLEMENTAR. Debe intercambiar la pieza vacia con otra pieza en la vista
        }
    }
    
    private void moverSegunTecla (int codigoDeTecla) {
        /*
            Lo que realmente se mueve es la pieza vacia.
            Si se desea que los cursores muevan la pieza vacia, next = 1 y back = -1
            Si se desea que los cursores muevan las piezas visibles, next = -1 y back = 1
        */
        int next = -1; // Hacia adelante
        int back = 1; // Hacia atras
        // IMPLEMENTAR. Debe desplazar la pieza vacía según el número de tecla presionada
    }
    
    private boolean esCoordenadaValida (int x, int y) {
        // IMPLEMENTAR. Debe devolver true o false segun los valores de x e y
        return false;
    }
    
    private class TecladoHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            /*Los cursores estan mapeados de esta manera:
                Izquierda (37)
                Arriba (38)
                Derecha (39)
                Abajo (40)
            */
            // IMPLEMENTAR
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
