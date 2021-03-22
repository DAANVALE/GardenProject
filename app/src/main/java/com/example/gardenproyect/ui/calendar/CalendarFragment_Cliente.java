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

import java.util.Calendar;

public class CalendarFragment_Cliente extends Fragment {

    private CalendarViewModel_Cliente CalendarViewModelCliente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalendarViewModelCliente =
                ViewModelProviders.of(this).get(CalendarViewModel_Cliente.class);
        View root = inflater.inflate(R.layout.fragment_calendar_cliente, container, false);
        return root;
    }
}