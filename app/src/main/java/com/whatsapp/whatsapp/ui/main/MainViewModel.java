package com.whatsapp.whatsapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> screenIndex;

    public MainViewModel() {
        this.screenIndex = new MutableLiveData<>();
    }

    public LiveData<Integer> getScreenIndex() {
        return screenIndex;
    }

    public void setScreenIndex(int index) {
        this.screenIndex.setValue(index);
    }
}
