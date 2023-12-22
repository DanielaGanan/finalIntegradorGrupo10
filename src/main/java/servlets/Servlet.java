/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Pedido;
import models.PedidoDAO;
import models.Producto;
import models.ProductoDAO;
import static models.ProductoDAO.reemplazarEspacio;
import models.Usuario;
import models.UsuarioDAO;

/**
 *
 * @author danig
 */
@WebServlet(name = "Servlet", urlPatterns = {"/servletUsuario"})
public class Servlet extends HttpServlet {

    Usuario usuarios = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Pedido pedido = new Pedido();
    PedidoDAO pedidoDAO = new PedidoDAO();
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();

    public Servlet() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "ingresar":
                String usuario = request.getParameter("textUsuario");
                String clave = request.getParameter("textClave");

                usuarios = usuarioDAO.Validar(usuario, clave);

                if (usuarios.getUsuario() != null) {
                    request.setAttribute("usuario", usuarios);
                    // agregar una condicion de que quiero que pase una vez que me value el usuario
                    request.getRequestDispatcher("index.html").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.html").forward(request, response);
                }
                break;

            case "realizarCompra":

                String torta = request.getParameter("torta");
                int kilos = Integer.parseInt(request.getParameter("kilos"));
                double precio = Double.parseDouble(request.getParameter("monto_total"));
                String fechaString = request.getParameter("fecha");
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate fecha = LocalDate.parse(fechaString, formatter);

                String tortaModificada = reemplazarEspacio(torta);
                
                producto = productoDAO.buscarProducto(tortaModificada);

                pedido.setUsuario(usuarios);
                pedido.setProducto(producto);
                pedido.setKilos(kilos);
                pedido.setPrecioTotal(precio);
                pedido.setFecha(fecha);

                pedidoDAO.guardarPedido(pedido);

                // COLOCAR ALGO QUE VERIFIQUE CADA CAMPO SI ES CORRECTO O ESTA COMPLETO
                // IMPRIMIR UN CARTEL UNA VEZ QUE SE HA INSERTADO
                request.getRequestDispatcher("index.html").forward(request, response);
                break;
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

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
