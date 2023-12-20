/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danig
 */
public class ConexionBD {
    
    //HACER LA CONEXION CON LA DEPENDENCIA
    
    public static Connection conexiones () {
    
        Connection conexion = null;
            
            String host = "localhost";
            String port = "3306";
            String username = "root";
            String password = "root";
            String nombredb = "datos";
            String drive = "com.mysql.cj.jdbc.Driver";
            
        try {
            //Cargar Driver
            Class.forName(drive);
            String url = "jdbc:mysql://"+ host + ":" + port + "/" + nombredb;
            
            try {
                conexion = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Error en la conexion con la bd");
                ex.getStackTrace();
            }
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver");
            ex.getStackTrace();
        }
    
        return conexion;
    }
    
    
    
    
}
