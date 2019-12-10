package com.scm.scm.Model;

import lombok.Data;

//Se usa @Data para autogenerar los getter y setters sin que esten presentes en el codigo
@Data
public class Material {

    private int idMaterial;
    private String codigoMaterial;
    private String nomMaterial;
    private String unidadMedida;
    private double cantidadActual;
    private int idMaterialCat;
    private String nomCategoria;
    private String nomUsuario;

}
