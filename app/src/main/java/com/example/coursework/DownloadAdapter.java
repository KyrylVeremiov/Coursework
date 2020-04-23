package com.example.coursework;

import android.os.Build;
import android.text.Html;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework.Search;
import com.example.coursework.R;

public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.DownloadHolder> {
    private List<Pair<String, Integer>> data = new ArrayList<>();

    class DownloadHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView percent;
        public DownloadHolder(View view){
            super(view);
            name = view.findViewById(R.id.element_name);
            percent = view.findViewById(R.id.element_status);
        }
    }

    public void setData(List<Pair<String, Integer>> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DownloadAdapter.DownloadHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell, parent,false);
        return new DownloadHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DownloadAdapter.DownloadHolder holder, int position) {
        DownloadHolder viewHolder = holder;
        viewHolder.name.setText(data.get(position).first);
        viewHolder.percent.setText("" + data.get(position).second + "%");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
