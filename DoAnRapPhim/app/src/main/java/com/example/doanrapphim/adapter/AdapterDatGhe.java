package com.example.doanrapphim.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doanrapphim.R;
import com.example.doanrapphim.lop.ghe;
import com.example.doanrapphim.lop.lichchieu;
import com.example.doanrapphim.lop.rap;

import java.util.LinkedList;

public class AdapterDatGhe extends RecyclerView.Adapter<AdapterDatGhe.ViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<ghe> p;
    int f =1;
    Context context;
    public AdapterDatGhe(LinkedList<ghe> p, Context context) {
        this.p = p;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterDatGhe.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_datghe,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDatGhe.ViewHolder holder, int position) {
        String tenGhe = p.get(position).getHang() + p.get(position).getCot();
        holder.btn.setText(tenGhe);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (p.get(position).isDat() == false){
                    ghe g = p.get(position);
                    holder.btn.setBackgroundColor(Color.BLUE);
                    g.setDat(!g.isDat());
                }
                else {
                    ghe g = p.get(position);
                    holder.btn.setBackgroundColor(Color.GREEN);
                    g.setDat(!g.isDat());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.ghe);
        }
    }
}
