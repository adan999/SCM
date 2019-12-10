package com.scm.scm.Model;

import lombok.Data;

@Data
public class CompraMinorista {

    private String fechaComp;
    private String folioSegura;
    private String nomCliente;
    private String dirCliente;
    private double cantidad;
    private double precio;
    private String nomMaterial;
    private double subTotalComp;
    private int iva;
    private double totalComp;
    private String estadoComp;
    private int idMaterial;
    private String nomUsuario;
}
