package com.example.coursework;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

public class LocalDataSource {
    private MutableLiveData<Search> liveData = new MutableLiveData<Search>();
    public static App instance;
    private static final String TAG="MyLogs (LocalDataSource): ";

    private AppDatabase database;

    LocalDataSource(){
        database =  Room.databaseBuilder(App.getInstance().getApplicationContext(),
                AppDatabase.class, "history").build();
    }

    public void setData(LiveData<Search> data) {
        this.liveData= (MutableLiveData<Search>) data;
    }

    public LiveData<Search> getData(){
        return liveData;
    }


    public void putData(Search data) {
        this.liveData.postValue(data);
        if (data != null) {
            Datum datum = data.getCollection().getItems().get(0).getData().get(0);
            String href = data.getCollection().getHref();
            HistoryRecord record = new HistoryRecord(datum.getNasaId(), datum.getTitle(), href);
            Log.d(TAG, "New record to database" + "id: " + datum.getNasaId() + "title: " + datum.getTitle() + "href: " + href);
            database.historyDao().insert(record);
            Log.d(TAG, "The record is done");
        }
    }
}
