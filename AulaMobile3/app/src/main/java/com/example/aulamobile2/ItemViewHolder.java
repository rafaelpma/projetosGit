package com.example.aulamobile2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ItemViewHolder extends ViewHolder {

    private final TextView tvText;
    private final ConstraintLayout layoutPai;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        tvText = itemView.findViewById(R.id.tvItem);
        layoutPai = itemView.findViewById(R.id.layoutPai);

    }

    public TextView getTvText() {
        return tvText;
    }

    public ConstraintLayout getLayoutPai() {
        return layoutPai;
    }
}
