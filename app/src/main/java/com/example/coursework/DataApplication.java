package com.example.coursework;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.lifecycle.ViewModelProvider;
@SuppressLint("Registered")
public class DataApplication extends Application {

    private ViewModelProvider.Factory factory;

    @Override
    public void onCreate() {
        super.onCreate();
        factory = new DataViewModelFactory();
    }

    ViewModelProvider.Factory getViewModeFactory(){
        return factory;
    }
}
