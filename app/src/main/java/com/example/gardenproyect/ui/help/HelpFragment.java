package com.example.gardenproyect.ui.help;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.gardenproyect.R;

import java.net.URI;
import java.net.URL;

public class HelpFragment extends Fragment {

    String url_ = "https://g.page/wework-midtown-jalisco?share";
    Button place;

    private HelpViewModel helpViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        helpViewModel =
                ViewModelProviders.of(this).get(HelpViewModel.class);
        View root = inflater.inflate(R.layout.fragment_help, container, false);

        place = root.findViewById(R.id.place);

        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(url_);
                Intent itn = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(itn);
            }
        });

        return root;
    }
}