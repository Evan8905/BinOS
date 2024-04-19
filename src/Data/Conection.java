package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Conection {

    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "1433";
    private static final String DB_NAME = "dbProdBinOS";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "6040";
    //private static String URL;

    //private static final String URL = "jdbc:sqlserver://localhost:1433;database=BinDB;user=sa;password=6040;encrypt=true;trustServerCertificate=true";
    //private static final String dbName = "dbOficialBin";
    private static final String URL = "jdbc:sqlserver://" + DB_HOST + ":" + DB_PORT + ";database=" + DB_NAME + ";user=" + DB_USER + ";password=" + DB_PASSWORD + ";encrypt=true;trustServerCertificate=true";

    public static void createDB() {

        try (Connection connection = DriverManager.getConnection(URL); Statement statement = connection.createStatement()) {

            if (!databaseExists(connection, DB_NAME)) {
                String createDatabaseSQL = "CREATE DATABASE " + DB_NAME;
                statement.executeUpdate(createDatabaseSQL);
                System.out.println("Base de datos creada exitosamente.");
            } else {
                System.out.println("La base de datos ya existe.");
            }
        } catch (SQLException e) {
            System.err.println("Error al crear la base de datos: " + e.getMessage());
            // Aquí podrías lanzar una excepción personalizada o registrar el error en un archivo de registro
        }
    }

    private static boolean databaseExists(Connection connection, String DB_NAME) throws SQLException {
        // Verificar si la base de datos ya existe 
        String checkDatabaseQuery = "SELECT name FROM sys.databases WHERE name = '" + DB_NAME + "'";
        try (Statement stmt = connection.createStatement(); var resultSet = stmt.executeQuery(checkDatabaseQuery)) {
            return resultSet.next();
        }
    }

    public static Connection getConection() throws SQLException {
        if (URL == null) {
            createDB(); // Si la URL es nula, significa que la base de datos no se ha creado aún, así que intentamos crearla
        }
        return DriverManager.getConnection(URL);
    }

    public static void createTables() {
        try (Connection con = getConection(); Statement stmt = con.createStatement()) {

            // Verificar si la tabla de usuarios ya existe
            if (!tableExists("Users", stmt)) {
                // Si no existe, crearla
                String createUsersTableQuery = "CREATE TABLE Users ("
                        + "id INT PRIMARY KEY IDENTITY,"
                        + "idUser VARCHAR(50) NOT NULL,"
                        + "name VARCHAR(50) NOT NULL,"
                        + "username VARCHAR(50) UNIQUE NOT NULL,"
                        + "password VARCHAR(50) NOT NULL,"
                        + "type BIT NOT NULL," // BIT para tipo booleano
                        + "state BIT NOT NULL" // BIT para tipo booleano
                        + ")";
                stmt.executeUpdate(createUsersTableQuery);
                System.out.println("Tabla de usuarios creada exitosamente.");
            } else {
                System.out.println("La tabla de usuarios ya existe.");
            }

            if (!tableExists("Farms", stmt)) {
                String createOtraTablaQuery = "CREATE TABLE Farms ("
                        + "id INT PRIMARY KEY IDENTITY,"
                        + "id_Farm VARCHAR(50) UNIQUE NOT NULL,"
                        + "name VARCHAR(50) NOT NULL,"
                        + "location VARCHAR(50) NOT NULL,"
                        + "owner VARCHAR(50) NOT NULL,"
                        + "cant_Lotes VARCHAR(50) NOT NULL"
                        + ")";
                stmt.executeUpdate(createOtraTablaQuery);
                System.out.println("Tabla Farms creada exitosamente.");
            } else {
                System.out.println("La tabla Farms ya existe.");
            }
            if (!tableExists("FarmFields", stmt)) {
                String createOtraTablaQuery = "CREATE TABLE FarmFields ("
                        + "id INT PRIMARY KEY IDENTITY,"
                        + "id_Field VARCHAR(50) NOT NULL,"
                        + "number INT NOT NULL,"
                        + "size_Field VARCHAR(50) NOT NULL,"
                        + "farm VARCHAR(50) NOT NULL,"
                        + "FOREIGN KEY (farm) REFERENCES Farms(id_Farm)"
                        + ")";
                stmt.executeUpdate(createOtraTablaQuery);
                System.out.println("Tabla FarmFields creada exitosamente.");
            } else {
                System.out.println("La tabla FarmFields ya existe.");
            }
            if (!tableExists("Variedad", stmt)) {
                String createOtraTablaQuery = "CREATE TABLE Variedad ("
                        + "id INT PRIMARY KEY IDENTITY,"
                        + "id_variedad VARCHAR(50) NOT NULL,"
                        + "name VARCHAR(50) NOT NULL,"
                        + "description VARCHAR(50) NOT NULL"
                        + ")";
                stmt.executeUpdate(createOtraTablaQuery);
                System.out.println("Tabla variedad de fruto creada exitosamente.");
            } else {
                System.out.println("La tabla variedad de fruto ya existe.");
            }
            if (!tableExists("Cosecha", stmt)) {
                String createOtraTablaQuery = "CREATE TABLE Cosecha ("
                        + "id INT PRIMARY KEY IDENTITY,"
                        + "id_cosecha VARCHAR(50) UNIQUE NOT NULL,"
                        + "type VARCHAR(50) NOT NULL,"
                        + "description VARCHAR(50) NOT NULL"
                        + ")";
                stmt.executeUpdate(createOtraTablaQuery);
                System.out.println("Tabla Cosecha creada exitosamente.");
            } else {
                System.out.println("La tabla Cosecha ya existe.");
            }

            if (!tableExists("Proveedor", stmt)) {
                String createOtraTablaQuery = "CREATE TABLE Proveedor ("
                        + "id INT PRIMARY KEY IDENTITY,"
                        + "id_Proveedor VARCHAR(50) NOT NULL,"
                        + "name VARCHAR(50) NOT NULL,"
                        + "address VARCHAR(50) NOT NULL,"
                        + "phone VARCHAR(50) NOT NULL,"
                        + "id_De_Cosecha VARCHAR(50) NOT NULL,"
                        + "FOREIGN KEY (id_De_Cosecha) REFERENCES Cosecha(id_cosecha)"
                        + ")";
                stmt.executeUpdate(createOtraTablaQuery);
                System.out.println("Tabla Proveedor creada exitosamente.");
            } else {
                System.out.println("La tabla Proveedor ya existe.");
            }

            // Agregar más bloques if para cada tabla adicional que desees crear
        } catch (SQLException e) {
            System.err.println("Error al crear las tablas: " + e.getMessage());
            // Aquí podrías lanzar una excepción personalizada o registrar el error en un archivo de registro
        }
    }

    private static boolean tableExists(String tableName, Statement stmt) throws SQLException {
        String checkTableQuery = "SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '" + tableName + "'";
        return stmt.executeQuery(checkTableQuery).next();
    }

    public static void insertUsers() {
        //insertando usuarios en la base de datos
        String[][] usuarios = {
            {"usuario1", "contraseña1", "123456789", "Nombre1", "true", "true"},
            {"usuario2", "contraseña2", "987654321", "Nombre2", "false", "true"},
            {"usuario3", "contraseña3", "456789123", "Nombre3", "true", "false"},
            {"admin", "admin", "654321987", "Evan", "true", "true"}
        };

        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO Users (idUser, name, username, password, type, state) VALUES (?, ?, ?, ?, ?, ?)")) {

            for (String[] usuario : usuarios) {
                String username = usuario[0];
                String password = usuario[1];
                String idUser = usuario[2];
                String name = usuario[3];
                boolean type = Boolean.parseBoolean(usuario[4]);
                boolean state = Boolean.parseBoolean(usuario[5]);

                pstmt.setString(1, idUser);
                pstmt.setString(2, name);
                pstmt.setString(3, username);
                pstmt.setString(4, password);
                pstmt.setBoolean(5, type);
                pstmt.setBoolean(6, state);
                pstmt.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Usuarios cargados exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar usuarios: " + e.getMessage());
        }
    }

    public static void insertUserUI(User user) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO Users (idUser, name, username, password, type, state) VALUES (?, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, user.getIdUser());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getPassword());
            pstmt.setBoolean(5, user.isType());
            pstmt.setBoolean(6, user.isStatus());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar usuario: " + e.getMessage());
        }
    }

    public static void updateUser(String idUser, String name, String username, String password, boolean type, boolean state) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("UPDATE Users SET name = ?, username = ?, password = ?, type = ?, state = ? WHERE idUser = ?")) {
            pstmt.setString(1, name);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setBoolean(4, type);
            pstmt.setBoolean(5, state);
            pstmt.setString(6, idUser);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
        }
    }

    //El metodo de read esta en la interfaz directamente.
    public static void deleteUser(String idUser) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("DELETE FROM Users WHERE idUser = ?")) {
            pstmt.setString(1, idUser);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
        }
    }

    public static int checkUser(String username, String password) {
        String selectQuery = "SELECT * FROM Users WHERE username = ? AND password = ?";
        String tipoUsuarioQuery = "SELECT type FROM Users WHERE username = ?";

        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(selectQuery); PreparedStatement tipoStmt = con.prepareStatement(tipoUsuarioQuery)) {

            // Verificar las credenciales del usuario
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Usuario y contraseña válidos, ahora obtenemos el tipo de usuario
                tipoStmt.setString(1, username);
                ResultSet tipoRs = tipoStmt.executeQuery();

                if (tipoRs.next()) {
                    boolean esAdministrador = tipoRs.getBoolean("type");
                    if (esAdministrador) {
                        // Usuario es un administrador
                        return 1;
                    } else {
                        // Usuario es un digitador
                        return 0;
                    }
                } else {
                    // No se encontró el tipo de usuario
                    return -1;
                }
            } else {
                // Usuario y/o contraseña incorrectos
                return -2;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar usuario: " + e.getMessage());
            return -3;
        }
    }

    /**
     * ***********************************************Farm*****************************************************************
     *
     *
     * @param args
     */
    public static void insertFarm(Farm farm) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO Farms (id_Farm, name, location, owner, cant_Lotes) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, farm.getIdFarm());
            pstmt.setString(2, farm.getNameFarm());
            pstmt.setString(3, farm.getLocation());
            pstmt.setString(4, farm.getOwner());
            pstmt.setString(5, farm.getFarmField());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Finca agregado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar Finca: " + e.getMessage());
        }
    }

    public static void deleteFarm(String idFarm) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("DELETE FROM Farms WHERE id_Farm = ?")) {
            pstmt.setString(1, idFarm);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Finca eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna finca con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Finca: " + e.getMessage());
        }
    }

    public static void updateFarm(String idFarm, String name, String location, String owner, String cantLotes) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("UPDATE Farms SET name = ?, location = ?, owner = ?, cant_Lotes = ? WHERE id_Farm = ?")) {
            pstmt.setString(1, name);
            pstmt.setString(2, location);
            pstmt.setString(3, owner);
            pstmt.setString(4, cantLotes);
            pstmt.setString(5, idFarm);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Finca actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningúna Finca con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Finca: " + e.getMessage());
        }
    }

    /**
     * ***********************************************LOTES*****************************************************************
     *
     *
     * @param args
     */
    public static void insertFields(FarmField field) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO FarmFields (id_Field, number, size_Field, farm) VALUES (?, ?, ?, ?)")) {
            pstmt.setString(1, field.getIdFarmField());
            pstmt.setInt(2, field.getNumberField());
            pstmt.setString(3, field.getFieldSize());
            pstmt.setString(4, field.getIdFromFarm());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Lote agregado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar Lote: " + e.getMessage());
        }
    }

    public static void deleteField(String idField) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("DELETE FROM FarmFields WHERE id_Field = ?")) {
            pstmt.setString(1, idField);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Lote eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningun Lote con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el lote: " + e.getMessage());
        }
    }

    public static void updateField(String idField, int number, String size, String farm) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("UPDATE FarmFields SET farm = ?, number = ?, size_Field = ? WHERE id_Field = ?")) {
            pstmt.setString(1, farm);
            pstmt.setInt(2, number);
            pstmt.setString(3, size);
            pstmt.setString(4, idField);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Lote actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún Lote con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Lote: " + e.getMessage());
        }
    }

    /**
     * ***********************************************Variedad de
     * fruto*****************************************************************
     *
     *
     * @param args
     */
    public static void insertVariedad(Fvariedad variedad) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO Variedad (id_variedad, name, description) VALUES (?, ?, ?)")) {
            pstmt.setString(1, variedad.getIdVariedad());
            pstmt.setString(2, variedad.getName());
            pstmt.setString(3, variedad.getDescription());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Variedad agregada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar Variedad: " + e.getMessage());
        }
    }

    public static void deleteVariedad(String idVariedad) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("DELETE FROM Variedad WHERE id_variedad = ?")) {
            pstmt.setString(1, idVariedad);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Variedad eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna variedad con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el variedad: " + e.getMessage());
        }
    }

    public static void updateVariedad(String idVariedad, String name, String description) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("UPDATE Variedad SET name = ?, description = ? WHERE id_variedad = ?")) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setString(3, idVariedad);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Variedad actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna Variedad con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar variedad: " + e.getMessage());
        }
    }

    // * ***********************************************Cosecha*****************************************************************
    public static void insertCosecha(Cosecha cosecha) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO Cosecha (id_cosecha, type, description) VALUES (?, ?, ?)")) {
            pstmt.setString(1, cosecha.getIdCosecha());
            pstmt.setString(2, cosecha.getTipo());
            pstmt.setString(3, cosecha.getDescription());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cosecha agregada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar Cosecha: " + e.getMessage());
        }
    }

    public static void deleteCosecha(String idCosecha) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("DELETE FROM Cosecha WHERE id_cosecha = ?")) {
            pstmt.setString(1, idCosecha);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Cosecha eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna Cosecha con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Cosecha: " + e.getMessage());
        }
    }

    public static void updateCosecha(String idCosecha, String type, String description) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("UPDATE Cosecha SET type = ?, description = ? WHERE id_cosecha = ?")) {
            pstmt.setString(1, type);
            pstmt.setString(2, description);
            pstmt.setString(3, idCosecha);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Cosecha actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna Cosecha con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Cosecha: " + e.getMessage());
        }
    }

    // * ***********************************************Proveedor*****************************************************************
    public static void insertProveedor(Proveedor proveedor) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO Proveedor (id_Proveedor, name, address, phone, id_De_Cosecha) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, proveedor.getIdProveedor());
            pstmt.setString(2, proveedor.getName());
            pstmt.setString(3, proveedor.getAddress());
            pstmt.setString(4, proveedor.getPhone());
            pstmt.setString(5, proveedor.getIdCosecha());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Proveedor agregado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar Proveedor: " + e.getMessage());
        }
    }

    public static void deleteProveedor(String idProveedor) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("DELETE FROM Proveedor WHERE id_Proveedor = ?")) {
            pstmt.setString(1, idProveedor);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningun Proveedor con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Proveedor: " + e.getMessage());
        }
    }

    public static void updateProveedor(String idProveedor, String name, String address, String phone, String idCosecha) {
        try (Connection con = getConection(); PreparedStatement pstmt = con.prepareStatement("UPDATE Proveedor SET name = ?, address = ?, phone = ?, id_De_Cosecha = ? WHERE id_Proveedor = ?")) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, phone);
            pstmt.setString(4, idCosecha);
            pstmt.setString(5, idProveedor);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningun Proveedor con el ID especificado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Proveedor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        //Conection.createDB();
        createTables();
        //insertUsers();
    }
}
