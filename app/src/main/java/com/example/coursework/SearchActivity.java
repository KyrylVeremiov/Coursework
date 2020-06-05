package com.example.coursework;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchActivity extends AppCompatActivity implements Observer<ArrayList<HistoryRecord>> {
    private static String TAG="MyLogs";
    final MutableLiveData<ArrayList<HistoryRecord>> historyRecords = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, new SearchFragment())
                    .commit();
        }
        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<HistoryRecord> historyRecords1=(ArrayList<HistoryRecord>) new LocalDataSource().getHistory();
                historyRecords.postValue(historyRecords1);
            }
        });
    }



    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.history:
                Toast.makeText(this, "Your history", Toast.LENGTH_LONG).show();

//                final Object[] historyRecords=new Object[1];
//                final Bundle bundle = new Bundle();



//                MediatorLiveData<ArrayList<HistoryRecord>> historyRecords = new MediatorLiveData<>();
                final AppCompatActivity context=this;

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                LinearLayout layout = new LinearLayout(context);
        for (HistoryRecord historyRecord :
                Objects.requireNonNull(historyRecords.getValue())) {
            layout.setOrientation(LinearLayout.VERTICAL);

            TextView id = new TextView(context);
            id.setText(historyRecord.id);
            TextView title = new TextView(context);
            title.setText(historyRecord.title);
            TextView href = new TextView(context);
            href.setText(historyRecord.href);
            href.setPadding(0,0,0,5);
            layout.addView(id);
            layout.addView(title);
            layout.addView(href);
            

        }
                LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment()).commit();

                context.addContentView(layout, layoutParam);

//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HistoryFragment()).commit();
                Toast.makeText(this, "Search clicked", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();
        }
    }


    @Override
    public void onChanged(ArrayList<HistoryRecord> historyRecords) {

    }
}