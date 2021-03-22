package com.example.gardenproyect.ui.dinero;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DineroViewModel_Cliente extends ViewModel {

    private MutableLiveData<String> mText;

    public DineroViewModel_Cliente() {
        mText = new MutableLiveData<>();
        mText.setValue("Estado de cuenta de Cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}