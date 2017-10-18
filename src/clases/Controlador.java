
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
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
