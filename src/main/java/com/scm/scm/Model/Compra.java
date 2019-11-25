package com.scm.scm.Model;

//Modelo de Compras, donde las variables hacen referencia a las columnas de su respectiva tabla en la base de datos
public class Compra {
    private int idCompras;

    private String NombreProd;

    private double Precio;

    private int Cantidad;

    private String Unidad;

    private float Total;

    private String Fecha;

    private String Estado;

    public int getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
    }

    public String getNombreProd() {
        return NombreProd;
    }

    public void setNombreProd(String nombreProd) {
        NombreProd = nombreProd;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setUnidad(String unidad) {
        Unidad = unidad;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
