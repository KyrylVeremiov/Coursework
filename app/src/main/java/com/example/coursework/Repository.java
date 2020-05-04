package com.example.coursework;

import androidx.lifecycle.LiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Repository {
    private Executor executor = Executors.newSingleThreadExecutor();
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;
    public Repository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource){
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public LiveData<Search> refreshData(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.putData(remoteDataSource.fetchData());
            }
        });
        return localDataSource.getData();
    }
}
