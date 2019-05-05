package com.example.Service.Servicio;



import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceRetrofit {

    @POST("buscarguia.jsp")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("email") String email);//, @Field("password") String password);

    @GET("buscarguia.jsp")
    Observable<String> getUserInformation(@Query("token") String token);
}
