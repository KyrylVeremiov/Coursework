package com.example.coursework;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Repository {
    private Executor executor = Executors.newSingleThreadExecutor();
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;

    public Repository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public LiveData<Search> refreshData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.putData(remoteDataSource.fetchData());
//

            }
        });
        return localDataSource.getData();
    }

    public LiveData<Search> getData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = App.getInstance().getDatabase();
                SearchDao searchDao = db.searchDao();
                MutableLiveData<Search> data=new MutableLiveData<Search>();
                if(searchDao.getAll().size()!=0){
                    data.setValue(searchDao.getById(0));
                }
            }
        });
        return localDataSource.getData();
    }
}
