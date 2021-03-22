package com.example.gardenproyect.ui.comment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommentViewModel_Jardinero extends ViewModel {

    private MutableLiveData<String> mText;

    public CommentViewModel_Jardinero() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Comment Fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}