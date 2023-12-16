/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import infrastructure.persistence.IPersistencia;
import infrastructure.persistence.mysql.MysqlRepository;
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
@WebServlet(name = "Servlet", urlPatterns = {"/servletUsuario"})
public class Servlet extends HttpServlet {

    IPersistencia sistPersistencia = new MysqlRepository();
    Usuario usuarios = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    
    public Servlet() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
            processRequest(request, response);
            //response.getWriter().write("<h1>REQUEST CONTESTADA DESDE EL SERVELT</h1>");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String accion = request.getParameter("accion");
       
       if (accion.equalsIgnoreCase("ingresar")) {
           String usuario = request.getParameter("textUsuario");
           String clave = request.getParameter("textClave");
           
           usuarios = usuarioDAO.Validar(usuario, clave);
           
           if (usuarios.getUsuario() != null) {
               request.setAttribute("usuario", usuarios);
               // agregar una condicion de que quiero que pase una vez que me value el usuario
               request.getRequestDispatcher("Controlador?menu=formulario").forward(request, response);
           } else {
               request.getRequestDispatcher("index.html").forward(request, response);
           }
       } else {
           request.getRequestDispatcher("index.html").forward(request, response);
       }
       
            // evaluar que pasa si no son correctos los datos
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
