package com.example.coursework;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("Registered")
public class App extends Application {

    private ViewModelProvider.Factory factory;


    private static ImagesApiNasa imagesApiNasa;
    private static N2YOApi n2YOApi;
    private Retrofit retrofitNasa;
    private Retrofit retrofitn2YO;

    public static App instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        factory = new DataViewModelFactory();

        super.onCreate();
        instance = this;
//        database =  Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "database").build();

        retrofitNasa = new Retrofit.Builder()
                .baseUrl("https://images-api.nasa.gov")
                .addConverterFactory(GsonConverterFactory.create()).build();
        imagesApiNasa = retrofitNasa.create(ImagesApiNasa.class);
        retrofitn2YO=new Retrofit.Builder()
                .baseUrl("https://www.n2yo.com/rest/v1/satellite/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        n2YOApi=retrofitn2YO.create(N2YOApi.class);
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
    public static N2YOApi getN2YOApi(){
        return n2YOApi;
    }
}
