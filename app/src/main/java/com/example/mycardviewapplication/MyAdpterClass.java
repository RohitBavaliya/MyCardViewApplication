package com.example.mycardviewapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdpterClass extends RecyclerView.Adapter<MyViewHolder> implements Filterable
{
    ArrayList<Model> data;
    ArrayList<Model> backup;

    Context context;
    public MyAdpterClass(ArrayList<Model> data,Context context) {
        this.data = data;
        this.context = context;
        backup = new ArrayList<>(data);  // backup copy of original ArrayList
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // create blank view
        View view = inflater.inflate(R.layout.single_raw,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Model tempObj = data.get(position);

        holder.rowHeader.setText(data.get(position).getHeader());
        holder.rowDescription.setText(data.get(position).getDescription());
        holder.rowImage.setImageResource(data.get(position).getImageName());

        holder.rowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ItemData.class);
                intent.putExtra("imageFinal",tempObj.getImageName());
                intent.putExtra("headerFinal",tempObj.getHeader());
                intent.putExtra("descFinal",tempObj.getDescription());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override  // background Thread
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<Model> filterData = new ArrayList<>();
            if (keyword.toString().isEmpty())
            {
                filterData.addAll(backup);
            }
            else {
                for (Model obj:backup)
                {
                    if (obj.getHeader().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                    {
                        filterData.add(obj);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filterData;
            return results;
        }

        @Override  // main UI Thread
        protected void publishResults(CharSequence keyword, FilterResults results) {
            // clear ArrayList
            data.clear();
            // add all search values
            data.addAll((ArrayList<Model>)results.values);
            notifyDataSetChanged();
        }
    };
}
