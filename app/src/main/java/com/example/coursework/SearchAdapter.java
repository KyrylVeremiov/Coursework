package com.example.coursework;

import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private static Search data;

    public SearchAdapter(Search data) {
        if(data==null){
            this.data=new Search();
        }
        else {
            this.data = data;
        }
    }

    public void setData(Search data) {
        Log.d("myLogs: ", "set data");
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("myLogs: ", "get data");
        Search search = data;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.search.loadUrl(String.valueOf(Html.fromHtml(search.getLocation(), Html.FROM_HTML_MODE_LEGACY)));
        } else {
            holder.search.loadUrl(String.valueOf(Html.fromHtml(search.getLocation())));
        }
        holder.search.loadUrl(search.getLocation());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        WebView search;
        public ViewHolder(View itemView) {
            super(itemView);
            search = itemView.findViewById(R.id.element);
        }
    }
}