
package ControladorBS;

/**
 *
 * @author Vinz
 */
import Aplicacion.LOGIN;
import Conexion.conexion;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CBSLogin {
    Connection con;
    PreparedStatement p;
    ResultSet r;
    //obejot de la clase conexion 
    conexion cn = new conexion();
    //METODO 
    public LOGIN log(String correo, String contraseña){
        //Creamos el objeto de LOGIN
        LOGIN L = new LOGIN();
        String consultasql ="Select * from usuarios WHERE correo = ? AND contraseña = ?";
        try{
            con = cn.cox();
            p = con.prepareStatement(consultasql);
            //Le enviamos los dos parametros
            p.setString(1, correo);
            p.setString(2, contraseña);
            //Esto nos devuelve un resulset, por eso lo almacenamos en el Rersultset
            r= p.executeQuery();
            //EL NEXT NOS PERMITE navegar a través de las filas del conjunto de resultados y permite acceder a los datos de cada fila de manera secuencia
            if(r.next()){
                //Los datos recuperados de la tabla de la base de datos se almacenan RN LOD STRIBUTOS DE LA CLASE LOGIN
                L.setId(r.getInt("id"));
                L.setNombre(r.getString("nombre"));
                L.setCorreo(r.getString("correo"));
                L.setContraseña(r.getString("contraseña"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return L;
    }
    
}
