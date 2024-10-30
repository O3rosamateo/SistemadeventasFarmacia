
package ControladorBS;

    
import Aplicacion.Proveedor;
import Conexion.conexion;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
            con= cn
            ps = con.prepareStatement(sql);
        } catch (Exception e){
            
        }
    }
    
}
