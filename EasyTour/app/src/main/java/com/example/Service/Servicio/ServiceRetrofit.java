package com.example.Service.Servicio;



import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceRetrofit {

    @POST("apiLogin")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("email") String email, @Field("password") String password);

    @GET("buscarguia")
    Observable<String> getUserInformation(@Query("token") String token);

    @POST("buscarguia")
    Observable<String> editUser(@Field("email") String email, @Field("confEmail") String confEmail, @Field("password") String password,
                                @Field("confPassword") String confPassword);
}
