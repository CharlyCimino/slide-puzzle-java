
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
            this.m.getTableroActual().intercambiar(actualX,actualY,nuevaX,nuevaY);
            // INTERCAMBIO VISUAL
            Pieza p1 = this.m.getTableroActual().devolverPieza(actualX, actualY);
            Pieza p2 = this.m.getTableroActual().devolverPieza(nuevaX, nuevaY);
            this.v.intercambiar( p1.getNumeroDePieza() , p2.getNumeroDePieza() );
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
        switch (codigoDeTecla) {
            case 37: desplazarPiezaVacia(0,back); break; // Izquierda: Misma fila, anterior columna
            case 38: desplazarPiezaVacia(back,0); break; // Arriba: Anterior fila, misma columna
            case 39: desplazarPiezaVacia(0,next); break; // Derecha: Misma fila, siguiente columna
            case 40: desplazarPiezaVacia(next,0); break; // Abajo: Siguiente fila, misma columna
        }
    }
    
    private boolean esCoordenadaValida (int x, int y) {
        return (x >= 0 && x < this.m.DIMENSION) && (y >= 0 && y < this.m.DIMENSION);
    }
    
    private void mezclar (int veces) {
        // IMPLEMENTAR. Se debe llamar un numero de veces a moverSegunTecla() 
        // cada vez con un numero aleatorio entre 37 y 40.
    }
    
    private void detectarVictoria() {
        // IMPLEMENTAR. Verificar si resulta ganador del juego
        // En caso afirmativo, mostrar un cartel de felicitacion.
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
            moverSegunTecla( e.getKeyCode() ); // Muevo en agluna direccion segun la tecla detectada
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
