package com.example.coursework;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class SatellitesActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.satellite_activity);
//
        WebView browser = findViewById(R.id.satellites_web_view);
//        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("https://www.n2yo.com/");
    }
}
