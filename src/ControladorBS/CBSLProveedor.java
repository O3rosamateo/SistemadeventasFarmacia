
package ControladorBS;

    
import Aplicacion.Proveedor;
import Conexion.conexion;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class CBSLProveedor {

 Connection con; 
 conexion cn= new conexion();
 /*para eecutar nuestro pre... se utliza el preparedstatament*/
    PreparedStatement p;
    //para registaar proveedor
    public boolean RegistrarProveedor(Proveedor pro){
        String sql ="INSERT INTO proveedores(ruc, nombre, telefono, direccion) VALUES (?,?,?,?)";
        
    /*crear un try cath para capturar la excepcion*/
        try {
            con= cn.cox();
            p= con.prepareStatement(sql);
            p.setInt(1, pro.getRuc());
            p.setString(2, pro.getNombre());
            p.setInt(3, pro.getTelefono());
            p.setString(4, pro.getDireccion());
            p.execute();
            return true;
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean EliminarProveedor(int ruc){
        String sql = "DELATE FROM proveedores WHHERE ruc=?";
        try {
            con =cn.cox();
            p=con.prepareStatement(sql);
            p.setInt(1, ruc);
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally {
            try {
                con.close();
                
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}

