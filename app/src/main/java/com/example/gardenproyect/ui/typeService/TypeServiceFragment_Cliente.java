package com.example.gardenproyect.ui.typeService;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.gardenproyect.R;
import com.example.gardenproyect.ui.home.HomeViewModel_Cliente;

public class TypeServiceFragment_Cliente extends Fragment {

    private TypeServiceViewModel_Cliente typeServiceViewModelCliente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        typeServiceViewModelCliente =
                ViewModelProviders.of(this).get(TypeServiceViewModel_Cliente.class);
        View root = inflater.inflate(R.layout.fragment_type_service_cliente, container, false);
        return root;
    }
}