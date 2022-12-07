package com.example.enapp.ui.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class SourceViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public SourceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is work fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}