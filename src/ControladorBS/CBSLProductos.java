package ControladorBS;

import Aplicacion.Productos;
import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CBSLProductos {

    Connection con;
    conexion cn = new conexion();
    /*para eecutar nuestro pre... se utliza el preparedstatament*/
    PreparedStatement p;
    ResultSet rs;
    //metodo para registar productos

    public boolean RegistrarProductos(Productos prod) {
        String sql = "INSERT INTO productos (Código, Nombre, Cantidad, Precio, Provedores) VALUES(?,?,?,?,?)";

        try {
            con = cn.cox();
            p = con.prepareStatement(sql);
            p.setString(1, prod.getNombre());
            p.setString(2, prod.getCodigo());
            p.setInt(3, prod.getCantidad());
            p.setDouble(4, prod.getPrecio());
            p.setString(5, prod.getProvedores());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    //metodo de listar proveedor en el combo vox

    public void ConsultarProveedor(JComboBox Prov) {
        String sql = "SELECT nombre FROM proveedores";

        try {
            con = cn.cox();
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                Prov.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    //METODO PARA LISTAR CLIENTES 
    public List ListarProductos() {
        List<Productos> listapro = new ArrayList();
        String Consultasql = "SELECT * FROM productos";
        try {
            //Conexion  
            con = cn.cox();
            //Preparacion de la consulta
            p = con.prepareStatement(Consultasql);
            //guardas el resultado en un objeto ResultSet llamado r
            rs = p.executeQuery();
            //Recorremos los Resultados:
            while (rs.next()) {
                Productos prod = new Productos();
                //Los datos recuperados de la tabla de la base de datos se almacenan eN LOs aTRIBUTOS DE LA CLASE Productos
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("Nombre"));
                prod.setCodigo(rs.getString("Código"));
                prod.setCantidad(rs.getInt("Cantidad"));
                prod.setPrecio(rs.getDouble("Precio"));
                prod.setProvedores(rs.getString("Provedores"));
                //Se agrega a la lista
                listapro.add(prod);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        //RETORNA LA LISTA 
        return listapro;
    }

    //metodo para eliminar productos
    public boolean EliminarProductos(int id) {
        String Consultasql = "DELETE FROM productos WHERE id = ?";
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
    public boolean ActualizarProducto(Productos prod) {
        String Consultasql = "UPDATE productos SET Código=?, Nombre=?, Cantidad=?, Precio=?, Provedores=? WHERE id=?";
        try {
            p = con.prepareStatement(Consultasql);
            p.setString(1, prod.getNombre());
            p.setString(2, prod.getCodigo());
            p.setInt(3, prod.getCantidad());
            p.setDouble(4, prod.getPrecio());
            p.setString(5, prod.getProvedores());
            p.setInt(6, prod.getId());
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
