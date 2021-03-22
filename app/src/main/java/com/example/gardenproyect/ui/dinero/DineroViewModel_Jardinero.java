package com.example.gardenproyect.ui.dinero;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DineroViewModel_Jardinero extends ViewModel {

    private MutableLiveData<String> mText;

    public DineroViewModel_Jardinero() {
        mText = new MutableLiveData<>();
        mText.setValue("Estado de cuenta de jardinero");
    }

    public LiveData<String> getText() {
        return mText;
    }
}