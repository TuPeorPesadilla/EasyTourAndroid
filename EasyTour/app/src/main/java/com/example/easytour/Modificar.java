package com.example.easytour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Modificar extends AppCompatActivity{


    private EditText email, confEmail, password, confPassword;
    private TextView tv_nombre, tv_apt, tv_apm, tv_editar, tv_notificaciones;
    private Button b_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        email = (EditText) findViewById(R.id.et_email);
        confEmail = (EditText) findViewById(R.id.et_confemail);
        password = (EditText) findViewById(R.id.et_password);
        confPassword = (EditText) findViewById(R.id.et_confpass);


        /*b_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUser(email.getText().toString(), confEmail.getText().toString(), password.getText().toString(),
                        confPassword.getText().toString());
            }
        });*/

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
