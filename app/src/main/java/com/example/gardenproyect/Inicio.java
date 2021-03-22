package com.example.gardenproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    private View btnJardinero;
    private View btnCliente;

    public void BtnJardinero(View v){
        Intent itn = new Intent(this,Jardinero.class);
        startActivity(itn);
    }

    public void BtnCliente(View v){
        Intent itn = new Intent(this, Cliente.class);
        startActivity(itn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
}