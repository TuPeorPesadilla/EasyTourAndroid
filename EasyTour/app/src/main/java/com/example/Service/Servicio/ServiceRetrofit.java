package com.example.Service.Servicio;



import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceRetrofit {

    @POST
    @FormUrlEncoded
    Observable<String> loginUser(@Field("email") String email, @Field("password") String password);
}
