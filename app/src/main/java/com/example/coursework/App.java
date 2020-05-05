package com.example.coursework;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.room.Room;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("Registered")
public class App extends Application {
    private static ImagesApiNasa imagesApiNasa;
    private Retrofit retrofit;

    public static App instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database =  Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database").build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://images-api.nasa.gov")
                .addConverterFactory(GsonConverterFactory.create()).build();
        imagesApiNasa = retrofit.create(ImagesApiNasa.class);
    }
    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public static ImagesApiNasa getApi(){
        return imagesApiNasa;
    }
}