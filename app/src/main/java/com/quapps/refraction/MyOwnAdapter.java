package com.quapps.refraction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> headings;
    private ArrayList<String> body;
    MyOwnAdapter(Context context, ArrayList<String> headings, ArrayList<String> body){
        this.context=context;
        this.headings=headings;
        this.body=body;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInf=LayoutInflater.from(context);
        View myOwnView=mInf.inflate(R.layout.activity_news_layout,parent,false);
        return new MyViewHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.headings.setText(headings.get(position));
        holder.bodies.setText(body.get(position));

    }

    @Override
    public int getItemCount() {
        return headings.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView headings,bodies;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            headings=itemView.findViewById(R.id.newsHeadingTextView);
            bodies=itemView.findViewById(R.id.newsBodyTextView);
        }
    }
}
