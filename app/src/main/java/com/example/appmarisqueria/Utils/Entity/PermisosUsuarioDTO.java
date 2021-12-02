package com.example.appmarisqueria.Utils.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PermisosUsuarioDTO {

    @SerializedName("id_permiso")
    @Expose
    private int idPermiso;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("ruta")
    @Expose
    private String ruta;

    public PermisosUsuarioDTO(int idPermiso, String descripcion, int status) {
        this.idPermiso = idPermiso;
        this.descripcion = descripcion;
        this.status = status;
        this.ruta = "" ;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
