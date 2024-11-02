
package ControladorBS;

    
import Aplicacion.Proveedor;
import Conexion.conexion;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class CBSLProveedor {

 Connection con; 
 conexion cn= new conexion();
 /*para eecutar nuestro pre... se utliza el preparedstatament*/
 PreparedStatement p;
 //para obtener el resultado 
 ResultSet rs;
 
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
        } catch (SQLException e){      
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    //metodo para listar proveedor 
    public List ListarProveedor(){
        List<Proveedor> proLista=new ArrayList(); 
        String sql = "SELECT * FROM proveedores"; //para ejecutar nuestra consulta
        /*para capturar las excepsiones */
        try {
            con = cn.cox();
            p= con.prepareStatement(sql);
            rs= p.executeQuery(); //nos devuelve un resultset
            //con un bucle while vamos a recorrer todo el resultado
            while (rs.next()) {                
               Proveedor  pre=new Proveedor();
               pre.setId(rs.getInt("id"));
               pre.setRuc(rs.getInt("ruc"));
               pre.setNombre(rs.getString("nombre"));
               pre.setTelefono(rs.getInt("telefono"));
               pre.setDireccion(rs.getString("direccion"));
               proLista.add(pre);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());  //si tenemos lagun error
        }
        return proLista;
    }
    
        //metodo para eliminar
        public boolean EliminarProveedor(int id){
        String sql = "DELETE FROM proveedores WHERE id = ?";
        
        try {
            
            //Preparacion de la consulta
            p=con.prepareStatement(sql);
            //se le pasa el argumento
            p.setInt(1, id);
            //se ejecuta la consulta 
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally { //cerrar la conexcion
            try {
                con.close();  
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
        
        //metodo para actualizar proveedor 
        
        public boolean ModificarProveedor(Proveedor pro){
            String sql= "UPDATE proveedores SET ruc=?, nombre=?, telefono=?, direccion=? WHERE id=?";
            
            try {
            p = con.prepareStatement(sql);
            p.setInt(1, pro.getRuc());
            p.setString(2, pro.getNombre());
            p.setInt(3, pro.getTelefono());
            p.setString(4, pro.getDireccion());
            p.setInt(5, pro.getId());
            p.execute();
            return true;
            } catch (SQLException e) {
                System.out.println(e.toString());
                return false;
            }finally{
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.toString());
                }
            }
        }
}

