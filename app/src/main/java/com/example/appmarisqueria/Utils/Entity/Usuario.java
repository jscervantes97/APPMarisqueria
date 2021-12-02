package com.example.appmarisqueria.Utils.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class Usuario {

    @SerializedName("usuarioId")
    @Expose
    private int UsuarioId;

    @SerializedName("usuarioNombre")
    @Expose
    private String UsuarioNombre;

    @SerializedName("usuarioContraseña")
    @Expose
    private String UsuarioContraseña ;

    @SerializedName("iD_tipo_usuario")
    @Expose
    private String ID_tipo_usuario ;


    @SerializedName("status")
    @Expose
    private int status ;


    @SerializedName("listaPermisos")
    @Expose
    private List<PermisosUsuarioDTO> listaPermisos ;

    public Usuario() {
    }

    public int getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        UsuarioId = usuarioId;
    }

    public String getUsuarioNombre() {
        return UsuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        UsuarioNombre = usuarioNombre;
    }

    public String getUsuarioContraseña() {
        return UsuarioContraseña;
    }

    public void setUsuarioContraseña(String usuarioContraseña) {
        UsuarioContraseña = usuarioContraseña;
    }

    public String getID_tipo_usuario() {
        return ID_tipo_usuario;
    }

    public void setID_tipo_usuario(String ID_tipo_usuario) {
        this.ID_tipo_usuario = ID_tipo_usuario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
