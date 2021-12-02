package com.example.appmarisqueria.Utils.ServiceManager;

public class ApiUtils {

    private ApiUtils() {}

    // Desarrollo
    public static final String BASE_URL_LOCAL = "http://192.168.1.71:5000/";
    public static final String BASE_URL = "https://marisqueriabackend20211130210218.azurewebsites.net/";
    // Produccion
    //  public static final String BASE_URL = "https://imsswebapplication.000webhostapp.com//";
    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}