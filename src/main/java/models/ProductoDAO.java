/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import infrastructure.persistence.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danig
 */
public class ProductoDAO {
    
    ConexionBD con = new ConexionBD();
    Connection cn;
    PreparedStatement ps = null;
    ResultSet rs;
    //Producto producto = new Producto();
    
    public Producto buscarProducto(String nombre) {
        
        Producto producto = null;

        try {
            String sql = "SELECT idProducto, nombre, detalle, precio, stock FROM productos WHERE nombre = ?";
            
            cn = con.conexiones();
            
            ps = cn.prepareStatement(sql);
            
            ps.setString(1, nombre);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDetalle(rs.getString("detalle"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));   
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla productos" );
        }
        
        return producto;
    }

    public static String reemplazarEspacio(String cadena) {
        // Reemplazar guiones bajos con espacios
        return cadena.replace("_", " ");
        
    }
    
}
