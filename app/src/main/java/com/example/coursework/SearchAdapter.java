package com.example.coursework;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<Search> searches;

    public SearchAdapter(List<Search> searhes) {
        this.searches = searhes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Search search = searches.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.search.setText(Html.fromHtml(search.getLocation(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.search.setText(Html.fromHtml(search.getLocation()));
        }
        holder.search.setText(search.getLocation());
    }

    @Override
    public int getItemCount() {
        if (searches == null)
            return 0;
        return searches.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView search;

        public ViewHolder(View itemView) {
            super(itemView);
            search = (TextView) itemView.findViewById(R.id.element_name);
        }
    }
}
