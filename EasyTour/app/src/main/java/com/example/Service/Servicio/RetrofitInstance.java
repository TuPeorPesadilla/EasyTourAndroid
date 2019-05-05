package com.example.Service.Servicio;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitInstance {
    private static Retrofit instance;

    public static Retrofit getInstance(){
        final String url = "http://192.168.1.199:8080/WEB-INF/";
        if(instance == null){
            instance = new Retrofit
                    .Builder()
                    .baseUrl(url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return instance;
    }
}