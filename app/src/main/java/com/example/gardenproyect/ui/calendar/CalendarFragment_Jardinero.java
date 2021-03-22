package com.example.gardenproyect.ui.calendar;

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

public class CalendarFragment_Jardinero extends Fragment {

    private CalendarViewModel_Jardinero CalendarViewModelJardinero;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalendarViewModelJardinero =
                ViewModelProviders.of(this).get(CalendarViewModel_Jardinero.class);
        View root = inflater.inflate(R.layout.fragment_calendar_jardinero, container, false);
        return root;
    }
}