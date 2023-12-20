///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package mappers;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import models.Usuario;
//
//
///**
// *
// * @author danig
// */
//public class UsuarioMapper {
//    
//    ObjectMapper mapper;
//
//    public UsuarioMapper() {
//        this.mapper = new ObjectMapper();
//        
//    }
//    
//    // CONVIERTE EL USUARIO QUE LLEGA EN UN JSON
//    public String toJson (Usuario usuario) {
//        try { 
//            return mapper.writeValueAsString(usuario);
//        } catch (JsonProcessingException ex) {
//            ex.printStackTrace();
//        }
//        
//        return null;
//    }
//    
//
//    //TERMINAR DE INSTANCIAR EN EL SERVLET EN POST. UNA VEZ INICIALIZADO EL FORMULARIO
//
//    
//}
