package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Conection {

    private static final String URL = "jdbc:sqlserver://localhost:1433;database=BinDB;user=sa;password=6040;encrypt=true;trustServerCertificate=true";

    public static Connection getConection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTables() {
        String createTableQuery = "CREATE TABLE Users ("
                + "id INT PRIMARY KEY IDENTITY,"
                + "username VARCHAR(50) UNIQUE NOT NULL,"
                + "password VARCHAR(50) NOT NULL"
                + ")";

        try (Connection con = getConection(); Statement stmt = con.createStatement()) {

            // Verificar si la tabla ya existe
            if (!tableExists("Users", stmt)) {
                stmt.executeUpdate(createTableQuery);
                JOptionPane.showMessageDialog(null, "Tabla de usuarios creada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La tabla de usuarios ya existe.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la tabla de usuarios: " + e.getMessage());
        }
    }

    private static boolean tableExists(String tableName, Statement stmt) throws SQLException {
        String checkTableQuery = "SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '" + tableName + "'";
        return stmt.executeQuery(checkTableQuery).next();
    }

    public static void insertUsers() {
        // here we are inserting users to the DB
        String[][] usuarios = {
            {"usuario1", "contraseña1"},
            {"usuario2", "contraseña2"},
            {"usuario3", "contraseña3"}

        };

        try (Connection con = getConection(); Statement stmt = con.createStatement()) {

            for (String[] usuario : usuarios) {
                String username = usuario[0];
                String password = usuario[1];
                String insertQuery = "INSERT INTO Users (username, password) VALUES ('" + username + "', '" + password + "')";
                stmt.executeUpdate(insertQuery);
            }

            JOptionPane.showMessageDialog(null, "Usuarios cargados exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar usuarios: " + e.getMessage());
        }
    }

    public static void consultarUsuarios() {
        String selectQuery = "SELECT * FROM Users";

        try (Connection con = getConection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {

            // Iterar sobre el conjunto de resultados y mostrar la información de cada usuario
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar usuarios: " + e.getMessage());
        }

    }

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
        //createTables();
        insertUsers();
    }
}
