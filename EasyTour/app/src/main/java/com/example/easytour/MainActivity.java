package com.example.easytour;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.Service.Servicio.KeyManager;
import com.example.Service.Servicio.RetrofitInstance;
import com.example.Service.Servicio.ServiceRetrofit;

import java.util.ArrayList;
import java.util.List;



import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    EasySlider easyslider;
    Button b_inicio;
    TextInputEditText email, password;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ServiceRetrofit serviceRetrofit;


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

        Retrofit retrofitInstance = new RetrofitInstance().getInstance();
        serviceRetrofit = retrofitInstance.create(ServiceRetrofit.class);

        b_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(email.getText().toString(), password.getText().toString());
            }
        });

    }

    private void loginUser(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(MainActivity.this, "No puedes dejar vacío el email", Toast.LENGTH_LONG).show();

        }

       /* if (TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "No puedes dejar vacío el password", Toast.LENGTH_SHORT).show();
        }*/

        compositeDisposable.add(serviceRetrofit.loginUser(email)//, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>(){
            @Override
            public void accept (String response)throws Exception {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                /*switch (response) {
                    case "no-valid":
                        Toast.makeText(MainActivity.this, "Campos no validos", Toast.LENGTH_LONG).show();
                        break;

                    case "email":
                        Toast.makeText(MainActivity.this, "No estas registrado", Toast.LENGTH_LONG).show();
                        break;

                    case "password":
                        Toast.makeText(MainActivity.this, "Tu password es invalida", Toast.LENGTH_LONG).show();
                        break;

                }*/

                KeyManager keyManager = new KeyManager(MainActivity.this);
                keyManager.setKey(response);

                //new Cliente();
                Intent intent = new Intent(MainActivity.this, Modificar.class);
                startActivity(intent);
                finish();
            }
        }));
    }
}

