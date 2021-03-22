package com.example.gardenproyect.ui.time;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimeViewModel_Cliente extends ViewModel {

    private MutableLiveData<String> mText;

    public TimeViewModel_Cliente() {
        mText = new MutableLiveData<>();
        mText.setValue("This is time fragment cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}