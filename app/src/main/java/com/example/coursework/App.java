package com.example.coursework;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("Registered")
public class App extends Application {

    private ViewModelProvider.Factory factory;


    private static ImagesApiNasa imagesApiNasa;
    private Retrofit retrofitNasa;

    public static App instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        factory = new DataViewModelFactory();

        super.onCreate();
        instance = this;
        database =  Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "history").build();

        retrofitNasa = new Retrofit.Builder()
                .baseUrl("https://images-api.nasa.gov")
                .addConverterFactory(GsonConverterFactory.create()).build();
        imagesApiNasa = retrofitNasa.create(ImagesApiNasa.class);
    }

    ViewModelProvider.Factory getViewModeFactory(){
        return factory;
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public static ImagesApiNasa getSearchApi(){
        return imagesApiNasa;
    }
}
