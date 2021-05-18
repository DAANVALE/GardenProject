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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gardenproyect.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DineroFragment_Jardinero extends Fragment {

    private DineroViewModel_Jardinero dineroViewModelJardinero;

    private DatabaseReference mDataBase;

    private ServicioAdapter_Jardinero mAdapter;
    private RecyclerView mRecicler;
    private ArrayList<ServicioRecicler_Jardinero> mList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dineroViewModelJardinero =
                ViewModelProviders.of(this).get(DineroViewModel_Jardinero.class);
        View root = inflater.inflate(R.layout.fragment_dinero_jardinero, container, false);

        mRecicler = (RecyclerView) root.findViewById(R.id.reciclerservicios_jardinero);
        mRecicler.setLayoutManager(new LinearLayoutManager(getActivity()));

        mDataBase = FirebaseDatabase.getInstance().getReference();

        getValores();

        return root;
    }

    private void getValores(){
        mDataBase.child("Usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                    mList.clear();

                    for (DataSnapshot ds: snapshot.getChildren()){
                        String fecha = ds.child("hora").getValue().toString();
                        mList.add(new ServicioRecicler_Jardinero(fecha));
                    }
                    mAdapter = new ServicioAdapter_Jardinero(mList,R.layout.reciclerservicio_jardinero);
                        mRecicler.setAdapter(mAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}