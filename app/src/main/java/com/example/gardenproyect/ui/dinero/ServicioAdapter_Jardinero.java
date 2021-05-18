package com.example.gardenproyect.ui.dinero;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gardenproyect.R;

import java.util.ArrayList;

public class ServicioAdapter_Jardinero extends RecyclerView.Adapter<ServicioAdapter_Jardinero.ViewHolder> {

    private int resourse;
    private ArrayList<ServicioRecicler_Jardinero> recicler_jardineros;
    /*private ArrayList<ServicioRecicler_Jardinero> recicler_jardinerosDay;
    private ArrayList<ServicioRecicler_Jardinero> recicler_jardinerosPlace;*/

    public ServicioAdapter_Jardinero(ArrayList<ServicioRecicler_Jardinero> recicler_jardineros,
                                     int resourse){
        this.resourse = resourse;
        this.recicler_jardineros = recicler_jardineros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resourse,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ServicioRecicler_Jardinero servicioRecicler_jardinero = recicler_jardineros.get(position);
        holder.textViewAdapterTime.setText(servicioRecicler_jardinero.getTextTime());
        holder.textViewAdapterDay.setText(servicioRecicler_jardinero.getTextDay());
        holder.textViewAdapterPlace.setText(servicioRecicler_jardinero.getTextPlace());
    }

    @Override
    public int getItemCount() {
        return recicler_jardineros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewAdapterTime;
        private TextView textViewAdapterDay;
        private TextView textViewAdapterPlace;
        public View view;

        public ViewHolder(View view){
            super(view);

            this.view = view;
            this.textViewAdapterTime = (TextView) view.findViewById(R.id.textViewServiceTime);
            this.textViewAdapterDay = (TextView) view.findViewById(R.id.textViewServiceDay);
            this.textViewAdapterPlace = (TextView) view.findViewById(R.id.textViewServicePlace);
        }
    }
}
