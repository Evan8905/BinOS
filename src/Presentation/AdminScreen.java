package Presentation;

import Data.Utilidades;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author eefre
 */
public class AdminScreen extends javax.swing.JFrame {

    /**
     * Creates new form AdminScreen
     */
    public AdminScreen() {
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

        panelMain = new javax.swing.JPanel();
        leftSidePanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnUsers = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnFincas = new javax.swing.JButton();
        btnCosecha = new javax.swing.JButton();
        lblCopyRight = new javax.swing.JLabel();
        btnVariedadF = new javax.swing.JButton();
        lblGoback = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSignOut = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setName("mainJframe"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 0));
        panelMain.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(panelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        leftSidePanel.setBackground(new java.awt.Color(16, 23, 27));
        leftSidePanel.setForeground(new java.awt.Color(0, 255, 204));

        lblWelcome.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("Bienvenido");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        lblLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoMouseClicked(evt);
            }
        });

        btnUsers.setBackground(new java.awt.Color(0, 142, 73));
        btnUsers.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnUsers.setForeground(new java.awt.Color(51, 51, 51));
        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Users.png"))); // NOI18N
        btnUsers.setText("       Usuarios                    ");
        btnUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });
        btnUsers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnUsersKeyPressed(evt);
            }
        });

        btnProveedores.setBackground(new java.awt.Color(0, 142, 73));
        btnProveedores.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(51, 51, 51));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Proveedores.png"))); // NOI18N
        btnProveedores.setText("        Proveedores             ");
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnFincas.setBackground(new java.awt.Color(0, 142, 73));
        btnFincas.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnFincas.setForeground(new java.awt.Color(51, 51, 51));
        btnFincas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fincas.png"))); // NOI18N
        btnFincas.setText("         Fincas                           ");
        btnFincas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFincas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFincasActionPerformed(evt);
            }
        });

        btnCosecha.setBackground(new java.awt.Color(0, 142, 73));
        btnCosecha.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnCosecha.setForeground(new java.awt.Color(51, 51, 51));
        btnCosecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cosecha.png"))); // NOI18N
        btnCosecha.setText("        Cosecha                       ");
        btnCosecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCosecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCosechaActionPerformed(evt);
            }
        });

        lblCopyRight.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        lblCopyRight.setForeground(new java.awt.Color(255, 255, 255));
        lblCopyRight.setText("Power by Evan | 2024");

        btnVariedadF.setBackground(new java.awt.Color(0, 142, 73));
        btnVariedadF.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnVariedadF.setForeground(new java.awt.Color(51, 51, 51));
        btnVariedadF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Variedad.png"))); // NOI18N
        btnVariedadF.setText("      Variedad de Fruto");
        btnVariedadF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVariedadF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVariedadFActionPerformed(evt);
            }
        });

        lblGoback.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        lblGoback.setForeground(new java.awt.Color(255, 255, 255));
        lblGoback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/goBackRed.png"))); // NOI18N
        lblGoback.setText("   Ir Atrás   ");
        lblGoback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGoback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGobackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftSidePanelLayout = new javax.swing.GroupLayout(leftSidePanel);
        leftSidePanel.setLayout(leftSidePanelLayout);
        leftSidePanelLayout.setHorizontalGroup(
            leftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSidePanelLayout.createSequentialGroup()
                .addGroup(leftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftSidePanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(leftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVariedadF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCosecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFincas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(leftSidePanelLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(leftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCopyRight)
                            .addComponent(lblLogo)
                            .addComponent(lblWelcome)
                            .addComponent(lblGoback, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        leftSidePanelLayout.setVerticalGroup(
            leftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSidePanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblLogo)
                .addGap(43, 43, 43)
                .addComponent(lblWelcome)
                .addGap(34, 34, 34)
                .addComponent(btnUsers)
                .addGap(18, 18, 18)
                .addComponent(btnProveedores)
                .addGap(18, 18, 18)
                .addComponent(btnFincas)
                .addGap(18, 18, 18)
                .addComponent(btnCosecha)
                .addGap(18, 18, 18)
                .addComponent(btnVariedadF)
                .addGap(54, 54, 54)
                .addComponent(lblGoback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(lblCopyRight)
                .addGap(30, 30, 30))
        );

        getContentPane().add(leftSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        headerPanel.setBackground(new java.awt.Color(117, 117, 111));
        headerPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setText("Dashboard Administrativo");

        lblSignOut.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        lblSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/personOut.png"))); // NOI18N
        lblSignOut.setText("Cerrar Sesión");
        lblSignOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(343, 343, 343)
                .addComponent(lblSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, 80));

        bodyPanel.setBackground(new java.awt.Color(16, 23, 27));
        bodyPanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        getContentPane().add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 1130, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        JpanelUsers panel = new JpanelUsers();
        panel.setSize(1130, 660);
        panel.setLocation(0, 0);
        bodyPanel.removeAll();
        bodyPanel.add(panel, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        JpanelProveedor panel = new JpanelProveedor();
        panel.setSize(1130, 660);
        panel.setLocation(0, 0);
        bodyPanel.removeAll();
        bodyPanel.add(panel, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnVariedadFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVariedadFActionPerformed
        JpanelVariedadF panel = new JpanelVariedadF();
        panel.setSize(1130, 660);
        panel.setLocation(0, 0);
        bodyPanel.removeAll();
        bodyPanel.add(panel, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_btnVariedadFActionPerformed

    private void btnFincasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFincasActionPerformed
        JpanelFincas panel = new JpanelFincas();
        panel.setSize(1130, 660);
        panel.setLocation(0, 0);
        bodyPanel.removeAll();
        bodyPanel.add(panel, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_btnFincasActionPerformed

    private void btnCosechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCosechaActionPerformed
        JpanelCosecha panel = new JpanelCosecha();
        panel.setSize(1130, 660);
        panel.setLocation(0, 0);
        bodyPanel.removeAll();
        bodyPanel.add(panel, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_btnCosechaActionPerformed

    private void lblGobackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGobackMouseClicked

        HomeScreen scr = new HomeScreen();
        scr.setLocationRelativeTo(null);
        scr.setVisible(true);
    }//GEN-LAST:event_lblGobackMouseClicked

    private void lblLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseClicked

        HomeScreen scr = new HomeScreen();
        scr.setLocationRelativeTo(null);
        scr.setVisible(true);
    }//GEN-LAST:event_lblLogoMouseClicked

    private void lblSignOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignOutMouseClicked
        LoginScreen scr = new LoginScreen();
        scr.setLocationRelativeTo(null);
        scr.setVisible(true);
    }//GEN-LAST:event_lblSignOutMouseClicked

    private void btnUsersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnUsersKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
            btnUsers.requestFocus();
        }
    }//GEN-LAST:event_btnUsersKeyPressed



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
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnCosecha;
    private javax.swing.JButton btnFincas;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnVariedadF;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCopyRight;
    private javax.swing.JLabel lblGoback;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSignOut;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel leftSidePanel;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
