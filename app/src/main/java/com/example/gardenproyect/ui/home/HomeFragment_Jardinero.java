package com.example.gardenproyect.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.gardenproyect.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment_Jardinero extends Fragment{

    private HomeViewModel_Jardinero homeViewModelJardinero;

    MaterialButton logoutButton;
    Button PendienteButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModelJardinero =
                ViewModelProviders.of((Fragment) this).get(HomeViewModel_Jardinero.class);
        View root = inflater.inflate(R.layout.fragment_home_jardinero, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnAgendar = view.findViewById(R.id.btnAgendar);
        PendienteButton = view.findViewById(R.id.btnPendientes);
        logoutButton = view.findViewById(R.id.logoutButton);

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_service_Jardinero);
            }
        });

        PendienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_dinero_jardinero);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Navigation.findNavController(v).navigate(R.id.loginScreenTwo);
            }
        });
    }
}