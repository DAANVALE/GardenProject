package com.example.gardenproyect.ui.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServiceViewModel_Cliente extends ViewModel {

    private MutableLiveData<String> mText;

    public ServiceViewModel_Cliente() {
        mText = new MutableLiveData<>();
        mText.setValue("This is service fragment cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}