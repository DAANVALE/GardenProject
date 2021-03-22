package com.example.gardenproyect.ui.time;

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
import com.example.gardenproyect.ui.service.ServiceViewModel_Cliente;

public class TimeFragment_Cliente extends Fragment {

    private TimeViewModel_Cliente TimeViewModelCliente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TimeViewModelCliente =
                ViewModelProviders.of(this).get(TimeViewModel_Cliente.class);
        View root = inflater.inflate(R.layout.fragment_time_cliente, container, false);
        return root;
    }
}