package com.example.gardenproyect.ui.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalendarViewModel_Cliente extends ViewModel {

    private MutableLiveData<String> mText;

    public CalendarViewModel_Cliente() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calendar fragment cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}