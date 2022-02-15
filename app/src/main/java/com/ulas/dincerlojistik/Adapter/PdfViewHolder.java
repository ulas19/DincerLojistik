package com.ulas.dincerlojistik.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ulas.dincerlojistik.R;

public class PdfViewHolder extends RecyclerView.ViewHolder {
    public TextView tvName;
    public CardView container;

    public PdfViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        container=itemView.findViewById(R.id.container);
    }
}
