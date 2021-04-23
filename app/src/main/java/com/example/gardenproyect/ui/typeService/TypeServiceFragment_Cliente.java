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

        serv_apt = view.findViewById(R.id.btnserv_apt);

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

                /*1*/ int C_pod_csp;
                /*2*/ int C_crt_palmera, C_crt_arbol, C_crt_arbusto;
                /*3*/ int C_pln_cesped, C_pln_arbpal, C_pln_arbusto;
                /*4*/ int C_rt_cesped, C_rt_arbpal, C_rt_arbusto;

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

                /*1*/ int VTcrtcesped = Vpdcesped * C_pod_csp;

                /*2*/ int VTcrtpalmera = Vcrtpalmera * C_crt_palmera;
                int VTcrtarbol = Vcrtarbol * C_crt_arbol;
                int VTcrtarbusto = Vcrtarbusto * C_crt_arbusto;

                /*3*/ int VTplncesped = Vplncesped * C_pln_cesped;
                int VTplnarbpal = Vplnarbpal * C_pln_arbpal;
                int VTplnarbusto = Vplnarbusto * C_pln_arbusto;

                /*4*/ int VTrtcesped = Vrtcesped * C_rt_cesped;
                int VTrtarbpal = Vrtarbpal * C_rt_arbpal;
                int VTrtarbusto = Vrtarbusto * C_rt_arbusto;

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
    }
}