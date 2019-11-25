package com.scm.scm.Model;


import lombok.Data;

//Se usa @Data para autogenerar los getter y setters sin que esten presentes en el codigo
@Data
public class TipoMaterial {
    private int idMaterialCat;
    private String nomCategoria;
    private String unidadMedida;
    private double cantidad;
    private double entradas;
    private double salidas;


}
