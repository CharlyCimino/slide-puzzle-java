
package clases;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Vista extends javax.swing.JFrame 
{
    private Modelo m;
    
    public Vista() {
        initComponents();
    }
    
    public Vista(Modelo m) {
        this.m = m;
        initComponents();
    }
    
    public void iniciarVista()
    {
        this.setLocationRelativeTo(null); // Aparecerá en el centro de la pantalla
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // La aplicación por defecto se cierra al tocar la cruz
        this.establecerIcono(); // OPCIONAL. Personaliza el ícono de la ventana
        this.colocarTablero();
        this.hacerInvisible( (this.m.DIMENSION * this.m.DIMENSION) - 1 );
        this.setVisible(true); // Hace la ventana visible
    }
    
    private void establecerIcono() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/DibujoCaemci.png"));
        setIconImage(icon);
    }
    
    public void tecladoListener (KeyListener kl) {
        this.jPanelTablero.requestFocus();
        this.jPanelTablero.addKeyListener(kl);
    }
    
    private void colocarTablero() {
        for (int i = 0; i < this.m.DIMENSION; i++) {
            for (int j = 0; j < this.m.DIMENSION; j++) {
                Pieza p = this.m.getTableroActual().devolverPieza(i, j);
                javax.swing.JLabel contenedor = (javax.swing.JLabel) this.jPanelTablero.getComponent( p.getNumeroDePieza() );
                contenedor.setIcon(new ImageIcon(getClass().getResource("/recursos/" + p.getNombreDeLaImagen())));
                contenedor.setText("");
            }
        }
    }
    
    public void actualizarPiezas() {
        int contador = 0;
        for (int i = 0; i < this.m.DIMENSION; i++) {
            for (int j = 0; j < this.m.DIMENSION; j++) {
                Pieza p = this.m.getTableroActual().devolverPieza(i, j);
                javax.swing.JLabel contenedor = (javax.swing.JLabel) this.jPanelTablero.getComponent( contador );
                contenedor.setIcon(new ImageIcon(getClass().getResource("/recursos/" + p.getNombreDeLaImagen())));
                contenedor.setText("");
                contador++;
            }
        }
    }
    
    private void hacerInvisible (int numeroDePieza) {
        JLabel contenedor = (JLabel) this.jPanelTablero.getComponent( numeroDePieza );
        contenedor.setVisible(false);
    }
    
    public void intercambiar (int piezaA, int piezaB) {
        Component[] listaDeComponentes = this.jPanelTablero.getComponents();
        int indicePiezaA = buscarPieza(piezaA);
        int indicePiezaB = buscarPieza(piezaB);
        this.jPanelTablero.removeAll();
        Component temp = listaDeComponentes[indicePiezaA];
        listaDeComponentes[indicePiezaA] = listaDeComponentes[indicePiezaB];
        listaDeComponentes[indicePiezaB] = temp;
        for (int i = 0; i < listaDeComponentes.length; i++) {
            this.jPanelTablero.add(listaDeComponentes[i]);
        }             
        this.jPanelTablero.validate();
    }
    
    private int buscarPieza (int numero) {
        Component[] listaDeComponentes = this.jPanelTablero.getComponents();
        for (int i = 0; i < listaDeComponentes.length; i++) {
            if ( listaDeComponentes[i].getName().equals("pieza"+numero) ) {
                return i;
            }
        }
        return 0;
    }
    
    public void mostrarCartelGanador (int cantMovimientos) {
        String leyenda = "";
        if ( cantMovimientos <= 15) {
            leyenda = "SOS LO MAS CERCANO A DIOS";
        } else if ( cantMovimientos <= 40 ) {
            leyenda = "BIEN";
        } else {
            leyenda = "¿Costó bastante, verdad?";
        }
        leyenda += ", ganaste el juego en " + cantMovimientos + " movimientos.";
        JOptionPane.showMessageDialog(null, leyenda, "GANADOR", 1);
    }
    
    public void cambiarImagenListener (ActionListener al) {
        this.jMenuItem1.addActionListener(al);
        this.jMenuItem2.addActionListener(al);
        this.jMenuItem3.addActionListener(al);
    }
    
    public void modoMovimientoListener (ItemListener il) {
        this.jCheckBoxMenuItem1.addItemListener(il);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTablero = new javax.swing.JPanel();
        jLabel0 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPiezas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuModo = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Slide Puzzle 3x3");
        setBackground(new java.awt.Color(253, 238, 197));
        setResizable(false);
        setSize(new java.awt.Dimension(690, 690));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        jPanelTablero.setBackground(new java.awt.Color(253, 238, 197));
        jPanelTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 98, 37), 5));
        jPanelTablero.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanelTablero.setLayout(new java.awt.GridLayout(3, 3));

        jLabel0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel0.setText("pieza0");
        jLabel0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel0.setName("pieza0"); // NOI18N
        jLabel0.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel0);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("pieza1");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel1.setName("pieza1"); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("pieza2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel2.setName("pieza2"); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("pieza3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel3.setName("pieza3"); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("pieza4");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel4.setName("pieza4"); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("pieza5");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel5.setName("pieza5"); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel5);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("pieza6");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel6.setName("pieza6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel6);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("pieza7");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel7.setName("pieza7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel7);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("pieza8");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 164, 39), 2));
        jLabel8.setName("pieza8"); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelTablero.add(jLabel8);

        getContentPane().add(jPanelTablero);

        jMenuPiezas.setText("Piezas");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/emoticon-icono.jpg"))); // NOI18N
        jMenuItem1.setText("Emoticon");
        jMenuItem1.setActionCommand("1");
        jMenuPiezas.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/guitarra-icono.jpg"))); // NOI18N
        jMenuItem2.setText("Guitarra");
        jMenuItem2.setActionCommand("2");
        jMenuPiezas.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/futbol-icono.jpg"))); // NOI18N
        jMenuItem3.setText("Futbol");
        jMenuItem3.setActionCommand("3");
        jMenuPiezas.add(jMenuItem3);

        jMenuBar1.add(jMenuPiezas);

        jMenuModo.setText("Modo");

        jCheckBoxMenuItem1.setText("Mover pieza vacía");
        jMenuModo.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenuModo);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jMenuModo;
    private javax.swing.JMenu jMenuPiezas;
    private javax.swing.JPanel jPanelTablero;
    // End of variables declaration//GEN-END:variables
}
