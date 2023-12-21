///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import models.Pedido;
//import models.PedidoDAO;
//
///**
// *
// * @author danig
// */
//@WebServlet(name = "Controlador", urlPatterns = {"/compra"})
//public class Controlador extends HttpServlet {
//
//    Pedido pedido = new Pedido();
//    PedidoDAO pedidoDAO = new PedidoDAO();
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String menu = request.getParameter("menu");
//
//        if (menu.equalsIgnoreCase("formulario")) {
//            request.getRequestDispatcher("formulario.html").forward(request, response);
//
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
////        String accion = request.getParameter("accion");
////
////        if (accion.equalsIgnoreCase("realizarCompra")) {
////
////            String usuario = request.getParameter("torta");
////            String clave = request.getParameter("textclave");
////            String direccion = request.getParameter("textdireccion");
////            String piso = request.getParameter("textpisoDepto");
////            int telefono = Integer.parseInt(request.getParameter("texttelefono"));
////
////            usuarios.setUsuario(usuario);
////            usuarios.setClave(clave);
////            usuarios.setDireccion(direccion);
////            usuarios.setPisoDepto(piso);
////            usuarios.setTelefono(telefono);
////
////            //   usuarios = new Usuario(usuario, clave, direccion, piso, telefono);
////            usuarioDAO.guardarUsuarios(usuarios);
////
////            // COLOCAR ALGO QUE VERIFIQUE CADA CAMPO SI ES CORRECTO O ESTA COMPLETO
////            // IMPRIMIR UN CARTEL UNA VEZ QUE SE HA INSERTADO
////            request.getRequestDispatcher("index.html").forward(request, response);
//
//        }
//
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
