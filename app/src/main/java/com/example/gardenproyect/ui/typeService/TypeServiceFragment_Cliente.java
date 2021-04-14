package com.example.gardenproyect.ui.typeService;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.gardenproyect.R;
import com.example.gardenproyect.ui.home.HomeViewModel_Cliente;
import com.google.android.material.datepicker.MaterialTextInputPicker;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

import java.text.NumberFormat;

public class TypeServiceFragment_Cliente extends Fragment{

    TextInputLayout pod_cesped;
    TextView vt_pdcesped, v_pdcesped;
    Button serv_apt;

    private TypeServiceViewModel_Cliente typeServiceViewModelCliente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        typeServiceViewModelCliente =
                ViewModelProviders.of(this).get(TypeServiceViewModel_Cliente.class);
        View root = inflater.inflate(R.layout.fragment_type_service_cliente, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pod_cesped = view.findViewById(R.id.textin_cesped);
        vt_pdcesped = view.findViewById(R.id.VT_pod_cesped);
        v_pdcesped = view.findViewById(R.id.V_pod_cesped);
        serv_apt = view.findViewById(R.id.btnserv_apt);

        serv_apt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int p;
                try { p = Integer.parseInt(String.valueOf(pod_cesped.getEditText().getText())); } catch(Exception e) { p = 0; }

                v_pdcesped.setText("180");
                int vt = 180 * p;
                vt_pdcesped.setText("$"+vt);
            }
        });
    }
}