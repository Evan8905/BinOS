package Presentation;

import Data.Utilidades;

/**
 *
 * @author eefre
 */
public class HomeScreenDigitador extends javax.swing.JFrame {

    /**
     * Creates new form HomeScreenDigitador
     */
    public HomeScreenDigitador() {
        initComponents();
        // Cerrar todas las demás ventanas
        Utilidades.cerrarTodasLasVentanas();

        // Agregar esta ventana a la lista de ventanas abiertas
        Utilidades.abrirNuevaVentana(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblSignOut = new javax.swing.JLabel();
        btnDigitador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, -1, -1));

        lblSignOut.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        lblSignOut.setForeground(new java.awt.Color(255, 255, 255));
        lblSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/signOutWhite.png"))); // NOI18N
        lblSignOut.setText("Cerrar Sesión");
        lblSignOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignOutMouseClicked(evt);
            }
        });
        getContentPane().add(lblSignOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 20, -1, -1));

        btnDigitador.setBackground(new java.awt.Color(16, 16, 16));
        btnDigitador.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDigitador.setForeground(new java.awt.Color(153, 153, 255));
        btnDigitador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adminIcon.png"))); // NOI18N
        btnDigitador.setText("Digitador");
        btnDigitador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDigitador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDigitadorActionPerformed(evt);
            }
        });
        getContentPane().add(btnDigitador, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 280, 190));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loginBG.png"))); // NOI18N
        jLabel1.setText("lblBG");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 763));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSignOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignOutMouseClicked
        LoginScreen scr = new LoginScreen();
        scr.setLocationRelativeTo(null);
        scr.setVisible(true);
    }//GEN-LAST:event_lblSignOutMouseClicked

    private void btnDigitadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDigitadorActionPerformed

        AdminScreen scr = new AdminScreen();
        scr.setLocationRelativeTo(null);
        scr.setVisible(true);
    }//GEN-LAST:event_btnDigitadorActionPerformed

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
            java.util.logging.Logger.getLogger(HomeScreenDigitador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeScreenDigitador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeScreenDigitador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreenDigitador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreenDigitador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDigitador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblSignOut;
    // End of variables declaration//GEN-END:variables
}