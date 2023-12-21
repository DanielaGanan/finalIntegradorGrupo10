/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import infrastructure.persistence.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author danig
 */
public class PedidoDAO {
    ConexionBD con = new ConexionBD();
    Connection cn;
    PreparedStatement ps = null;
    ResultSet rs;
//    Usuario usuarios = new Usuario();
    
    public void guardarPedido(Pedido pedido) {

        try {
            String sql = "INSERT INTO pedidos (idProducto, id_usuario, kilos, precioTotal, fecha) VALUES (?,?,?,?,?)";

            cn = con.conexiones();
        
            PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getProducto().getIdProducto());
            ps.setInt(2, pedido.getUsuario().getIdUsuario());
            ps.setInt(3, pedido.getKilos());
            ps.setDouble(4, pedido.getPrecioTotal());
            ps.setDate(5, Date.valueOf(pedido.getFecha()));

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("Se guardo con exito el pedido");
            }
            ps.close();
            cn.close();

        } catch (SQLException ex) {
            System.out.println("Error al cargar el pedido en mysql");
        }

    }
    
    
}
