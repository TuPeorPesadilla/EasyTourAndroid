package com.example.Service.Servicio;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyManager {
    Context context;
    SharedPreferences sharedPref;

    public KeyManager(Context context){
        this.context = context;
    }

    public void setKeys(String name, String appat, String apmat, String email, String password){
        sharedPref = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name", name);
        editor.putString("appat", appat);
        editor.putString("apmat", apmat);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.commit();
    }

    public String[] getKeys(){
        sharedPref = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        String[] keys = new String[5];
        keys[0] = sharedPref.getString("name", "");
        keys[1] = sharedPref.getString("appat", "");
        keys[2] = sharedPref.getString("apmat", "");
        keys[3] = sharedPref.getString("email", "");
        keys[4] = sharedPref.getString("password", "");
        return keys;
    }
}

