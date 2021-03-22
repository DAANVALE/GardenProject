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

public class TimeFragment_Jardinero extends Fragment {

    private TimeViewModel_Jardinero TimeViewModelJardinero;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TimeViewModelJardinero =
                ViewModelProviders.of(this).get(TimeViewModel_Jardinero.class);
        View root = inflater.inflate(R.layout.fragment_time_jardinero, container, false);
        return root;
    }
}