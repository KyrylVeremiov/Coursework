package com.example.coursework;

import android.util.Log;

import java.io.IOException;

import retrofit2.Response;

public class RemoteDataSource {
    public Search fetchData(String[] params){
        Search data = new Search();
        Log.e("myLogs", "making request");
        try {
            for(int i=0;i<params.length;i++){
                if(params[i]!=null && params[i].equals(""))params[i]=null;
            }

            Response response = App.getSearchApi().search(params[0],params[1],params[2],params[3],params[4],params[5],params[6],
                    params[7],params[8],params[9],params[10],params[11],params[12],params[13]).execute();
//            Response<SatellitePosition> response = App.getN2YOApi().getData().execute();
            Log.d("myLogs: ", "response is received");
            data= (Search) response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}