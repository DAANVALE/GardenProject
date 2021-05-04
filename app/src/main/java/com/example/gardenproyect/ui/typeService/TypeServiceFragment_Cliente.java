package com.example.gardenproyect.ui.typeService;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import java.text.NumberFormat;

public class TypeServiceFragment_Cliente extends Fragment{

    private DatePickerDialog.OnDateSetListener dateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener;

    private DatabaseReference mDataBase;

    FirebaseDatabase database;
    DatabaseReference refubicacion;

    TextInputLayout pod_cesped,
            crt_palmera, crt_arbol, crt_arbusto,
            pln_cesped, pln_arbpal, pln_arbusto,
            rt_cesped, rt_arbpal, rt_arbusto;
    TextView vt_pdcesped, v_pdcesped,
            vt_crtpalmera, vt_crtarbol, vt_crtarbusto,
                v_crtpalmera, v_crtarbol, v_crtarbusto,
            vt_plncesped, vt_plnarbpal, vt_plnarbusto,
                v_plncesped, v_plnarbpal, v_plnarbusto,
            vt_rtcesped, vt_rtarbpal, vt_rtarbusto,
                v_rtcesped, v_rtarbpal, v_rtarbusto;

    /*1*/ int C_pod_csp = 0;
    /*2*/ int C_crt_palmera = 0, C_crt_arbol = 0, C_crt_arbusto = 0;
    /*3*/ int C_pln_cesped = 0, C_pln_arbpal = 0, C_pln_arbusto = 0;
    /*4*/ int C_rt_cesped = 0, C_rt_arbpal = 0, C_rt_arbusto = 0;

    /*1*/ int VTcrtcesped = 0;

    /*2*/ int VTcrtpalmera = 0;
    int VTcrtarbol = 0;
    int VTcrtarbusto = 0;

    /*3*/ int VTplncesped = 0;
    int VTplnarbpal = 0;
    int VTplnarbusto = 0;

    /*4*/ int VTrtcesped = 0;
    int VTrtarbpal = 0;
    int VTrtarbusto = 0;

    int servicios_totales_sum = 0;

    Button serv_apt;
    Button serv_enviar;

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

        serv_apt = view.findViewById(R.id.btnserv_apt);
        serv_enviar = view.findViewById(R.id.ButtonEnvSrv);
        serv_enviar.setVisibility(View.GONE);

        mDataBase = FirebaseDatabase.getInstance().getReference();

        database = FirebaseDatabase.getInstance();
        refubicacion = database.getReference("ubicacion");

        // 1
        pod_cesped = view.findViewById(R.id.textin_cesped);
        vt_pdcesped = view.findViewById(R.id.VT_pod_cesped);
        final int Vpdcesped = 10; v_pdcesped = view.findViewById(R.id.V_pod_cesped); v_pdcesped.setText("$"+Vpdcesped);

        //2
        crt_palmera = view.findViewById(R.id.textin_crt_palmera);
        crt_arbol = view.findViewById(R.id.textin_crt_arbol);
        crt_arbusto = view.findViewById(R.id.textin_crt_arbusto);
        vt_crtpalmera = view.findViewById(R.id.VT_crt_palmera);
        vt_crtarbol = view.findViewById(R.id.VT_crt_arbol);
        vt_crtarbusto = view.findViewById(R.id.VT_crt_arbusto);

        final int Vcrtpalmera = 500; v_crtpalmera = view.findViewById(R.id.V_crt_palmera); v_crtpalmera.setText("$"+Vcrtpalmera);
        final int Vcrtarbol = 300; v_crtarbol = view.findViewById(R.id.V_crt_arbol); v_crtarbol.setText("$"+Vcrtarbol);
        final int Vcrtarbusto = 50; v_crtarbusto = view.findViewById(R.id.V_crt_arbusto); v_crtarbusto.setText("$"+Vcrtarbusto);

        //3
        pln_cesped = view.findViewById(R.id.textin_rt_cesped);
        pln_arbpal = view.findViewById(R.id.textin_pln_ArbPal);
        pln_arbusto = view.findViewById(R.id.textin_pln_arbusto);
        vt_plncesped = view.findViewById(R.id.VT_pln_cesped);
        vt_plnarbpal = view.findViewById(R.id.VT_pln_arbpal);
        vt_plnarbusto = view.findViewById(R.id.VT_pln_arbusto);
        final int Vplncesped = 200; v_plncesped = view.findViewById(R.id.V_pln_cesped); v_plncesped.setText("$"+Vplncesped);
        final int Vplnarbpal = 500; v_plnarbpal = view.findViewById(R.id.V_pln_arbpal); v_plnarbpal.setText("$"+Vplnarbpal);
        final int Vplnarbusto = 150; v_plnarbusto = view.findViewById(R.id.V_pln_arbusto); v_plnarbusto.setText("$"+Vplnarbusto);

