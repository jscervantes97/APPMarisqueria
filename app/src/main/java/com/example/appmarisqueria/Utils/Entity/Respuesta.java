package com.example.appmarisqueria.Utils.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Respuesta {

    @SerializedName("respuesta")
    @Expose
    private String mensaje;

}
