package com.example.gardenproyect.ui.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalendarViewModel_Jardinero extends ViewModel {

    private MutableLiveData<String> mText;

    public CalendarViewModel_Jardinero() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calendar fragment jardinero");
    }

    public LiveData<String> getText() {
        return mText;
    }
}