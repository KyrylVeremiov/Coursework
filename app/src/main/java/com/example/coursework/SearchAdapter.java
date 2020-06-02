package com.example.coursework;

import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private static Search data;//search;
    private static List<Item> items;

    public SearchAdapter(Search data) {
        if(data==null){
            SearchAdapter.data =new Search();
        }
        else {
            SearchAdapter.data = data;
        }

        SearchAdapter.items =SearchAdapter.data.getItems();
    }

    public void setData(Search search) {
        Log.d("myLogs:", "set data");
        SearchAdapter.data = search;
        SearchAdapter.items= search==null? null:search.getItems();
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if(items!=null) {
                holder.title.setText(items.get(position).getData().get(0).getTitle());
                holder.media.loadUrl(String.valueOf(Html.fromHtml(items.get(position).getData().get(0).getTitle(), Html.FROM_HTML_MODE_LEGACY)));
            }
//          //            holder.search.loadUrl(String.valueOf(Html.fromHtml(search.(), Html.FROM_HTML_MODE_LEGACY)));
        } else {
//            holder.search.loadUrl(String.valueOf(Html.fromHtml(search.getLocation())));
        }
//        holder.search.loadUrl(search.getLocation());
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
//        return items.size();
        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public WebView media;
        public TextView title;
        public ViewHolder(final View itemView) {
            super(itemView);
            media = itemView.findViewById(R.id.media);
            title = itemView.findViewById(R.id.title);
        }
    }
}



//package com.example.coursework;
//
//import android.os.Build;
//import android.text.Html;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
//
//    private static Search data;
//
//
//    public SearchAdapter(Search data) {
//        if(data==null){
//            SearchAdapter.data =new Search();
//        }
//        else {
//            SearchAdapter.data = data;
//        }
//    }
//
//    public void setData(Search data) {
//        Log.d("myLogs: ", "set data");
//        SearchAdapter.data = data;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell, parent, false);
//        return new ViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Log.d("myLogs: ", "get data");
//        Search search = data;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            holder.search.loadUrl(String.valueOf(Html.fromHtml(search.(), Html.FROM_HTML_MODE_LEGACY)));
//        } else {
//            holder.search.loadUrl(String.valueOf(Html.fromHtml(search.getLocation())));
//        }
//        holder.search.loadUrl(search.getLocation());
//    }
//
//    @Override
//    public int getItemCount() {
//        return 1;
//    }
//
//    static class ViewHolder extends RecyclerView.ViewHolder {
//        WebView search;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            search = itemView.fin