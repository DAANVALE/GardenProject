package com.example.gardenproyect.ui.home;

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

public class HomeFragment_Jardinero extends Fragment{

    private HomeViewModel_Jardinero homeViewModelJardinero;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModelJardinero =
                ViewModelProviders.of((Fragment) this).get(HomeViewModel_Jardinero.class);
        View root = inflater.inflate(R.layout.fragment_home_jardinero, container, false);
        return root;
    }
}

