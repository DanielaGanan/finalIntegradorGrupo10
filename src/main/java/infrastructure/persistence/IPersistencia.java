/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infrastructure.persistence;

import java.util.ArrayList;
import models.Usuario;

/**
 *
 * @author danig
 */
public interface IPersistencia {

    // CREATE
    void guardarUsuario (Usuario newUsuario);
    
    
    // READ
    Usuario getUsuarioId (String idUsuarioBuscado);
    ArrayList <Usuario> ListaUsuarios();
    
    
    // UPDATE
    Usuario actualizar (Usuario actualizarUsuario);
    
    // DELETE
    void borrar (String id);
    
    
}