        //4
        rt_cesped = view.findViewById(R.id.textin_rt_cesped);
        rt_arbpal = view.findViewById(R.id.textin_rt_ArbPal);
        rt_arbusto = view.findViewById(R.id.textin_rt_arbusto);
        vt_rtcesped = view.findViewById(R.id.VT_rt_cesped);
        vt_rtarbpal = view.findViewById(R.id.VT_rt_arbpal);
        vt_rtarbusto = view.findViewById(R.id.VT_rt_arbusto);
        final int Vrtcesped = 140; v_rtcesped = view.findViewById(R.id.V_rt_cesped); v_rtcesped.setText("$"+Vrtcesped);
        final int Vrtarbpal = 800; v_rtarbpal = view.findViewById(R.id.V_rt_arbpal); v_rtarbpal.setText("$"+Vrtarbpal);
        final int Vrtarbusto = 100; v_rtarbusto = view.findViewById(R.id.V_rt_arbusto); v_rtarbusto.setText("$"+Vrtarbusto);

        serv_apt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                serv_enviar.setVisibility(View.VISIBLE);

                //1
                try { C_pod_csp = Integer.parseInt(String.valueOf(pod_cesped.getEditText().getText())); } catch(Exception e) { C_pod_csp = 0; }

                //2
                try { C_crt_palmera = Integer.parseInt(String.valueOf(crt_palmera.getEditText().getText())); } catch (Exception e) { C_crt_palmera = 0;}
                try { C_crt_arbol = Integer.parseInt(String.valueOf(crt_arbol.getEditText().getText()));} catch (Exception e) { C_crt_arbol = 0;}
                try { C_crt_arbusto = Integer.parseInt(String.valueOf(crt_arbusto.getEditText().getText())); } catch (Exception e) {C_crt_arbusto = 0;}

                //3
                try { C_pln_cesped = Integer.parseInt(String.valueOf(pln_cesped.getEditText().getText()));} catch (Exception e) {C_pln_cesped = 0;}
                try { C_pln_arbpal = Integer.parseInt(String.valueOf(pln_arbpal.getEditText().getText()));} catch (Exception e) {C_pln_arbpal = 0;}
                try { C_pln_arbusto = Integer.parseInt(String.valueOf(pln_arbusto.getEditText().getText()));} catch (Exception e) {C_pln_arbusto = 0;}

                //4
                try { C_rt_cesped = Integer.parseInt(String.valueOf(rt_cesped.getEditText().getText())); } catch (Exception e) {C_rt_cesped = 0;}
                try { C_rt_arbpal = Integer.parseInt(String.valueOf(rt_arbpal.getEditText().getText())); } catch (Exception e) {C_rt_arbpal = 0;}
                try { C_rt_arbusto = Integer.parseInt(String.valueOf(rt_arbusto.getEditText().getText())); } catch (Exception e) {C_rt_arbusto = 0;}

                VTcrtcesped = Vpdcesped * C_pod_csp;

                /*2*/ VTcrtpalmera = Vcrtpalmera * C_crt_palmera;
                VTcrtarbol = Vcrtarbol * C_crt_arbol;
                VTcrtarbusto = Vcrtarbusto * C_crt_arbusto;

                /*3*/ VTplncesped = Vplncesped * C_pln_cesped;
                VTplnarbpal = Vplnarbpal * C_pln_arbpal;
                VTplnarbusto = Vplnarbusto * C_pln_arbusto;

                /*4*/ VTrtcesped = Vrtcesped * C_rt_cesped;
                VTrtarbpal = Vrtarbpal * C_rt_arbpal;
                VTrtarbusto = Vrtarbusto * C_rt_arbusto;

                /*1*/ vt_pdcesped.setText("$"+VTcrtcesped);

                /*2*/ vt_crtpalmera.setText("$"+VTcrtpalmera);
                vt_crtarbol.setText("$"+VTcrtarbol);
                vt_crtarbusto.setText("$"+VTcrtarbusto);

                /*3*/ vt_plncesped.setText("$"+VTplncesped);
                vt_plnarbpal.setText("$"+VTplnarbpal);
                vt_plnarbusto.setText("$"+VTplnarbusto);

