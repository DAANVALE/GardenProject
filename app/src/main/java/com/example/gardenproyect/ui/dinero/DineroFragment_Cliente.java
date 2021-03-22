package com.example.gardenproyect.ui.dinero;

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

public class DineroFragment_Cliente extends Fragment {

    private DineroViewModel_Cliente dineroViewModelCliente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dineroViewModelCliente =
                ViewModelProviders.of(this).get(DineroViewModel_Cliente.class);
        View root = inflater.inflate(R.layout.fragment_dinero_cliente, container, false);
        return root;
    }
}