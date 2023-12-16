/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure.persistence.mysql;

import infrastructure.persistence.ConexionBD;
import infrastructure.persistence.IPersistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;

/**
 *
 * @author danig
 */
public class MysqlRepository implements IPersistencia {

    private Connection conexion;

    public MysqlRepository() {
        conexion = ConexionBD.conexiones();
    }

    @Override
    public void guardarUsuario(Usuario newUsuario) {
        String sql = "INSERT INTO usuarios_tortas (usuario, clave, direccion, piso_dpto, numero_telefono) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, newUsuario.getUsuario());
            ps.setString(2, newUsuario.getClave());
            ps.setString(3, newUsuario.getDireccion());
            ps.setString(4, newUsuario.getPisoDepto());
            ps.setInt(5, newUsuario.getTelefono());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("Dieta añadida con exito");
            }
            ps.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println("Error al cargar el usuario en mysql");
        }

    }

    @Override
    public Usuario getUsuarioId(String idUsuarioBuscado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> ListaUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario actualizar(Usuario actualizarUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
