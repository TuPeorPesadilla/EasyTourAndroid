package com.example.easytour;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Edit_Method extends StringRequest {
    private static final String EDIT_REQUEST_URL = "http://189.131.115.27:80/BDEasyTour/inisesBD.php";
    private Map<String, String> params;

    public Edit_Method(String app, String apm, Response.Listener<String> listener) {
        super(Method.POST, EDIT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("app", app);
        params.put("apm", apm);

    }

    public Map<String, String> getParams() {
        return params;
    }
}
