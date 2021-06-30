package com.example.mycardviewapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder
{
    ImageView rowImage;
    TextView rowHeader, rowDescription;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        rowImage = (ImageView) itemView.findViewById(R.id.rowImage);
        rowHeader = (TextView) itemView.findViewById(R.id.rowHeader);
        rowDescription = (TextView) itemView.findViewById(R.id.rowDescription);

    }
}
