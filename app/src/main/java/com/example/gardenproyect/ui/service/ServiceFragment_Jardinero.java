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

public class ServiceFragment_Jardinero extends Fragment {

    private ServiceViewModel_Jardinero ServiceViewModelJardinero;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ServiceViewModelJardinero =
                ViewModelProviders.of(this).get(ServiceViewModel_Jardinero.class);
        View root = inflater.inflate(R.layout.fragment_service_jardinero, container, false);
        return root;
    }
}