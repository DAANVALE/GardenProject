package com.example.gardenproyect.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel_Cliente extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel_Cliente() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}