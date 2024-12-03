package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Conexion {
    Connection con = null;

    String base = "pruebagit"; //Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + base; //Direccion, puerto y nombre de la Base de Datos
    String user = "root"; //Usuario de Acceso a MySQL
    String password = ""; //Password del usuario

    
    public Connection getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Connection");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}
