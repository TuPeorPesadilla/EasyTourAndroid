package com.example.easytour;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Metodos extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://localhost:8000/BDEasyTour/inisesBD.php";
    private Map<String, String> params;
    public Metodos (String usuar, String contra, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nomUsu", usuar);
        params.put("conUsu", contra);

    }

    public Map<String, String> getParams(){
        return params;
    }

}
