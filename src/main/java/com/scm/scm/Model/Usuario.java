package com.scm.scm.Model;

//Modelo de Usuario, donde las variables hacen referencia a las columnas de su respectiva tabla en la base de datos
public class Usuario {
    private int idUsuario;

    private String nomUsuario;

    private String contrasena;

    private String numEmpleado;

    private int idTipoU;

    private String nomTipoU;

    //En esta seccion se generan los metodos get() y set()
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public int getIdTipoU() {
        return idTipoU;
    }

    public void setIdTipoU(int idTipoU) {
        this.idTipoU = idTipoU;
    }

    public String getNomTipoU() {
        return nomTipoU;
    }

    public void setNomTipoU(String nomTipoU) {
        this.nomTipoU = nomTipoU;
    }
}
