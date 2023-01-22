package com.example.enapp.ui.air;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class AirViewModel extends ViewModel {
    private final MutableLiveData<String> xText;

    public AirViewModel() {
        xText = new MutableLiveData<>();
        xText.setValue("This is air fragment");
    }

    public LiveData<String> getText() {
        return xText;
    }

}
