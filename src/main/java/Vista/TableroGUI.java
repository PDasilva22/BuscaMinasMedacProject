/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ConexionMySQL;
import Controlador.ControladorJugadores;
import Implementacion.confTablero;
import Modelo.Jugador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Pato
 */
public class TableroGUI extends javax.swing.JFrame {

    /**
     * Creates new form TableroGUI
     */
    //El jugador que recibiremos de InicioGUI.java creado con el nombre insertado por el jugador.
    private Jugador jActual;
    private ArrayList<JButton> listaBotones = new ArrayList<JButton>();
    private ArrayList<Integer> tablero;
    private int dificultad;
    //el valor que se le resta al usuario cada ves que falla - Configurado en el constructor dependiendo de la dificultad
    private int resto;
    private JFrame inicioGUI;

    public TableroGUI() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        generarTablero();

        // this.setSize(600, 700);
    }

    public TableroGUI(Jugador jActual, JFrame inicioGUI, int dificultad) {
        initComponents();
        this.jActual = jActual;
        this.inicioGUI = inicioGUI;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.dificultad = dificultad;
        switch (dificultad) {
            case 1:
                resto = 1000;
                break;
            case 2:
                resto = 2000;
                break;
            case 3:
                resto = 3000;
                break;
        }
        //Inicializamos el tablero dependiendo de la dificultad seleccionada
        tablero = new confTablero().obtenerTablero(dificultad);
        generarTablero();
        // this.setSize(600, 700);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));

        jMenuBar1.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jMenu1.setText("Reiniciar");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Información");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Puntuación");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
       //BOTON INFORMACION
       
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void victoria() {

        //guardamos la puntuacion del jugador
        ConexionMySQL conexion = new ConexionMySQL("root", " ", "buscaminas");
        ControladorJugadores controlador = new ControladorJugadores(conexion);
        try {
            conexion.conectar();
            controlador.insertarJugador(jActual);
        } catch (SQLException ex) {
            Logger.getLogger(TableroGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TableroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(rootPane, "Has ganado la partida");
        this.dispose();
        this.inicioGUI.setVisible(true);

    }

    private void gameOver() {

        //guardamos la puntuacion del jugador
        ConexionMySQL conexion = new ConexionMySQL("root", " ", "buscaminas");
        ControladorJugadores controlador = new ControladorJugadores(conexion);
        try {
            conexion.conectar();
            controlador.insertarJugador(jActual);
        } catch (SQLException ex) {
            Logger.getLogger(TableroGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TableroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(rootPane, "Has perdido la partida");
        this.dispose();
        this.inicioGUI.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    private void generarTablero() {

        //this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JPanel panel = new JPanel(); // Assuming 8x8 grid for buttons
        panel.setBackground(Color.red);
        int buttonSize = 50;
        panel.setSize(buttonSize * 8, buttonSize * 8);

        //centramos el panel
        panel.setLocation((this.getWidth() - panel.getWidth()) / 2, (this.getHeight() - panel.getHeight()) / 2);
        //un grid layout de 8x8 porque son 64 opciones
        panel.setLayout(new GridLayout(8, 8));

        this.add(panel);

        for (int i = 0; i < 64; i++) {
            JButton button = new JButton("");
            button.setName("casilla" + i);
            button.setSize(buttonSize, buttonSize);
            panel.add(button);
            //añadimos los eventos de los botones
            //hay  que hacerla final para poder usarla dentro de un evento
            final int index = i;
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //cuando se pulsa cualquier boton ocurre esto

                    //comprobamos que no halla sido pulsado antes
                    if (dificultad != 3) {
                        if (listaBotones.get(index).getText().isEmpty()) {
                            listaBotones.get(index).setText(tablero.get(index).toString());

                            //comprobamos que no halla acertado
                            if (!listaBotones.get(index).getText().equalsIgnoreCase("0")) {
                                System.out.println(jActual.getPuntuacion());
                                jActual.setPuntuacion(jActual.getPuntuacion() - resto);
                                System.out.println(jActual.getPuntuacion());
                                //comprobamos que no se halla quedado sin puntos
                                //comprueba si tiene menos puntos que los que cuesta tirar una vez
                                if (jActual.getPuntuacion() < resto) {
                                    //si no tiene puntos
                                    gameOver();
                                }
                            } else {
                                //si se ha encontrado

                                victoria();

                            }

                        } else {
                            //ya se ha pulsado este boton
                        }
                    } else {
                        if (listaBotones.get(index).getText().isEmpty()) {
                            boolean valido = true;
                            playGame(valido);
                            //comprobamos que no halla acertado
                            if (!listaBotones.get(index).getText().equalsIgnoreCase("0")) {
                                jActual.setPuntuacion(jActual.getPuntuacion() - resto);

                                //comprobamos que no se halla quedado sin puntos
                                //comprueba si tiene menos puntos que los que cuesta tirar una vez
                                if (jActual.getPuntuacion() < resto) {
                                    //si no tiene puntos
                                    gameOver();
                                }
                            } else {
                                //si se ha encontrado

                                victoria();

                            }
                        }
                    }
                    listaBotones.get(index).setEnabled(false);

                }

                private void playGame(boolean valido) throws HeadlessException {
                    String seleccion;
                    int userSeleccion;
                    int compSeleccion;
                    do {
                        do {
                            seleccion = JOptionPane.showInputDialog("¿Piedra, Papel o Tijeras? \nSolo si ganas te diré a cuánto estoy del jugador");
                            seleccion.toLowerCase();
                            System.out.println(seleccion);
                            if (!seleccion.equals("piedra") && !seleccion.equals("tijeras") && !seleccion.equals("papel")) {
                                JOptionPane.showMessageDialog(null, "Esa opción no existe", "Incorrecto", JOptionPane.ERROR_MESSAGE);
                                valido = false;
                            }
                        } while (!valido);
                        userSeleccion = 0;
                        if (seleccion.equals("piedra")) {
                            userSeleccion = 1;
                        } else if (seleccion.equals("papel")) {
                            userSeleccion = 2;
                        } else if (seleccion.equals("tijeras")) {
                            userSeleccion = 3;
                        }
                        compSeleccion =(int) (Math.random() * 4);
                        if(userSeleccion == compSeleccion){
                            //Modificar por un panel personalizado de mensaje
                            JOptionPane.showMessageDialog(null, "¡Hemos empatado! Vamos a repetir la partida", "Empate", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (userSeleccion == compSeleccion);
                    if (comprobarResultado(userSeleccion, compSeleccion)) {
                        listaBotones.get(index).setText(tablero.get(index).toString());
                    } else {
                        //Editar por un panel personalizado
                        JOptionPane.showMessageDialog(null, "Has perdido la partida", "Derrota", JOptionPane.WARNING_MESSAGE);
                    }
                }

                private boolean comprobarResultado(int userSeleccion, int compSeleccion) {
                    boolean victory = false;

                    if (userSeleccion == 1 && compSeleccion == 3) {
                        victory = true;
                    } else if (userSeleccion == 3 && compSeleccion == 2) {
                        victory = true;
                    } else if (userSeleccion == 2 && compSeleccion == 1) {
                        victory = true;
                    }

                    return victory;
                }
            });
            //añadimos los botones a la lista para manipularlos mas tarde
            listaBotones.add(button);

        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableroGUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
