package com.example.appmarisqueria.Utils.ServiceManager;


import com.example.appmarisqueria.Utils.Entity.InicioSesionDTO;
import com.example.appmarisqueria.Utils.Entity.UsuarioLogeado;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    //Produccion
    static final String BASE = "/";

    static final String API_LOGIN = "api/Login";

    @POST(BASE + API_LOGIN)
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<UsuarioLogeado> iniciarSesion(@Body InicioSesionDTO user);


}