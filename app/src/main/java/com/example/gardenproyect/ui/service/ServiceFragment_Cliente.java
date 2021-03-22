package com.example.gardenproyect.ui.service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.gardenproyect.R;
import com.example.gardenproyect.ui.home.HomeViewModel_Cliente;

public class ServiceFragment_Cliente extends Fragment {

    private ServiceViewModel_Cliente ServiceViewModelCliente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ServiceViewModelCliente =
                ViewModelProviders.of(this).get(ServiceViewModel_Cliente.class);
        View root = inflater.inflate(R.layout.fragment_service_cliente, container, false);
        return root;
    }
}