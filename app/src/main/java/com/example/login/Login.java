package com.example.login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class Login extends AppCompatActivity {

    EasySlider easyslider;
    Button BotonInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        easyslider = findViewById(R.id.id_slider);

        List<SliderItem> easysliders = new ArrayList<>();

        easysliders.add(new SliderItem("Palacio de bellas artes",R.drawable.toote));
        easysliders.add(new SliderItem("Ángel de la independencia",R.drawable.easytouruno));
        easysliders.add(new SliderItem("Torre Latinoamericana",R.drawable.easytourdos));
        easyslider.setPages(easysliders);


        //accion de cambio de layout

        BotonInicio = (Button) findViewById(R.id.id_botoninicio);
        BotonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(Login.this, Modificar.class));
            }
        });


    }
}
