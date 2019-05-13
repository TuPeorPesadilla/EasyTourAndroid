package com.example.easytour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//Clases de Volley
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//Clases de easySlider
import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class MainActivity extends AppCompatActivity {

    EasySlider easyslider;
    Button b_inicio;
    TextInputEditText email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (TextInputEditText) findViewById(R.id.tie_correo);
        password = (TextInputEditText) findViewById(R.id.tie_password);

        b_inicio = (Button) findViewById(R.id.b_inicio);

        /*EASY SLIDER*/
        //------------------------------------------------------------------------------------------
        easyslider = findViewById(R.id.id_slider);

        List<SliderItem> easysliders = new ArrayList<>();

        easysliders.add(new SliderItem("Torre latinoamericana", R.drawable.toote));
        easysliders.add(new SliderItem("Palacio de Bellas Artes", R.drawable.easytouruno));
        easysliders.add(new SliderItem("Ángel de la independia", R.drawable.easytourdos));
        easyslider.setPages(easysliders);
        //------------------------------------------------------------------------------------------

        b_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String correo = email.getText().toString();
                final String contra = password.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean hecho = jsonObject.getBoolean("hecho");
                            if (hecho){
                                int id_usuario = jsonObject.getInt("id_usuario");
                                String nombre = jsonObject.getString("nombre");
                                String correo = jsonObject.getString("correo");
                                String contrasena = jsonObject.getString("contrasena");

                                Intent intent = new Intent(MainActivity.this, Modificar.class);
                                intent.putExtra("id_usuaio", id_usuario);
                                intent.putExtra("nombre", nombre);
                                intent.putExtra("correo", correo);
                                intent.putExtra("contrasena", contrasena);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("contraseña o correo incorrectos").setNegativeButton("reintentar", null)
                                        .create().show();
                            }

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                Metodos net = new Metodos(correo, contra, responseListener);

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(net);
            }
        });

    }


}


