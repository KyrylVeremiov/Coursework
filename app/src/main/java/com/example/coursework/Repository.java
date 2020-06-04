package com.example.coursework;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Repository {
    private Executor executor = Executors.newSingleThreadExecutor();
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;
    private MutableLiveData<Boolean> loadStatus = new MutableLiveData<>();

    public Repository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public LiveData<Search> refreshData(final String[] params) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //                AppDatabase db = App.getInstance().getDatabase();
//                HistoryDao searchDao = db.searchDao();
//                MutableLiveData<Search> data=new MutableLiveData<Search>();
//                if(searchDao.getAll().size()!=0){
//                    data.setValue(searchDao.getById(0));
//                }
                loadStatus.postValue(true);
                Search data = remoteDataSource.fetchData(params);
                localDataSource.putData(data);
                loadStatus.postValue(false);
            }
        });
        return localDataSource.getData();
    }

    public LiveData<Search> getData() {
        return localDataSource.getData();
    }
    public LiveData<Boolean> getLoadStatus(){
        return loadStatus;
    }
}
