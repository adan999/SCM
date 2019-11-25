package com.scm.scm.Model;

//Modelo de Proveedor, donde las variables hacen referencia a las columnas de su respectiva tabla en la base de datos
public class Proveedor {
    private int idProveedor;

    private String rfc;

    private String nomEmpresa;

    private String dir;

    private String numTel;

    //En esta seccion se generan los metodos get() y set()
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
}
