package com.example.gardenproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gardenproyect.ui.service.ServiceFragment_Cliente;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Inicio extends AppCompatActivity {

    private View btnJardinero;
    private View btnCliente;

    public void BtnJardinero(View v){
        FirebaseUser userTwo = FirebaseAuth.getInstance().getCurrentUser();

        if (userTwo != null) {
            Intent intent = new Intent(Inicio.this, Jardinero.class);
            startActivity(intent);
            finish();
        } else {
            Intent itn = new Intent(this, LoginScreenTwo.class);
            startActivity(itn);
            finish();
        }
    }

    public void BtnCliente(View v){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(Inicio.this);

        if (user != null && account != null) {
            Intent intent = new Intent(Inicio.this, Cliente.class);
            startActivity(intent);
            finish();
        } else {
            Intent itn = new Intent(this, LoginScreen.class);
            startActivity(itn);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
}