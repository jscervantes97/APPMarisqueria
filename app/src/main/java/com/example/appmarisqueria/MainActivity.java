package com.example.appmarisqueria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmarisqueria.Utils.Entity.InicioSesionDTO;
import com.example.appmarisqueria.Utils.Entity.Usuario;
import com.example.appmarisqueria.Utils.Entity.UsuarioLogeado;
import com.example.appmarisqueria.Utils.ServiceManager.APIService;
import com.example.appmarisqueria.Utils.ServiceManager.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnInicio ;

    private APIService mAPIService;

    private EditText txtCorreo, txtContra ;

    private TextView txtResultado ;

    public UsuarioLogeado usuarioLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInicio = (Button) findViewById(R.id.inicio) ;
        txtCorreo = (EditText)findViewById(R.id.editTextTextEmailAddress) ;
        txtContra = (EditText)findViewById(R.id.editTextTextPassword) ;
        txtResultado = (TextView) findViewById(R.id.txtResultado) ;
        btnInicio.setOnClickListener(this);
        mAPIService = ApiUtils.getAPIService();

    }

    @Override
    public void onClick(View v) {
        String contra = "", correo = "";
        contra = this.txtContra.getText().toString();
        correo = this.txtCorreo.getText().toString();

        if (contra.isEmpty() || correo.isEmpty()) {
            Toast.makeText(this,"No puede dejar ningun campo vacio...no sea gilipollas",Toast.LENGTH_LONG).show();
        }else{
            InicioSesionDTO usuarioLogear = new InicioSesionDTO();
            usuarioLogear.setNombreUsuario(correo);
            usuarioLogear.setContra(contra);
            iniciarSesion(usuarioLogear);
        }

    }

    public void iniciarSesion(InicioSesionDTO userLog) {
        mAPIService.iniciarSesion(userLog).enqueue(new Callback<UsuarioLogeado>() {
            @Override
            public void onResponse(Call<UsuarioLogeado> call, Response<UsuarioLogeado> response) {
                System.out.println(response.toString());
                System.out.println("on respones ??" + response.message());
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    System.out.println("post submitted to API." + response.body().toString());
                    //System.out.println("Usuario ??" + response.body().getUsuarioNombre());
                    setearUsuarioLogIn(response.body());

                }
                confirmarInicio();
            }

            @Override
            public void onFailure(Call<UsuarioLogeado> call, Throwable t) {
                System.out.println("Unable to submit post to API.");
                System.out.println(t.getMessage());
            }
        });
    }

    public void showResponse(String response) {
        System.out.println(response);
    }

    public void setearUsuarioLogIn(UsuarioLogeado usuarioLog){
        this.usuarioLog = usuarioLog ;
        System.out.println("usuario seteado ?" + this.usuarioLog);
    }

    public void confirmarInicio(){
        if(this.usuarioLog == null){
            Toast.makeText(this,"Usuario o contraseña no validos",Toast.LENGTH_LONG).show();
            txtResultado.setText("Usuario o contraseña no validos");
        }else {
            txtResultado.setText("");
            Toast.makeText(this,"Bienvenido " + this.usuarioLog.getUser().getUsuarioNombre(),Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(this,Inicio.class);
            //intent.putExtra("usuario",usuarioLog);
            //startActivity(intent);
        }
    }
}