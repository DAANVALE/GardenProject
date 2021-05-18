package com.example.gardenproyect.ui.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServiceViewModel_JardineroTwo extends ViewModel {

    private MutableLiveData<String> mText;

    public ServiceViewModel_JardineroTwo() {
        mText = new MutableLiveData<>();
        mText.setValue("This is service fragment jardinero");
    }

    public LiveData<String> getText() {
        return mText;
    }
}