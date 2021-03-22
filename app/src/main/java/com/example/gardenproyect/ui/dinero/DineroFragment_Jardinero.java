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

public class DineroFragment_Jardinero extends Fragment {

    private DineroViewModel_Jardinero dineroViewModelJardinero;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dineroViewModelJardinero =
                ViewModelProviders.of(this).get(DineroViewModel_Jardinero.class);
        View root = inflater.inflate(R.layout.fragment_dinero_jardinero, container, false);
        return root;
    }
}