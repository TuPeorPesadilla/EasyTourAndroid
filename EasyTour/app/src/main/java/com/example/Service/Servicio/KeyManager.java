package com.example.Service.Servicio;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyManager {
    Context context;
    SharedPreferences sharedPref;

    public KeyManager(Context context){
        this.context = context;
    }

    public void setKey(String key){
        sharedPref = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("key", key);
        editor.commit();
    }

    public String getKey(){
        sharedPref = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        String key = sharedPref.getString("key", "");
        return key;
    }
}

