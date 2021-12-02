package com.example.appmarisqueria.Utils.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class InicioSesionDTO {

    @SerializedName("usuarioNombre")
    @Expose
    private String nombreUsuario ;

    @SerializedName("usuarioContrasena")
    @Expose
    private String contra ;

    public void setNombreUsuario(String nombre){
        this.nombreUsuario = nombre ;
    }

    public void setContra(String contra){
        this.contra = contra ;
    }



}
