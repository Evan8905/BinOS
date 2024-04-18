package Presentation;

import Data.Conection;
import Data.Utilidades;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class LoginScreen extends javax.swing.JFrame {

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
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

        pinaBG = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        panelPina = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();
        sideBG = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnEye = new javax.swing.JLabel();
        blackBG = new javax.swing.JLabel();

        pinaBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frutaPiña 1.png"))); // NOI18N
        pinaBG.setMaximumSize(new java.awt.Dimension(500, 660));
        pinaBG.setMinimumSize(new java.awt.Dimension(500, 660));
        pinaBG.setPreferredSize(new java.awt.Dimension(550, 655));
        pinaBG.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserName.setBackground(new java.awt.Color(16, 16, 16));
        txtUserName.setForeground(new java.awt.Color(204, 204, 204));
        txtUserName.setText("Digite su nombre de usuario");
        txtUserName.setBorder(null);
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserNameMousePressed(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 220, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 220, 20));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Iniciar Sesión");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        txtPassword.setBackground(new java.awt.Color(16, 16, 16));
        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("********");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 190, -1));

        btnLogin.setBackground(new java.awt.Color(0, 142, 73));
        btnLogin.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(253, 253, 253));
        btnLogin.setText("Iniciar");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 170, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        panelPina.setBackground(new java.awt.Color(21, 21, 21));
        panelPina.setForeground(new java.awt.Color(22, 22, 22));
        panelPina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logOutRed.png"))); // NOI18N
        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        panelPina.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 30, 30));

        sideBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frutaPiña 1.png"))); // NOI18N
        panelPina.add(sideBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, -1));

        getContentPane().add(panelPina, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 440, 660));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 220, -1));

        btnEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eyePasswordWhite.png"))); // NOI18N
        btnEye.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEyeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEyeMouseReleased(evt);
            }
        });
        getContentPane().add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 30, -1));

        blackBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loginBG.png"))); // NOI18N
        blackBG.setText("lblBG");
        getContentPane().add(blackBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        validateLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void txtUserNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMousePressed
        if (txtUserName.getText().equals("Digite su nombre de usuario")) {
            txtUserName.setText("");
            txtUserName.setForeground(Color.LIGHT_GRAY);
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            txtPassword.setText("********");
            txtPassword.setForeground(Color.GRAY);
        }

    }//GEN-LAST:event_txtUserNameMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed

        if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.GRAY);

        }
        if (txtUserName.getText().isEmpty()) {
            txtUserName.setText("Digite su nombre de usuario");
            txtUserName.setForeground(Color.LIGHT_GRAY);
        }


    }//GEN-LAST:event_txtPasswordMousePressed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.requestFocus();
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed

    }//GEN-LAST:event_btnLoginKeyPressed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed

        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword.requestFocus();
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void btnEyeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEyeMousePressed

        char[] passwordChars = txtPassword.getPassword();
        String password = new String(passwordChars);
        txtPassword.setEchoChar((char) 0);
        txtPassword.setText(password);
    }//GEN-LAST:event_btnEyeMousePressed

    private void btnEyeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEyeMouseReleased
        txtPassword.setEchoChar('*');
    }//GEN-LAST:event_btnEyeMouseReleased
//    private void validateLogin() {
//        // Obtener los datos del formulario
//        String user = txtUserName.getText();
//        String password = txtPassword.getText();
//       
//        // Verificar las credenciales del usuario
//        if (Conection.checkUser(user, password)) {
//            // Las credenciales son correctas, permitir el acceso al sistema
//            JOptionPane.showMessageDialog(null, "Acceso concedido.");
//            HomeScreenDigitador scr = new HomeScreenDigitador();
//            scr.setLocationRelativeTo(null);
//            scr.setVisible(true);
//        } else {
//            // Las credenciales son incorrectas
//            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
//        }
//    }

    private void validateLogin() {
        // Obtener los datos del formulario
        String user = txtUserName.getText();
        String password = txtPassword.getText();

        // Verificar las credenciales del usuario
        int tipoUsuario = Conection.checkUser(user, password);
        switch (tipoUsuario) {
            case 1:
                // El usuario es un administrador, mostrar la pantalla de HomeScreen
                HomeScreen scr = new HomeScreen();
                scr.setLocationRelativeTo(null);
                scr.setVisible(true);
                break;
            case 0:
                // El usuario no es un administrador, mostrar la pantalla de HomeScreenDigitador
                HomeScreenDigitador scrDigitador = new HomeScreenDigitador();
                scrDigitador.setLocationRelativeTo(null);
                scrDigitador.setVisible(true);
                break;
            case -1:
                // No se encontró el tipo de usuario
                JOptionPane.showMessageDialog(null, "No se encontró el tipo de usuario.");
                break;
            case -2:
                // Las credenciales son incorrectas
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                break;
            case -3:
                // Hubo un error al verificar al usuario
                JOptionPane.showMessageDialog(null, "Error al verificar usuario.");
                break;
        }
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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blackBG;
    private javax.swing.JLabel btnEye;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelPina;
    private javax.swing.JLabel pinaBG;
    private javax.swing.JLabel sideBG;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
