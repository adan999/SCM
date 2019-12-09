package com.scm.scm.Model;

import lombok.Data;

@Data
public class Venta {

    private int idVenta;
    private String folioVenta;
    private String fechaVenta;
    private double subTotalVenta;
    private int iva;
    private double totalVenta;
    private String estadoVenta;
    private double cantidad;
    private double precio;
    private int idMaterialCat;
    private int idUsuario;
    private int idMayorista;
    private String nomEmpresa;
    private String nomCategoria;
    private String unidad;


}
