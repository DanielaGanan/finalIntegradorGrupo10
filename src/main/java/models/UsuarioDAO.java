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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danig
 */
public class UsuarioDAO {

    ConexionBD con = new ConexionBD();
    Connection cn;
    PreparedStatement ps;
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
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return usuarios;
    }

}
