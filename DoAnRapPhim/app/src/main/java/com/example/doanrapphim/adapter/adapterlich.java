package com.example.doanrapphim.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.itf.OnItemClickListener;
import com.example.doanrapphim.lop.Phim;
import com.example.doanrapphim.lop.lich;

import java.util.LinkedList;


public class adapterlich extends RecyclerView.Adapter<adapterlich.WordViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<lich> p = new LinkedList<>();
    Context context;
    public OnItemClickListener onItemClickListener;
    public adapterlich(LinkedList<lich> p, Context context) {
        this.p = p;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.lich,
                parent, false);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
            holder.t1.setText(p.get(position).getThu());
            holder.t2.setText(String.valueOf(p.get(position).getNgay()));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClickListener(p.get(position).getThu(), p.get(position).getNgay(), p.get(position).getThang(), p.get(position).getNam());
            }
        });
    }
    @Override
    public int getItemCount() {
        return p.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        LinearLayout linearLayout;
        TextView all;
        public WordViewHolder(View itemView,adapterlich adapter) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tv1);
            t2 = itemView.findViewById(R.id.tv2);
            linearLayout = itemView.findViewById(R.id.lich);
        }

    }
}
