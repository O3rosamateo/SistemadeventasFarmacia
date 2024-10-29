/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;


/**
 *
 * @author Vinz
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    //Creamos una variable de tipo Coneccion 
    Connection con;
    //Variables de la conexion
    String user="root";
    String password ="keylapoleiko08";
    String url= "jdbc:mysql://localhost:3306/sistemadeventasfarmacia";
    String drive = "com.mysql.cj.jdbc.Driver";
    
    //Metodo de conexion
     public  Connection cox() {
         try{
             //Se ingresa el drive de bs
             Class.forName(drive);
             con= (Connection)DriverManager.getConnection(url, user, password);
             return con;
         }catch(ClassNotFoundException | SQLException e){
             System.out.println(e.getMessage());
             
         } 
        return null;    
     }
}