                /*4*/ vt_rtcesped.setText("$"+VTrtcesped);
                vt_rtarbpal.setText("$"+VTrtarbpal);
                vt_rtarbusto.setText("$"+VTrtarbusto);
            }
        });

        serv_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                servicios_totales_sum = C_pod_csp + C_crt_palmera + C_crt_arbol + C_crt_arbusto + C_pln_cesped + C_pln_arbpal + C_pln_arbusto + C_rt_cesped + C_rt_arbpal + C_rt_arbusto;

                if(servicios_totales_sum > 0){

                    Map<String, Object> Service = new HashMap<>();

                    Map<String, Object> S_pod_cesped = new HashMap<>();
                    Map<String, Object> S_crt_palmera = new HashMap<>();
                    Map<String, Object> S_crt_arbol = new HashMap<>();
                    Map<String, Object> S_crt_arbusto = new HashMap<>();
                    Map<String, Object> S_pln_cesped = new HashMap<>();
                    Map<String, Object> S_pln_arbpal = new HashMap<>();
                    Map<String, Object> S_pln_arbusto = new HashMap<>();
                    Map<String, Object> S_rt_cesped = new HashMap<>();
                    Map<String, Object> S_rt_arbpal = new HashMap<>();
                    Map<String, Object> S_rt_arbusto = new HashMap<>();

                    if(C_pod_csp > 0){
                        S_pod_cesped.put("Cantidad",C_pod_csp);
                        S_pod_cesped.put("Costo",VTcrtcesped);
                        S_pod_cesped.put("Costo unitario",Vpdcesped);
                        Service.put("Podado césped",S_pod_cesped);
                    } //1
                    if(C_crt_palmera > 0){
                        S_crt_palmera.put("Cantidad",C_crt_palmera);
                        S_crt_palmera.put("Costo",VTcrtpalmera);
                        S_crt_palmera.put("Costo unitario",Vcrtpalmera);
                        Service.put("Podado palmera",S_crt_palmera);
                    } //2
                    if(C_crt_arbol > 0){
                        S_crt_arbol.put("Cantidad",C_crt_arbol);
                        S_crt_arbol.put("Costo",VTcrtarbol);
                        S_crt_arbol.put("Costo unitario",Vcrtarbol);
                        Service.put("Podado árbol", S_crt_arbol);
                    } //3
                    if(C_crt_arbusto > 0){
                        S_crt_arbusto.put("Cantidad",C_crt_arbusto);
                        S_crt_arbusto.put("Costo",VTcrtarbusto);
                        S_crt_arbusto.put("Costo unitario",Vcrtarbusto);
                        Service.put("Podado arbusto", S_crt_arbusto);
                    } //4
                    if(C_pln_cesped > 0){
                        S_pln_cesped.put("Mt2", C_pln_cesped);
                        S_pln_cesped.put("Costo", VTplncesped);
                        S_pln_cesped.put("Costo unitario",Vplncesped);
                        Service.put("Plantar césped",S_pln_cesped);
                    } //5
                    if(C_pln_arbpal > 0){
                        S_pln_arbpal.put("Cantidad",C_pln_arbpal);
                        S_pln_arbpal.put("Costo",VTplnarbpal);
                        S_pln_arbpal.put("Costo unitario",Vplnarbpal);
                        Service.put("Plantar árbol u palmera",S_pln_arbpal);
                    } //6
                    if(C_pln_arbusto > 0){
                        S_pln_arbusto.put("Cantidad",C_pln_arbusto);
                        S_pln_arbusto.put("Costo",VTplnarbusto);
                        S_pln_arbusto.put("Costo unitario", Vplnarbusto);
                        Service.put("Plantar arbusto",S_pln_arbusto);
                    } //7
                    if(C_rt_cesped > 0){
                        S_rt_cesped.put("Cantidad",C_rt_cesped);
                        S_rt_arbpal.put("Costo",VTrtcesped);
                        S_rt_cesped.put("Costo unitario",Vrtcesped);
                        Service.put("Retirar césped",S_rt_cesped);
                    } //8
                    if(C_rt_arbpal > 0){
                        S_rt_arbpal.put("Cantidad",C_rt_arbpal);
                        S_rt_arbpal.put("Costo",VTrtarbpal);
                        S_rt_arbpal.put("Costo unitario",Vrtarbpal);
                        Service.put("Retirar árbol u palmera",S_rt_arbpal);
                    } //9
                    if(C_rt_arbusto > 0){
                        S_rt_arbusto.put("Cantidad",C_rt_arbusto);
                        S_rt_arbusto.put("Costo",VTrtarbusto);
                        S_rt_arbusto.put("Costo unitario",Vrtarbusto);
                        Service.put("Retirar arbusto", S_rt_arbusto);
                    } //10

                    mDataBase.child("Servicio").push().setValue(Service);
                }
                Navigation.findNavController(v).navigate(R.id.nav_service_cliente);
            }
        });
    }
}