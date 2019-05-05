package com.example.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Modificar extends AppCompatActivity{

    private EditText et_email, et_confemail, et_pass, et_confpass;
    private TextView tv_nombre, tv_apt, tv_apm, mTextMessage;
    private Button b_edit;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        //Clase para poder hacer el movimiento entre pestañas
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_editarperfil);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        et_email = (EditText) findViewById(R.id.et_email);
        et_confemail = (EditText) findViewById(R.id.et_confemail);
        et_pass = (EditText) findViewById(R.id.et_password);
        et_confemail = (EditText) findViewById(R.id.et_confpass);
        tv_nombre = (TextView) findViewById(R.id.et_nombres);
        tv_apt = (TextView) findViewById(R.id.et_apt);
        tv_apm = (TextView) findViewById(R.id.et_apm);

        mTextMessage = (TextView) findViewById(R.id.tv_editarperfil);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
