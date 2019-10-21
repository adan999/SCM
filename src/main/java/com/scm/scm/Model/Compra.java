package com.scm.scm.Model;

import lombok.Data;

import java.util.Date;

//Se usa @Data para autogenerar los getter y setters sin que esten presentes en el codigo
@Data
//Modelo de Compras, donde las variables hacen referencia a las columnas de su respectiva tabla en la base de datos
public class Compra {
    private int idCompras;

    private String NombreProd;

    private double Precio;

    private int Cantidad;

    private String Unidad;

    private double Total;

    private String Fecha;

    private String Estado;
}
