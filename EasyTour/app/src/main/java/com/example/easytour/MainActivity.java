package com.example.easytour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    EasySlider easyslider;
    Button b_inicio;
    TextInputEditText tie_correo, tie_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tie_correo = (TextInputEditText) findViewById(R.id.tie_correo) ;
        tie_password = (TextInputEditText) findViewById(R.id.tie_password);

        b_inicio = (Button) findViewById(R.id.b_inicio);
        b_inicio.setOnClickListener(this);



        /*EASY SLIDER*/
        //------------------------------------------------------------------------------------------
        easyslider = findViewById(R.id.id_slider);

        List<SliderItem> easysliders = new ArrayList<>();

        easysliders.add(new SliderItem("Torre latinoamericana", R.drawable.toote));
        easysliders.add(new SliderItem("Palacio de Bellas Artes", R.drawable.easytouruno));
        easysliders.add(new SliderItem("Ángel de la independia", R.drawable.easytourdos));
        easyslider.setPages(easysliders);
        //------------------------------------------------------------------------------------------
    }

    @Override
    public void onClick(View v) {
        //new Cliente();
        Intent intent = new Intent(this, Modificar.class);
        startActivity(intent);
    }



}


