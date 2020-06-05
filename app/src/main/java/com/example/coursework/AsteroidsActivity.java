package com.example.coursework;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class AsteroidsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asteroids_activity);

        WebView browser = (WebView) findViewById(R.id.asteroids_web_view);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        browser.getSettings().setAllowContentAccess(true);
        browser.getSettings().setDomStorageEnabled(true);
        browser.getSettings().setAppCacheEnabled(true);
        browser.getSettings().setAppCachePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/cache");
        browser.getSettings().setDatabaseEnabled(true);
        browser.getSettings().setDatabasePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/databases");
        browser.loadUrl("http://www.asterank.com/3d/");
    }
}
