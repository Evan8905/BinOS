package Presentation;

import Data.Conection;
import static Data.Conection.getConection;
import Data.Farm;
import Data.User;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import Presentation.AdminScreen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eefre
 */
public class JpanelFincas extends javax.swing.JPanel {

    /**
     * Creates new form JpanelFincas
     */
    public JpanelFincas() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        txtIdFarm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtOwner = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumberFields = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSearchByID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();

        setBackground(new java.awt.Color(16, 23, 27));
        setForeground(new java.awt.Color(0, 142, 73));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(244, 67, 54));
        jLabel1.setText("Fincas");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 142, 73));
        jLabel2.setText("ID de Finca");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        txtIdFarm.setBackground(new java.awt.Color(16, 23, 27));
        txtIdFarm.setForeground(new java.awt.Color(204, 204, 204));
        txtIdFarm.setBorder(null);
        add(txtIdFarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 290, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 142, 73));
        jLabel3.setText("Nombre de Finca");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 150, -1));

        txtName.setBackground(new java.awt.Color(16, 23, 27));
        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.setBorder(null);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 290, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 142, 73));
        jLabel4.setText("Ubicación");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 80, -1));

        txtLocation.setBackground(new java.awt.Color(16, 23, 27));
        txtLocation.setForeground(new java.awt.Color(204, 204, 204));
        txtLocation.setBorder(null);
        add(txtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 290, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 142, 73));
        jLabel5.setText("Propietario");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        txtOwner.setBackground(new java.awt.Color(16, 23, 27));
        txtOwner.setForeground(new java.awt.Color(204, 204, 204));
        txtOwner.setBorder(null);
        add(txtOwner, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 290, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 142, 73));
        jLabel6.setText("Cantidad de lotes");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        txtNumberFields.setBackground(new java.awt.Color(16, 23, 27));
        txtNumberFields.setForeground(new java.awt.Color(204, 204, 204));
        txtNumberFields.setBorder(null);
        add(txtNumberFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 290, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 142, 73));
        jLabel7.setText("Buscar Finca por ID");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, -1, -1));

        txtSearchByID.setBackground(new java.awt.Color(16, 23, 27));
        txtSearchByID.setForeground(new java.awt.Color(204, 204, 204));
        txtSearchByID.setBorder(null);
        add(txtSearchByID, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 290, -1));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 290, -1));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 290, 10));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 290, -1));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 290, 10));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 290, 10));

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 290, 10));

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, -1, -1));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, -1, -1));

        btnRead.setText("Consultar");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 230, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveRecord();
    }//GEN-LAST:event_btnSaveActionPerformed

    public void saveRecord() {
        int opcion = JOptionPane.showConfirmDialog(txtOwner, "¿Desea agregar un lote a esta finca?", "Agregar Lote", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            String idFarm = txtIdFarm.getText();
            String nameFarm = txtName.getText();
            String location = txtLocation.getText();
            String owner = txtOwner.getText();
            String farmField = txtNumberFields.getText();
            Farm farm = new Farm(idFarm, nameFarm, location, owner, farmField);
            Conection.insertFarm(farm);
            cleanUpForm();

            AdminScreen nc = new AdminScreen();
            nc.clickLotes();

        } else {
            String idFarm = txtIdFarm.getText();
            String nameFarm = txtName.getText();
            String location = txtLocation.getText();
            String owner = txtOwner.getText();
            String farmField = txtNumberFields.getText();
            Farm farm = new Farm(idFarm, nameFarm, location, owner, farmField);
            Conection.insertFarm(farm);
            cleanUpForm();
        }
    }

    public void cleanUpForm() {
        // Limpiar campos de texto
        txtIdFarm.setText("");
        txtName.setText("");
        txtLocation.setText("");
        txtOwner.setText("");
        txtNumberFields.setText("");
        txtSearchByID.setText("");
    }

    public void showFarmDetails(String idFarm) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Farms WHERE id_Farm = ?")) {
            pstmt.setString(1, idFarm);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Obtener detalles del usuario desde el ResultSet
                String name = rs.getString("name");
                String location = rs.getString("location");
                String owner = rs.getString("owner");
                String cantLoter = rs.getString("cant_Lotes");

                // Establecer detalles del farm en los campos de la interfaz
                txtIdFarm.setText(idFarm);
                txtName.setText(name);
                txtLocation.setText(location);
                txtOwner.setText(owner);
                txtNumberFields.setText(cantLoter);

            } else {
                // No se encontró ningún usuario con el idUser especificado
                JOptionPane.showMessageDialog(null, "No se encontró ningúna finca con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar Finca: " + e.getMessage());
        }
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String idFarm = txtIdFarm.getText();
        String nameFarm = txtName.getText();
        String location = txtLocation.getText();
        String owner = txtOwner.getText();
        String farmField = txtNumberFields.getText();
    
        Conection conection = new Conection();
        conection.updateFarm(idFarm, nameFarm, location, owner, farmField);
        cleanUpForm();
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String idFarm = txtSearchByID.getText();
        Conection.deleteFarm(idFarm);
        cleanUpForm();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        String idfarm = txtSearchByID.getText();
        showFarmDetails(idfarm);
        btnSave.setEnabled(false);
    }//GEN-LAST:event_btnReadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField txtIdFarm;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberFields;
    private javax.swing.JTextField txtOwner;
    private javax.swing.JTextField txtSearchByID;
    // End of variables declaration//GEN-END:variables
}
