package com.example.gardenproyect.ui.service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.gardenproyect.R;
import com.example.gardenproyect.ui.home.HomeViewModel_Cliente;

public class ServiceFragment_Cliente extends Fragment implements View.OnClickListener {

    private ServiceViewModel_Cliente ServiceViewModelCliente;
    Button btnDate, btnHour;
    EditText TxtVDate, TxtVHour;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ServiceViewModelCliente =
                ViewModelProviders.of(this).get(ServiceViewModel_Cliente.class);
        View root = inflater.inflate(R.layout.fragment_service_cliente, container, false);
        return root;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnDate = (Button) btnDate.findViewById(R.id.btnDate);
        btnHour = (Button) btnHour.findViewById(R.id.btnHour);
        TxtVDate = (EditText) TxtVDate.findViewById(R.id.EdTDate);
        TxtVHour = (EditText) TxtVHour.findViewById(R.id.EdTHour);

        btnDate.setOnClickListener(this);
        btnHour.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnTypeService = view.findViewById(R.id.btnAgregarTipoServicio);

        btnTypeService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.typeServiceFragment_Cliente);
            }
        });

    }

}