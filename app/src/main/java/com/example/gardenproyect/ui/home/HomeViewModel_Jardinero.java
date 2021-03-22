package com.example.gardenproyect.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel_Jardinero extends ViewModel{

    private MutableLiveData<String> mText;

    public HomeViewModel_Jardinero() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment jardinero");
    }

    public LiveData<String> getText() {
        return mText;
    }
}