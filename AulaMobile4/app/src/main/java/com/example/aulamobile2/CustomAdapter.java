package com.example.aulamobile2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<String> localDataSet;


    public CustomAdapter(List<String> localDataSet) {
        this.localDataSet = localDataSet;

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


    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
