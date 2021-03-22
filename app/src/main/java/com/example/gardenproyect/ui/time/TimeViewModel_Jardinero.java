package com.example.gardenproyect.ui.time;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimeViewModel_Jardinero extends ViewModel {

    private MutableLiveData<String> mText;

    public TimeViewModel_Jardinero() {
        mText = new MutableLiveData<>();
        mText.setValue("This is time fragment jardinero");
    }

    public LiveData<String> getText() {
        return mText;
    }
}