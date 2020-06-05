package com.example.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity implements Observer<Search> {
    private static String TAG= "MyLogs (MainActivity)";
//Option menu: Fragments : settings,regestration,history
    //Activityes
LiveData<Search> liveData;
@Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            liveData=new MutableLiveData<>();
            liveData.observe(this, this);
        }


    @Override
    public void onChanged(Search search) {

    }
    public void startMediaSearchActivity(View view){
        Intent startMediaSearchActivity= new Intent(this, SearchActivity.class);
        startActivity(startMediaSearchActivity);
    }

    public void startAsteroidsActivity(View view) {
        Intent startAsteroidsActivity= new Intent(this, AsteroidsActivity.class);
        startActivity(startAsteroidsActivity);
    }

    public void startSatellitesActivity(View view) {
        Intent startAsteroidsActivity= new Intent(this, SatellitesActivity.class);
        startActivity(startAsteroidsActivity);
    }

    public void startStarsActivity(View view) {
        Intent startStarsActivity= new Intent(this, StarsActivity.class);
        startActivity(startStarsActivity);
    }
}