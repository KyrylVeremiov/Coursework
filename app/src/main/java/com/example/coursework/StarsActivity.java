package com.example.coursework;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class StarsActivity extends AppCompatActivity {
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stars_activity);
//loadDataWithBaseUrl
        //WebViewClient
        WebView browser = (WebView) findViewById(R.id.stars_web_view);

//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
//                // все ссылки, в которых содержится домен
//                // будут открываться внутри приложения
//                if (url.contains("my-site.ru")) {
//                    return false;
//                }
//                // все остальные ссылки будут спрашивать какой браузер открывать
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                activity.startActivity(intent);
//                return true;
//            }
//        });
//        String urlAddress = getString(R.string.main_url_schema) + "://" + getString(R.string.main_url_domain);
//        webView.loadUrl(urlAddress);


        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        browser.getSettings().setAllowContentAccess(true);
        browser.getSettings().setDomStorageEnabled(true);
        browser.getSettings().setAppCacheEnabled(true);
        browser.getSettings().setAppCachePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/cache");
        browser.getSettings().setDatabaseEnabled(true);
        browser.getSettings().setDatabasePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/databases");
//        browser.getSettings().setPluginState(true);
        browser.loadUrl("https://stars.chromeexperiments.com");
    }
}
