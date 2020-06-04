package com.example.coursework;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private static Search data;//search;
    private static List<Item> items;

    public SearchAdapter(Search data) {
        SearchAdapter.data = data;
    }

    public void setData(Search search) {
        Log.d("MyLogs:", "set data");
        SearchAdapter.data = search;
        SearchAdapter.items= search ==null? null: search.getCollection().getItems();
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
                holder.show.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //todo new search_result_fragment

                    }
                });
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
        return items.size();
//        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public Button show;
        public TextView title;
        public Button details;

        public ViewHolder(final View itemView) {
            super(itemView);
            show = itemView.findViewById(R.id.show);
            title = itemView.findViewById(R.id.title);
            details= itemView.findViewById(R.id.details);
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