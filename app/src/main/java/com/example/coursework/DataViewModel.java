package com.example.coursework;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    public DataViewModel(){

    }
    private Repository repository = new Repository(new LocalDataSource(), new RemoteDataSource());
    private MediatorLiveData<Search> data = new MediatorLiveData<>();

    public LiveData<Search> getData(){
        data.addSource(repository.refreshData(), new Observer<Search>() {
            @Override
            public void onChanged(Search o) {

            }
        });
        return data;
    }
}
