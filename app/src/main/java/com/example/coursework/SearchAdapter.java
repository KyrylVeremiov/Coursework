package com.example.coursework;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private static String TAG= "MyLogs (SearchAdapter)";
    private static Search data;//search;
    private static List<Item> items;
    private boolean emptySearch=false;

    public SearchAdapter(Search data) {
        SearchAdapter.data = data;
    }

    public void setData(Search search) {
        Log.d("MyLogs:", "set data");
        SearchAdapter.data = search;
        emptySearch=false;
        SearchAdapter.items= search ==null? null: search.getCollection().getItems();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d("myLogs: ", "get data");
        if(emptySearch)
            holder.title.setText("There are no results of the search");

        else if(items!=null) {
                final Datum datum= items.get(position).getData().get(0);
                holder.title.setText(datum.getTitle());
                holder.webview.loadUrl(items.get(position).getHref());
            }
//          //            holder.search.loadUrl(String.valueOf(Html.fromHtml(search.(), Html.FROM_HTML_MODE_LEGACY)));

//        holder.search.loadUrl(search.getLocation());
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        if(items.size()==0){
            emptySearch=true;
            return 1;
        }
        return items.size();
//        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public WebView webview;
        public TextView title;

        public ViewHolder(final View itemView) {
            super(itemView);
            webview = (WebView) itemView.findViewById(R.id.webview);
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