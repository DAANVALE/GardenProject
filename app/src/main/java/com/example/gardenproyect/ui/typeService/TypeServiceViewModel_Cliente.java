package com.example.gardenproyect.ui.typeService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TypeServiceViewModel_Cliente extends ViewModel {

    private MutableLiveData<String> mText;

    public TypeServiceViewModel_Cliente() {
        mText = new MutableLiveData<>();
        mText.setValue("This is type service fragment cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}