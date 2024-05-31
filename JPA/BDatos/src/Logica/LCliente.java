package Logica;

import Entidades.Cliente;
import Datos.BDCliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LCliente {
    static BDCliente cliente;
    public LCliente() {
    }
    public void agregarCliente(Cliente clientewtf) throws SQLException, ClassNotFoundException {
        cliente.insertarCliente(clientewtf);
    }

    public Boolean comprobarCedula(String cedula) {
        return cedula.length() == 10 && cedula.substring(0, 9).matches("[0-9]*");
    }
    public Cliente ObtenerCliente(Cliente objCliente) throws ClassNotFoundException, SQLException {
        //TRABAJO de los algoritmos
        ResultSet rs = cliente.RecuperarUsuarios1(objCliente);

        Cliente clienteBuscado = new Cliente();

        while (rs.next()){
            clienteBuscado.setIdCliente(rs.getInt("idCliente"));
            clienteBuscado.setNombres(rs.getString("Nombres"));
            clienteBuscado.setApellidos(rs.getString("Apellidos"));
            clienteBuscado.setCdl(rs.getString("Cedula"));
        }

        rs.close();
        return objCliente;
    }
}
