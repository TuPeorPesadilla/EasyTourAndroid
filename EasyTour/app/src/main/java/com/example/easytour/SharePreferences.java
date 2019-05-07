package com.example.easytour;

public class SharePreferences {

    public void SharePreferences(String emailCuenta, String passwordCuenta){
        String correo, contra;
        correo = emailCuenta;
        contra = passwordCuenta;
        System.out.println("Email: " + correo + ", password: " + contra);
    }
}
