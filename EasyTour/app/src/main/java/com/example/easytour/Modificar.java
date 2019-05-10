package com.example.easytour;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;
import com.example.Service.Servicio.RetrofitInstance;
import com.example.Service.Servicio.ServiceRetrofit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Modificar extends AppCompatActivity{


    private EditText email, confEmail, password, confPassword;
    private TextView tv_nombre, tv_apt, tv_apm, tv_editar, tv_notificaciones;
    private Button b_edit;
    ServiceRetrofit serviceRetrofit;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        email = (EditText) findViewById(R.id.et_email);
        confEmail = (EditText) findViewById(R.id.et_confemail);
        password = (EditText) findViewById(R.id.et_password);
        confPassword = (EditText) findViewById(R.id.et_confpass);

        Retrofit retrofitInstance = new RetrofitInstance().getInstance();
        serviceRetrofit = retrofitInstance.create(ServiceRetrofit.class);

        b_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUser(email.getText().toString(), confEmail.getText().toString(), password.getText().toString(),
                        confPassword.getText().toString());
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

    private void editUser(String email, String confEmail, String password, String confPassword){
        compositeDisposable.add(serviceRetrofit.editUser(email, confEmail, password, confPassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>(){

                    @Override
                    public void accept(String responseEdit) throws Exception {

                    }
                }));

}
}
