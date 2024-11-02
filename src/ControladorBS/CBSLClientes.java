package ControladorBS;

import Aplicacion.Cliente;
import Conexion.conexion;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CBSLClientes {

    Connection con;
    PreparedStatement p;
    ResultSet r;
    //El objeto de la clase conexion 
    conexion cn = new conexion();

    //Metodo para registrar los clientes, si todo va bien devulve tru y si hay algun erro devuelve false y muestra un mensaje de error 
    public boolean RegistrarClientes(Cliente CLI) {
        //La consulta y ? son los parametros que se daran mas adelante 
        String Consultasql = "INSERT INTO clientes(Nombre, Telefono, Dirección, dni) VALUES(?,?,?,?)";
        try {
            //La conexion a la base de datos
            con = cn.cox();
            //Statement proporcionan soporte para añadir parámetros a sentencias SQL, se prepara la consulta a la base de datos 
            p = con.prepareStatement(Consultasql);
            //Le pasamos los parametros 
            p.setString(1, CLI.getNombre());
            p.setInt(2, CLI.getTelefono());
            p.setString(3, CLI.getDireccion());
            p.setInt(4, CLI.getDni());
            //Executa la consulta
            p.execute();
            return true;
            //Si hay un error nos lo va indicar 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
            //con esto aseguramos que se cierre la conexion a la base de datos, no importa si la operacion fue exitosa o no, si hay un error igulamente lo va mostrar
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }

    }

    //METODO PARA LISTAR CLIENTES 
    public List ListarClientes() {
        List<Cliente> listaClient = new ArrayList();
        String Consultasql = "SELECT * FROM clientes";
        try {
            //Conexion  
            con = cn.cox();
            //Preparacion de la consulta
            p = con.prepareStatement(Consultasql);
            //guardas el resultado en un objeto ResultSet llamado r
            r = p.executeQuery();
            //Recorremos los Resultados:
            while (r.next()) {
                Cliente CLI = new Cliente();
                //Los datos recuperados de la tabla de la base de datos se almacenan eN LOs aTRIBUTOS DE LA CLASE CLIENTES
                CLI.setId(r.getInt("id"));
                CLI.setNombre(r.getString("Nombre"));
                CLI.setTelefono(r.getInt("Telefono"));
                CLI.setDireccion(r.getString("Dirección"));
                CLI.setDni(r.getInt("dni"));
                //Se agrega a la lista
                listaClient.add(CLI);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        //RETORNA LA LISTA 
        return listaClient;
    }

    //METODO PARA ELIMINAR CLIENTE 
    public boolean EliminarClientes(int id) {
        String Consultasql = "DELETE FROM clientes WHERE id = ?";
        try {
            //Preparacion de la consulta
            p = con.prepareStatement(Consultasql);
            //se le pasa el argumento
            p.setInt(1, id);
            //se ejecuta la consulta 
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    //METODO PARA ACTUALIZAR LOS DATOS DEL CLIENTE 
    public boolean ActualizarCliente(Cliente CLI) {
        String Consultasql = "UPDATE clientes SET Nombre=?, Telefono=?, Dirección=?, dni=? WHERE id=?";
        try {
            p = con.prepareStatement(Consultasql);
            p.setString(1, CLI.getNombre());
            p.setInt(2, CLI.getTelefono());
            p.setString(3, CLI.getDireccion());
            p.setInt(4, CLI.getDni());
            p.setInt(5, CLI.getId());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

}
