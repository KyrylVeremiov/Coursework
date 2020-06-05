package com.example.coursework;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private static String TAG= "MyLogs";
    private static Repository repository;
    private static MediatorLiveData<Search> data = new MediatorLiveData<Search>();//reprository.getData()
    //Database
    //Activity

    public DataViewModel() {
        repository=App.getInstance().getRepository();
        data.removeSource(repository.getData());
        data.addSource(repository.getData(), new Observer<Search>() {
            @Override
            public void onChanged(@Nullable Search search) {
                Log.d(TAG,"onChanged!");
                data.setValue(search);
            }
        });
    }

public LiveData<Search> getData() {
    return data;
}
public LiveData<Search> searchData(String[] params) {
    repository.refreshData(params);
    return data;
}
}