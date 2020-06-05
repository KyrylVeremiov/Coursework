package com.example.coursework;

import android.util.Log;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private static ImagesApiNasa imagesApiNasa;
    private Retrofit retrofitNasa;
    RemoteDataSource(){
        retrofitNasa = new Retrofit.Builder()
                .baseUrl("https://images-api.nasa.gov")
                .addConverterFactory(GsonConverterFactory.create()).build();
        imagesApiNasa = retrofitNasa.create(ImagesApiNasa.class);
    }
    public Search fetchData(String[] params){
        Search data = new Search();
        Log.e("myLogs", "making request");
        try {
            for(int i=0;i<params.length;i++){
                if(params[i]!=null && params[i].equals(""))params[i]=null;
            }
            Response response = imagesApiNasa.search(params[0],params[1],params[2],params[3],params[4],params[5],params[6],
                    params[7],params[8],params[9],params[10],params[11],params[12],params[13]).execute();
            Log.d("myLogs: ", "response is received");
            //if(response.isSuccessful())
            data= (Search) response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}