package com.example.coursework;

import android.util.Log;

import java.io.IOException;

import retrofit2.Response;

public class RemoteDataSource {

    public Search fetchData(){
        Search data = new Search();
        Log.e("myLogs", "making request");
        try {
            Response<Search> response = App.getApi().getData().execute();
            Log.d("myLogs: ", "response is received");
            data=response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
