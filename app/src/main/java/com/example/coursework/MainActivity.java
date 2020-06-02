package com.example.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity implements Observer<Search> {

LiveData<Search> liveData;
@Override
protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            liveData=new MutableLiveData<>();
            liveData.observe(this, this);
        }
        public void startMediaSearchActivity(View view){
            Intent startMediaSearchActivity= new Intent(this, MediaSearchActivity.class);
            startActivity(startMediaSearchActivity);

            }

    @Override
    public void onChanged(Search search) {

    }

    public void startAsteroidsActivity(View view) {

    }

    public void startSatellitesActivity(View view) {
    }

    public void startStarsActivity(View view) {
    }
}