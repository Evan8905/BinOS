package Presentation;

import Data.Boleta;
import Data.Conection;
import static Data.Conection.getConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class JpanelBoleta extends javax.swing.JPanel {

    /**
     * Creates new form JpanelBoleta
     */
    public JpanelBoleta() {
        initComponents();
        getIDCosechaFromDB();
        getIDFincaFromDB();
        getIDFinca2FromDB();
        getIDloteFromDB();
        getIDlote2FromDB();
        getIDFvariedadFromDB();
    }

    public void createNewBoleta() {
        String Nboleta = lblConsecBoleta.getText();

        String nbin1 = txtBin1.getText();
        String idFinca1 = cmbIdFinca1.getSelectedItem().toString();
        String idLote1 = cmbIdLote1.getSelectedItem().toString();
        String cant1 = txtCant1.getText();

        String nbin2 = txtBin2.getText();
        String idFinca2 = cmbIdFinca2.getSelectedItem().toString();
        String idLote2 = cmbIdLote2.getSelectedItem().toString();
        String cantidad2 = txtICant2.getText();

        String placaCamion = txtPlacaCamion.getText();
        Date date = jDateChooser1.getDate();

        String horaCarga = txtHoraCarga.getText();
        String horaDescarga = txtHoraDescarga.getText();
        String idCosecha = cmbIdCosecha.getSelectedItem().toString();
        String idFruto = cmbTfruto.getSelectedItem().toString();
        String cuadrilla = txtCuadrilla.getText();
        String observaciones = txtObservaciones.getText();

        Boleta boleta = new Boleta(Nboleta, nbin1, idFinca1, idLote1, cant1,
                nbin2, idFinca2, idLote2, cantidad2, placaCamion,
                date, horaCarga, horaDescarga, idCosecha, idFruto,
                cuadrilla, observaciones);
        Conection.insertBoleta(boleta);
    }

    public void showBoletaDetails(String idBoleta) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Boleta WHERE Nboleta = ?")) {
            pstmt.setString(1, idBoleta);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Obtener detalles de la boleta desde el ResultSet
                String nbin1 = rs.getString("Nbin1");
                String idFinca1 = rs.getString("idFinca1");
                String idLote1 = rs.getString("idLote1");
                String cant1 = rs.getString("Cantidad1");
                String nbin2 = rs.getString("Nbin2");
                String idFinca2 = rs.getString("idFinca2");
                String idLote2 = rs.getString("idLote2");
                String cantidad2 = rs.getString("Cantidad2");
                String placaCamion = rs.getString("placaCamion");
                Date date = rs.getDate("fecha");
                String horaCarga = rs.getString("horaCarga");
                String horaDescarga = rs.getString("horaDescarga");
                String idCosecha = rs.getString("idCosecha");
                String idFruto = rs.getString("idFruto");
                String cuadrilla = rs.getString("Cuadrilla");
                String observaciones = rs.getString("Observaciones");

                // Establecer detalles de la boleta en los campos de la interfaz
                txtBin1.setText(nbin1);
                cmbIdFinca1.setSelectedItem(idFinca1);
                cmbIdLote1.setSelectedItem(idLote1);
                txtCant1.setText(cant1);
                txtBin2.setText(nbin2);
                cmbIdFinca2.setSelectedItem(idFinca2);
                cmbIdLote2.setSelectedItem(idLote2);
                txtICant2.setText(cantidad2);
                txtPlacaCamion.setText(placaCamion);
                jDateChooser1.setDate(date); 
                txtHoraCarga.setText(horaCarga);
                txtHoraDescarga.setText(horaDescarga);
                cmbIdCosecha.setSelectedItem(idCosecha);
                cmbTfruto.setSelectedItem(idFruto);
                txtCuadrilla.setText(cuadrilla);
                txtObservaciones.setText(observaciones);
            } else {
                // No se encontró ninguna boleta con el idBoleta especificado
                JOptionPane.showMessageDialog(null, "No se encontró ninguna Boleta con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar Boleta: " + e.getMessage());
        }
    }

    public static String generarNumBoleta() {
        // Generar un número aleatorio para el consecutivo de la boleta
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(10000); // Generar un número aleatorio entre 0 y 9999
        return "REG" + String.format("%04d", numeroAleatorio); // Formatear el número aleatorio con 4 dígitos
    }

    private void cargarConsecutivo() {
        // Generar el consecutivo de la boleta
        String consecutivo = generarNumBoleta();

        // Actualizar el JLabel con el consecutivo generado
        lblConsecBoleta.setText(consecutivo);
    }

    private List<String> getCosechaFromDatabase() {
        List<String> cosechaIDs = new ArrayList<>();

        String selectQuery = "SELECT id_cosecha FROM Cosecha";

        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(selectQuery)) {
            // Ejecutar la consulta
            ResultSet resultSet = stmt.executeQuery();

            // Iterar sobre los resultados y agregar solo el ID a la lista
            while (resultSet.next()) {
                String idCosecha = resultSet.getString("id_cosecha");
                cosechaIDs.add(idCosecha);
            }

            System.out.println("ID de cosecha cargados exitosamente desde la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los ID de cosecha desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return cosechaIDs;
    }

    private void getIDCosechaFromDB() {
        List<String> cosechaIDs = getCosechaFromDatabase();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(cosechaIDs.toArray(new String[0]));
        cmbIdCosecha.setModel(model);
    }

    private List<String> getFincaFromDatabase() {
        List<String> fincaIDs = new ArrayList<>();

        String selectQuery = "SELECT id_Farm FROM Farms";

        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(selectQuery)) {
            // Ejecutar la consulta
            ResultSet resultSet = stmt.executeQuery();

            // Iterar sobre los resultados y agregar solo el ID a la lista
            while (resultSet.next()) {
                String idFinca = resultSet.getString("id_Farm");
                fincaIDs.add(idFinca);
            }

            System.out.println("ID de Finca cargados exitosamente desde la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al Finca los ID de cosecha desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return fincaIDs;
    }

    private void getIDFincaFromDB() {
        List<String> cosechaIDs = getFincaFromDatabase();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(cosechaIDs.toArray(new String[0]));
        cmbIdFinca1.setModel(model);
        //cmbIdFinca2.setModel(model);
    }

    private List<String> getFinca2FromDatabase() {
        List<String> fincaIDs = new ArrayList<>();

        String selectQuery = "SELECT id_Farm FROM Farms";

        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(selectQuery)) {
            // Ejecutar la consulta
            ResultSet resultSet = stmt.executeQuery();

            // Iterar sobre los resultados y agregar solo el ID a la lista
            while (resultSet.next()) {
                String idFinca = resultSet.getString("id_Farm");
                fincaIDs.add(idFinca);
            }

            System.out.println("ID de Finca cargados exitosamente desde la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al Finca los ID de cosecha desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return fincaIDs;
    }

    private void getIDFinca2FromDB() {
        List<String> cosechaIDs = getFinca2FromDatabase();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(cosechaIDs.toArray(new String[0]));
        //cmbIdFinca1.setModel(model);
        cmbIdFinca2.setModel(model);
    }

    private List<String> getLoteFromDatabase() {
        List<String> fincaIDs = new ArrayList<>();

        String selectQuery = "SELECT id_Field FROM FarmFields";

        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(selectQuery)) {
            // Ejecutar la consulta
            ResultSet resultSet = stmt.executeQuery();

            // Iterar sobre los resultados y agregar solo el ID a la lista
            while (resultSet.next()) {
                String idField = resultSet.getString("id_Field");
                fincaIDs.add(idField);
            }

            System.out.println("ID de Lote cargados exitosamente desde la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los ID de Lote desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return fincaIDs;
    }

    private void getIDloteFromDB() {
        List<String> cosechaIDs = getLoteFromDatabase();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(cosechaIDs.toArray(new String[0]));
        cmbIdLote1.setModel(model);
        //cmbIdLote2.setModel(model);

    }

    private List<String> getLote2FromDatabase() {
        List<String> fincaIDs = new ArrayList<>();

        String selectQuery = "SELECT id_Field FROM FarmFields";

        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(selectQuery)) {
            // Ejecutar la consulta
            ResultSet resultSet = stmt.executeQuery();

            // Iterar sobre los resultados y agregar solo el ID a la lista
            while (resultSet.next()) {
                String idField = resultSet.getString("id_Field");
                fincaIDs.add(idField);
            }

            System.out.println("ID de Lote cargados exitosamente desde la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los ID de Lote desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return fincaIDs;
    }

    private void getIDlote2FromDB() {
        List<String> cosechaIDs = getLote2FromDatabase();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(cosechaIDs.toArray(new String[0]));

        cmbIdLote2.setModel(model);

    }

    private List<String> getFVariedadDatabase() {
        List<String> fincaIDs = new ArrayList<>();

        String selectQuery = "SELECT id_variedad FROM Variedad";

        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(selectQuery)) {
            // Ejecutar la consulta
            ResultSet resultSet = stmt.executeQuery();

            // Iterar sobre los resultados y agregar solo el ID a la lista
            while (resultSet.next()) {
                String idVariedad = resultSet.getString("id_Variedad");
                fincaIDs.add(idVariedad);
            }

            System.out.println("ID de Variedad cargados exitosamente desde la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los ID de Variedad desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return fincaIDs;
    }

    private void getIDFvariedadFromDB() {
        List<String> cosechaIDs = getFVariedadDatabase();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(cosechaIDs.toArray(new String[0]));
        cmbTfruto.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCant1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbIdFinca1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbIdLote1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtBin1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblConsecBoleta = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtHoraCarga = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtPlacaCamion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtHoraDescarga = new javax.swing.JTextField();
        cmbIdCosecha = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbTfruto = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtCuadrilla = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtICant2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbIdFinca2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbIdLote2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtBin2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSearchById = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1130, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("N. Bin: ");

        txtCant1.setBackground(new java.awt.Color(204, 204, 204));
        txtCant1.setForeground(new java.awt.Color(0, 0, 0));
        txtCant1.setBorder(null);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("ID Finca:");

        cmbIdFinca1.setBackground(new java.awt.Color(204, 204, 204));
        cmbIdFinca1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ID Lote:");

        cmbIdLote1.setBackground(new java.awt.Color(204, 204, 204));
        cmbIdLote1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Cantidad:");

        txtBin1.setBackground(new java.awt.Color(204, 204, 204));
        txtBin1.setForeground(new java.awt.Color(0, 0, 0));
        txtBin1.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCant1)
                    .addComponent(cmbIdFinca1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbIdLote1, 0, 241, Short.MAX_VALUE)
                    .addComponent(txtBin1))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBin1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbIdFinca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbIdLote1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 360, 180));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Boleta de Cosecha");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 220, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("N. Boleta: ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 60, -1));

        lblConsecBoleta.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        lblConsecBoleta.setForeground(new java.awt.Color(102, 0, 0));
        add(lblConsecBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 110, 30));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Placa Camión:");

        txtHoraCarga.setBackground(new java.awt.Color(204, 204, 204));
        txtHoraCarga.setForeground(new java.awt.Color(0, 0, 0));
        txtHoraCarga.setBorder(null);

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Fecha:");

        jDateChooser1.setBackground(new java.awt.Color(204, 204, 204));
        jDateChooser1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Hora de carga:");

        txtPlacaCamion.setBackground(new java.awt.Color(204, 204, 204));
        txtPlacaCamion.setForeground(new java.awt.Color(0, 0, 0));
        txtPlacaCamion.setBorder(null);

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Hora de descarga:");

        txtHoraDescarga.setBackground(new java.awt.Color(204, 204, 204));
        txtHoraDescarga.setForeground(new java.awt.Color(0, 0, 0));
        txtHoraDescarga.setBorder(null);

        cmbIdCosecha.setBackground(new java.awt.Color(204, 204, 204));
        cmbIdCosecha.setForeground(new java.awt.Color(51, 51, 51));

        jLabel16.setBackground(new java.awt.Color(51, 51, 51));
        jLabel16.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("ID Cosecha:");

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("ID tipo Fruto:");

        cmbTfruto.setBackground(new java.awt.Color(204, 204, 204));
        cmbTfruto.setForeground(new java.awt.Color(51, 51, 51));

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Cuadrilla:");

        txtCuadrilla.setBackground(new java.awt.Color(204, 204, 204));
        txtCuadrilla.setForeground(new java.awt.Color(0, 0, 0));
        txtCuadrilla.setBorder(null);

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Observaciones");

        txtObservaciones.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(txtPlacaCamion)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCuadrilla)
                            .addComponent(txtHoraCarga)
                            .addComponent(cmbTfruto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbIdCosecha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoraDescarga, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtPlacaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoraCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoraDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cmbIdCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cmbTfruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtCuadrilla, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtObservaciones))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 640, 390));

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, -1, -1));

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, -1, -1));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 600, -1, -1));

        btnRead.setText("Consultar");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("N. Bin: ");

        txtICant2.setBackground(new java.awt.Color(204, 204, 204));
        txtICant2.setForeground(new java.awt.Color(0, 0, 0));
        txtICant2.setBorder(null);

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("ID Finca:");

        cmbIdFinca2.setBackground(new java.awt.Color(204, 204, 204));
        cmbIdFinca2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("ID Lote:");

        cmbIdLote2.setBackground(new java.awt.Color(204, 204, 204));
        cmbIdLote2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Cantidad:");

        txtBin2.setBackground(new java.awt.Color(204, 204, 204));
        txtBin2.setForeground(new java.awt.Color(0, 0, 0));
        txtBin2.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtICant2)
                    .addComponent(cmbIdFinca2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbIdLote2, 0, 241, Short.MAX_VALUE)
                    .addComponent(txtBin2))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBin2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbIdFinca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbIdLote2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtICant2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Buscar Boleta por ID");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 150, -1));

        txtSearchById.setBackground(new java.awt.Color(204, 204, 204));
        txtSearchById.setForeground(new java.awt.Color(0, 0, 0));
        txtSearchById.setBorder(null);
        add(txtSearchById, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 280, 20));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 280, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        cargarConsecutivo();
        createNewBoleta();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      String id = txtSearchById.getText();
        Conection.deleteBoleta(id);
        //cleanUpForm();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        String id = txtSearchById.getText();
        showBoletaDetails(id);
        btnSave.setEnabled(false);
    }//GEN-LAST:event_btnReadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbIdCosecha;
    private javax.swing.JComboBox<String> cmbIdFinca1;
    private javax.swing.JComboBox<String> cmbIdFinca2;
    private javax.swing.JComboBox<String> cmbIdLote1;
    private javax.swing.JComboBox<String> cmbIdLote2;
    private javax.swing.JComboBox<String> cmbTfruto;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblConsecBoleta;
    private javax.swing.JTextField txtBin1;
    private javax.swing.JTextField txtBin2;
    private javax.swing.JTextField txtCant1;
    private javax.swing.JTextField txtCuadrilla;
    private javax.swing.JTextField txtHoraCarga;
    private javax.swing.JTextField txtHoraDescarga;
    private javax.swing.JTextField txtICant2;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtPlacaCamion;
    private javax.swing.JTextField txtSearchById;
    // End of variables declaration//GEN-END:variables
}
