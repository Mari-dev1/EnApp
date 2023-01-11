package com.example.enapp.ui.airpollution;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class AirViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public AirViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is air fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
