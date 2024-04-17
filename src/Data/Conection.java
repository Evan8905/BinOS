package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Presentation.JpanelUsers;

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

            // Verificar si otra tabla existe y crearla si es necesario
            if (!tableExists("Productos", stmt)) {
                String createOtraTablaQuery = "CREATE TABLE Productos ("
                        + "id INT PRIMARY KEY IDENTITY,"
                        + "nombre VARCHAR(50),"
                        + "fecha VARCHAR(50)"
                        + ")";
                stmt.executeUpdate(createOtraTablaQuery);
                System.out.println("Tabla Productos creada exitosamente.");
            } else {
                System.out.println("La tabla Productos ya existe.");
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

//    public static void consultarUsuarios() {
//        String selectQuery = "SELECT * FROM Users";
//
//        try (Connection con = getConection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
//
//            // Iterar sobre el conjunto de resultados y mostrar la información de cada usuario
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//
//                System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password);
//            }
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al consultar usuarios: " + e.getMessage());
//        }
//
//    }
    public static boolean checkUser(String username, String password) {
        String selectQuery = "SELECT * FROM Users WHERE username = ? AND password = ?";

        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(selectQuery)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Devuelve true si se encuentra al menos un usuario con el nombre de usuario y contraseña proporcionados

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar usuario: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        //Conection.createDB();
        createTables();
        insertUsers();
    }
}
