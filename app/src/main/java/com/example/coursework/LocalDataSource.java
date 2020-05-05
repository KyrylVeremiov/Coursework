package com.example.coursework;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LocalDataSource {
    private MutableLiveData<Search> liveData = new MutableLiveData<Search>();

    public void setData(LiveData<Search> data) {
        this.liveData= (MutableLiveData<Search>) data;
    }

    public LiveData<Search> getData(){
        return liveData;
    }


    public void putData(Search data){
        this.liveData.postValue(data);
    }
}
