package com.example.coursework;

import android.annotation.SuppressLint;
import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("Registered")
public class App extends Application {
    private static ImagesApiNasa imagesApiNasa;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://images-api.nasa.gov")
                .addConverterFactory(GsonConverterFactory.create()).build();
        imagesApiNasa = retrofit.create(ImagesApiNasa.class);
    }

    public static ImagesApiNasa getApi(){
        return imagesApiNasa;
    }
}