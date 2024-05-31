package Datos;

import Entidades.Cliente;


import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BDCliente {
    Conexiones BLcon = new Conexiones();
    public int insertarCliente(Cliente objCliente) throws SQLException, ClassNotFoundException {
        String Sentencia = "Insert into Clientes (Cedula,Nombres,Apellidos) "
                + "values (?,?,?)";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1,objCliente.getCdl());
        ps.setString(2,objCliente.getNombres());
        ps.setString(3,objCliente.getApellidos());
        return ps.executeUpdate(); //1 si se inserta -- 0 si no inserta
    }

    public ResultSet RecuperarUsuarios1(Cliente objCliente) throws ClassNotFoundException, SQLException{
        // String.format("'%s'", cdl);
        String Sentencia = "SELECT * FROM clientes where cedula = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCdl());
        return ps.executeQuery();
    }
}
