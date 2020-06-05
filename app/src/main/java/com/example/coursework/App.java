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
    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        factory = new DataViewModelFactory();

        instance = this;
    }
    ViewModelProvider.Factory getViewModeFactory(){
        return factory;
    }

    public static App getInstance() {
        return instance;
    }
}
