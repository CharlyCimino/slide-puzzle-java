
package clases;

/**
 *
 * @author caemci
 */
public class Principal {

    public static void main(String[] args) {
        // Todo esto vino por defecto del JFrame que creó NetBeans
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Se debe instanciar e invocar al controlador de la aplicación.
                Controlador c = new Controlador();
                c.iniciar();
            }
        });
    }
}
