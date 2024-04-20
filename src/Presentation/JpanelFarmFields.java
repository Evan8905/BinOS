package Presentation;

import Data.Conection;
import static Data.Conection.getConection;
import Data.FarmField;
import Data.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class JpanelFarmFields extends javax.swing.JPanel {

    /**
     * Creates new form JpanelFarmFields
     */
    public JpanelFarmFields() {
        initComponents();
    }

    public void createNewField() {

        String idField = txtID.getText();
        String number = txtNumberField.getText();
        int numberFarm = Integer.parseInt(number);
        String size = txtSizeField.getText();
        String farmId = txtFarmId.getText(); // esta es una llave foranea con el id de la finca

        FarmField field = new FarmField(idField, numberFarm, size, farmId);
        Conection.insertFields(field);
        cleanUpForm();
    }

    public void cleanUpForm() {
        // Limpiar campos de texto
        txtID.setText("");
        txtNumberField.setText("");
        txtSizeField.setText("");
        txtFarmId.setText("");
        txtSearchByIdField.setText("");

    }

    public void showFieldDetails(String idField) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("SELECT * FROM FarmFields WHERE id_Field = ?")) {
            pstmt.setString(1, idField);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Obtener detalles del usuario desde el ResultSet
                String number = rs.getString("number");
                String size = rs.getString("size_Field");
                String farm = rs.getString("farm");
    

                // Establecer detalles del Lote en los campos de la interfaz
                txtID.setText(idField);
                txtNumberField.setText(number);
                txtSizeField.setText(size);
                txtFarmId.setText(farm);

            } else {
                // No se encontró ningún usuario con el idUser especificado
                JOptionPane.showMessageDialog(null, "No se encontró ningún Lote con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar Lote: " + e.getMessage());
        }
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
        txtID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtNumberField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtSizeField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtFarmId = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        btnRead = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSearchByIdField = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(16, 23, 27));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(244, 67, 54));
        jLabel1.setText("Lotes");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 70, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 142, 73));
        jLabel2.setText("ID");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 30, -1));

        txtID.setBackground(new java.awt.Color(16, 23, 27));
        txtID.setForeground(new java.awt.Color(204, 204, 204));
        txtID.setBorder(null);
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 280, 20));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 280, 10));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 142, 73));
        jLabel3.setText("Número de lote");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 110, -1));

        txtNumberField.setBackground(new java.awt.Color(16, 23, 27));
        txtNumberField.setForeground(new java.awt.Color(204, 204, 204));
        txtNumberField.setBorder(null);
        add(txtNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 280, 20));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 280, 10));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 142, 73));
        jLabel4.setText("Tamaño de lote");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 150, -1));

        txtSizeField.setBackground(new java.awt.Color(16, 23, 27));
        txtSizeField.setForeground(new java.awt.Color(204, 204, 204));
        txtSizeField.setBorder(null);
        add(txtSizeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 280, 20));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 280, 10));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 142, 73));
        jLabel5.setText("ID de la finca");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 180, -1));

        txtFarmId.setBackground(new java.awt.Color(16, 23, 27));
        txtFarmId.setForeground(new java.awt.Color(204, 204, 204));
        txtFarmId.setBorder(null);
        add(txtFarmId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 280, 20));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 280, 10));

        btnRead.setText("Consultar");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 142, 73));
        jLabel8.setText("Consultar Registro por ID");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 180, -1));

        txtSearchByIdField.setBackground(new java.awt.Color(16, 23, 27));
        txtSearchByIdField.setForeground(new java.awt.Color(204, 204, 204));
        txtSearchByIdField.setBorder(null);
        add(txtSearchByIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 280, 20));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 280, 10));

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, -1, -1));

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, -1, -1));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        String idField = txtSearchByIdField.getText();
        showFieldDetails(idField);
        btnSave.setEnabled(false);    }//GEN-LAST:event_btnReadActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        createNewField();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String idField = txtID.getText();
        String number = txtNumberField.getText();
        int numberFarm = Integer.parseInt(number);
        String size = txtSizeField.getText();
        String farmId = txtFarmId.getText();

        Conection conection = new Conection();
        conection.updateField(idField, numberFarm, size, farmId);
        cleanUpForm();
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String idField = txtSearchByIdField.getText();
        Conection.deleteField(idField);
        cleanUpForm();
    }//GEN-LAST:event_btnDeleteActionPerformed


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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField txtFarmId;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNumberField;
    private javax.swing.JTextField txtSearchByIdField;
    private javax.swing.JTextField txtSizeField;
    // End of variables declaration//GEN-END:variables
}
