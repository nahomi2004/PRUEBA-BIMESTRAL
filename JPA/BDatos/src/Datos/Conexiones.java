package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexiones {
    public Connection con;
    public Connection getConnection () throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/clase1_semana2";
        Class.forName(driver);
        return DriverManager.getConnection(url,"root","ilovelasranas2");
    }
    public Connection AbrirConexion() throws ClassNotFoundException, SQLException{
        con = getConnection();
        return con;
    }
    public void CerrarConexion() throws SQLException{
        con.close();
    }
}
