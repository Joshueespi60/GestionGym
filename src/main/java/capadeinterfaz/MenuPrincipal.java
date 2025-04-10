/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package capadeinterfaz;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Joshue
 */
public class MenuPrincipal extends javax.swing.JFrame {
   
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        
      
   
        // Llamada a BotonUtils para cargar la imagen en los botones
        BotonUtils.cargarImagenEnBoton("img/7.png", clientes, 60, 50);  // Imagen para el primer botón
        BotonUtils.cargarImagenEnBoton("img/9.png", jButton4, 58, 53);   // Imagen para el segundo botón
        BotonUtils.cargarImagenEnBoton("img/8.png", jButton2, 60, 50);   // Imagen para el segundo botón
        BotonUtils.cargarImagenEnBoton("img/8.png", jButton3, 60, 50);   // Imagen para el segundo botón 
        BotonUtils.cargarImagenEnBoton("img/11.png", jButton1, 320, 320);   // Imagen para el segundo botón  

        // Configurar los botones sin bordes ni fondo
        BotonUtils.configurarBotonSinBorde(clientes);  // Configura el primer botón sin borde
        BotonUtils.configurarBotonSinBorde(jButton4);  // Configura el segundo botón sin borde
        BotonUtils.configurarBotonSinBorde(jButton2);  // Configura el segundo botón sin borde
        BotonUtils.configurarBotonSinBorde(jButton3);  // Configura el segundo botón sin borde
        BotonUtils.configurarBotonSinBorde(jButton1);  // Configura el segundo botón sin borde


        // Ajustar las coordenadas y el tamaño de los botones
        BotonUtils.configurarBoton(clientes, 30, 120, 60, 50);  // Posición y tamaño del primer botón
        BotonUtils.configurarBoton(jButton4, 720, 390, 60, 60); // Posición y tamaño del segundo botón
        BotonUtils.configurarBoton(jButton3, 30, 360, 60, 50); // Posición y tamaño del segundo botón
        BotonUtils.configurarBoton(jButton2, 30, 230, 60, 50); // Posición y tamaño del segundo botón
        BotonUtils.configurarBoton(jButton1, 430, 50, 320, 320); // Posición y tamaño del segundo botón
              
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        clientes = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(816, 511));
        setMinimumSize(new java.awt.Dimension(816, 511));
        setPreferredSize(new java.awt.Dimension(816, 511));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("MENU");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 90, 40);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(768, 463));
        jPanel1.setLayout(null);

        jButton4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(720, 430, 58, 53);

        clientes.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        jPanel1.add(clientes);
        clientes.setBounds(30, 120, 60, 50);

        jButton2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 230, 60, 50);

        jButton3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(30, 360, 60, 50);
        jPanel1.add(jButton1);
        jButton1.setBounds(530, 170, 70, 50);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CLIENTES");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 80, 130, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("MEMBRESIAS");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 200, 80, 14);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("REGISTRO ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 320, 80, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        // TODO add your handling code here:
         GestionClientes Gestionclientes = new GestionClientes(this); // Pasamos el menú
    Gestionclientes.setVisible(true);
    Gestionclientes.setLocationRelativeTo(null);
    this.setVisible(false); // Solo ocultar, no cerrar
    }//GEN-LAST:event_clientesActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        GestionMembresias gestionMembresias = new GestionMembresias(this); // Pasamos el menú
        gestionMembresias.setVisible(true);
        gestionMembresias.setLocationRelativeTo(null);
        this.setVisible(false); // Solo ocultar, no cerrar

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        RegistroAsistencia Registroasitencia = new RegistroAsistencia(this); // Pasamos el menú
        Registroasitencia.setVisible(true);
        Registroasitencia.setLocationRelativeTo(null);
        this.setVisible(false); // Solo ocultar, no cerrar
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         try {
            // Establecer el LookAndFeel de FlatLightLaf (Tema Claro)
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        // Crear y mostrar la ventana del login
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
