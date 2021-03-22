package com.example.gardenproyect.ui.comment;

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
import com.example.gardenproyect.ui.dinero.DineroViewModel_Jardinero;

public class CommentFragment_Jardinero extends Fragment {

    private CommentViewModel_Jardinero commentViewModel_Jardinero;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        commentViewModel_Jardinero =
                ViewModelProviders.of(this).get(CommentViewModel_Jardinero.class);
        View root = inflater.inflate(R.layout.fragment_comment_jardinero, container, false);
        return root;
    }
}