package com.example.coursework;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchActivity extends AppCompatActivity {
    private static String TAG="MyLogs";

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
    }



    @Override
    protected void onPause() {
        super.onPause();
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.history:
//                Toast.makeText(this, "Your history", Toast.LENGTH_LONG).show();
//
//                Executor executor = Executors.newSingleThreadExecutor();
//                final ArrayList<HistoryRecord>historyRecords = new ArrayList<HistoryRecord>;
//                executor.execute(new Runnable() {
//                                     @Override
//                                     public void run() {
//                                         historyRecords[0] =(ArrayList<HistoryRecord>) new LocalDataSource().getHistory();
//
//                                     }
//                                 });
//                for (HistoryRecord historyRecord :
//                        historyRecords[0]) {
//                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                            LinearLayout.LayoutParams.WRAP_CONTENT);
//                    LinearLayout layout = new LinearLayout(this);
//                    layout.setOrientation(LinearLayout.VERTICAL);
//
//                    TextView id = new TextView(this);
//                    id.setText(historyRecord.id);
//                    TextView title = new TextView(this);
//                    title.setText(historyRecord.title);
//                    TextView href = new TextView(this);
//                    href.setText(historyRecord.href);
//                    layout.addView(id);
//                    layout.addView(title);
//                    layout.addView(href);
//
//                    LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                            LinearLayout.LayoutParams.WRAP_CONTENT);
//                    this.addContentView(layout, layoutParam);
//                }
////                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HistoryFragment()).commit();
//                Toast.makeText(this, "Search clicked", Toast.LENGTH_LONG).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

//    @Override
//    public void onBackPressed() {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        if (fragmentManager.getBackStackEntryCount() == 1) {
//            finish();
//        } else {
//            fragmentManager.popBackStack();
//        }
//    }
}