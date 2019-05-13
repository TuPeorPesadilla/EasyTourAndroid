package com.example.easytour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class Modificar extends AppCompatActivity{


    private EditText email, confEmail, password, confPassword;
    private TextView tv_nombre, tv_apt, tv_apm, tv_editar, tv_notificaciones;
    private Button b_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        tv_nombre = (TextView) findViewById(R.id.et_nombres);
        tv_apt = (TextView) findViewById(R.id.et_apt);
        tv_apm = (TextView) findViewById(R.id.et_apm);

        email = (EditText) findViewById(R.id.et_email);
        confEmail = (EditText) findViewById(R.id.et_confemail);
        password = (EditText) findViewById(R.id.et_password);
        confPassword = (EditText) findViewById(R.id.et_confpass);

        Bundle data = getIntent().getExtras();
        int id_usuario = data.getInt("id_usuario");
        String nombre = data.getString("nombre");
        String correo = data.getString("correo");
        String contrasena = data.getString("contrasena");

        tv_nombre.setText(nombre);
        email.setText(correo);
        confEmail.setText(correo);
        password.setText(contrasena);
        confPassword.setText(contrasena);

        b_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String newEmail = email.getText().toString();
                final String newPassword = password.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean hecho = jsonObject.getBoolean("hecho");
                            if (hecho){
                                Toast.makeText(Modificar.this, "Cuenta modificada", Toast.LENGTH_SHORT).show();

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Modificar.this);
                                builder.setMessage("contraseña o correo incorrectos").setNegativeButton("reintentar", null)
                                        .create().show();
                            }

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
           }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.it_editarperfil:
                        break;
                    case R.id.it_notificaciones:
                        Intent intent1 =  new Intent(Modificar.this, Notificaciones.class);
                        startActivity(intent1);
                        break;
                }

                return false;
            }
        });

    }

}
