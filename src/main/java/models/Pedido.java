/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author danig
 */
public class Pedido {
    
    private int idPedido;
    private int idUsuario; //En observación
    private int idProducto; //En observación
    private Producto producto;
    private Usuario usuario;
    private int cantidad;
    private double pagoTotal;

    public Pedido() {
    }

    // Analizar con cual contructor quedarse 
    
    public Pedido(int idPedido, Producto producto, Usuario usuario, int cantidad, double pagoTotal) {
        this.idPedido = idPedido;
        this.producto = producto;
        this.usuario = usuario;
        this.cantidad = cantidad;
        this.pagoTotal = pagoTotal;
    }

    public Pedido(int idPedido, int idUsuario, int idProducto, Producto producto, Usuario usuario, int cantidad, double pagoTotal) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.producto = producto;
        this.usuario = usuario;
        this.cantidad = cantidad;
        this.pagoTotal = pagoTotal;
    }

    public Pedido(Producto producto, Usuario usuario, int cantidad, double pagoTotal) {
        this.producto = producto;
        this.usuario = usuario;
        this.cantidad = cantidad;
        this.pagoTotal = pagoTotal;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }
    
    
    
}
