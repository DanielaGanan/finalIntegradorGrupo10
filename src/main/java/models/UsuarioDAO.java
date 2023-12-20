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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danig
 */
public class UsuarioDAO {

    ConexionBD con = new ConexionBD();
    Connection cn;
    PreparedStatement ps = null;
    ResultSet rs;
    Usuario usuarios = new Usuario();

    public Usuario Validar(String usuario, String clave) {

        String sql = "SELECT * FROM usuarios_tortas WHERE usuario = ? AND clave = ?";
        cn = con.conexiones();

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);

            rs = ps.executeQuery();
            rs.next();
            do {
                usuarios.setIdUsuario(rs.getInt("id_usuario"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setClave(rs.getString("clave"));
                usuarios.setDireccion(rs.getString("direccion"));
                usuarios.setPisoDepto(rs.getString("piso_dpto"));
                usuarios.setTelefono(rs.getInt("numero_telefono"));
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cierre de la conexión en el bloque finally
            if (cn != null) {
                try {
                    ps.close();
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return usuarios;
    }

    public void guardarUsuarios(Usuario newUsuario) {

        try {
            String sql = "INSERT INTO usuarios_tortas (usuario, clave, direccion, piso_dpto, numero_telefono) VALUES (?,?,?,?,?)";

            cn = con.conexiones();
  
        //    PreparedStatement ps = cn.prepareStatement(sql);
        //    cn.prepareStatement(sql);
        
            PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newUsuario.getUsuario());
            ps.setString(2, newUsuario.getClave());
            ps.setString(3, newUsuario.getDireccion());
            ps.setString(4, newUsuario.getPisoDepto());
            ps.setInt(5, newUsuario.getTelefono());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("Se guardo con exito");
            }
            ps.close();
            cn.close();

        } catch (SQLException ex) {
            System.out.println("Error al cargar el usuario en mysql");
        }

    }
    
}
