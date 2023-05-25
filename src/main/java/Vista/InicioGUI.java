/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ConexionMySQL;
import Controlador.ControladorJugadores;
import Modelo.Jugador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pato
 */
public class InicioGUI extends javax.swing.JFrame {
    
    private ConexionMySQL conexion;
    private ControladorJugadores controlador;
    private ArrayList <Jugador> jugadores;
    private Jugador jActual;  
    
    /**
     * Creates new form InicioGUI
     */
    public InicioGUI()  {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false); //No se puede cambiar de tamaño
       //this.setSize(450, 500);

       /*  conexion=new ConexionMySQL("root"," ","buscaminas");
           controlador=new ControladorJugadores(conexion);
        try {
            conexion.conectar();
            jugadores=controlador.ObtenerTodasPersonas();
            for(Jugador i:jugadores){
                System.out.println(i.toString());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InicioGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTF_NombreJugador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        facilButton = new javax.swing.JRadioButton();
        medioButton = new javax.swing.JRadioButton();
        dificilButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nombre del Equipo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 170, 30));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Medac\\Documents\\NetBeansProjects\\BuscaMinasMedacProject\\src\\main\\java\\Vista\\kiko.png")); // NOI18N
        jLabel2.setText("BUSCA KIKOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 660, 150));

        jButton1.setText("Jugar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 110, 50));
        getContentPane().add(jTF_NombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 250, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Dificultad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        buttonGroup1.add(facilButton);
        facilButton.setText("Fácil");
        getContentPane().add(facilButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, -1, -1));

        buttonGroup1.add(medioButton);
        medioButton.setText("Medio");
        getContentPane().add(medioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        buttonGroup1.add(dificilButton);
        dificilButton.setText("Difícil");
        getContentPane().add(dificilButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jActual = new Jugador(this.jTF_NombreJugador.getText());
        if(facilButton.isSelected()){
            jActual.setPuntuacion(3000);
            //Metodo para crear el tablero dependiendo de la dificultad seleccionada
            crearTablero(1);
        } else if (medioButton.isSelected()){
            jActual.setPuntuacion(6000);
            crearTablero(2);
        } else {
            jActual.setPuntuacion(9000);
            crearTablero(3);
        }
        

        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void crearTablero(int dificultad) {
        //pasamos el jugador a la nueva ventana
        TableroGUI tableroGUI = new TableroGUI(jActual,this, dificultad);
        //ocultamos la ventana actual
        this.setVisible(false);
        //mostramos nueva ventana
        tableroGUI.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton dificilButton;
    private javax.swing.JRadioButton facilButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTF_NombreJugador;
    private javax.swing.JRadioButton medioButton;
    // End of variables declaration//GEN-END:variables
}
