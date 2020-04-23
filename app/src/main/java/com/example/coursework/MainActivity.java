package com.example.coursework;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    List<Search> searches;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*  // recycler = findViewById(R.id.download_recycler);
        final DownloadAdapter downloadAdapter = new DownloadAdapter();
        recycler.setAdapter(downloadAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                List<Pair<String, Integer>> incomingData = (List<Pair<String, Integer>>)msg.obj;
                downloadAdapter.setData(incomingData);
            }
        };*/


        recycler = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        SearchAdapter adapter = new SearchAdapter(searches);
        recycler.setAdapter(adapter);

        try {
            Response<List<Search>> response = App.getApi().getData("search").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        App.getApi().getData("search").enqueue(new Callback<List<Search>>() {
            @Override
            public void onResponse(Call<List<Search>> call, Response<List<Search>> response){
                assert response.body() != null;
                searches.addAll(response.body());
                Objects.requireNonNull(recycler.getAdapter()).notifyDataSetChanged();

                //recycler.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Search>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}