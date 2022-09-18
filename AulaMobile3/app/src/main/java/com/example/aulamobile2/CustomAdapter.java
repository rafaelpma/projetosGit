package com.example.aulamobile2;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<String> localDataSet;
    private String[] colors;

    public CustomAdapter(List<String> localDataSet, String[] colors) {
        this.localDataSet = localDataSet;
        this.colors = colors;
    }


    public List<String> getLocalDataSet() {
        return localDataSet;
    }

    public void setLocalDataSet(List<String> localDataSet) {
        this.localDataSet = localDataSet;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_layout, viewGroup, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int position) {
        viewHolder.getTvText().setText(localDataSet.get(position));
        viewHolder.getLayoutPai().setBackgroundColor (Color.parseColor(colors[0]));

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
