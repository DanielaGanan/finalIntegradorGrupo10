/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Usuario;
import models.UsuarioDAO;

/**
 *
 * @author danig
 */
@WebServlet(name = "registroServlet", urlPatterns = {"/registroServlet"})
public class registroServlet extends HttpServlet {

    Usuario usuarios = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
//    IPersistencia sistPersistencia = new MysqlRepository();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registroServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         String accion = request.getParameter("accion");
       
       if (accion.equalsIgnoreCase("registrarse")) {
           
           String usuario = request.getParameter("textusuario");
           String clave = request.getParameter("textclave");
           String direccion = request.getParameter("textdireccion");
           String piso = request.getParameter("textpisoDepto");
           int telefono = Integer.parseInt(request.getParameter("texttelefono"));
           
           usuarios.setUsuario(usuario);
           usuarios.setClave(clave);
           usuarios.setDireccion(direccion);
           usuarios.setPisoDepto(piso);
           usuarios.setTelefono(telefono);

          
            usuarioDAO.guardarUsuarios(usuarios);
           
           // COLOCAR ALGO QUE VERIFIQUE CADA CAMPO SI ES CORRECTO O ESTA COMPLETO
           
           // IMPRIMIR UN CARTEL UNA VEZ QUE SE HA INSERTADO
           
           request.getRequestDispatcher("index.html").forward(request, response);
//           
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
