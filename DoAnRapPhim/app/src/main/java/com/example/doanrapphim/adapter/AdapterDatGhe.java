package com.example.doanrapphim.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doanrapphim.R;
import com.example.doanrapphim.itf.OnItemClickListener;
import com.example.doanrapphim.itf.tongSoTien;
import com.example.doanrapphim.lop.ghe;
import com.example.doanrapphim.lop.gia;

import java.util.LinkedList;

public class    AdapterDatGhe extends RecyclerView.Adapter<AdapterDatGhe.ViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<ghe> p;
    private LinkedList<gia> gi;
    int f =1;
    public tongSoTien tongSoTien;
    double sotien;
    Context context;
    public AdapterDatGhe(LinkedList<ghe> p, Context context, LinkedList<gia> g, tongSoTien tongSoTien) {
        this.p = p;
        this.gi = g;
        this.tongSoTien = tongSoTien;
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
        if (p.get(position).getTrangthai() == 2){
            holder.btn.setBackgroundColor(Color.RED);
        }
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (p.get(position).getTrangthai() == 1) {
                    if (p.get(position).isDat() == false) {
                        ghe g = p.get(position);
                        holder.btn.setBackgroundColor(Color.BLUE);
                        g.setDat(!g.isDat());
                        tangGia(gi, p.get(position).getLoai());
                    } else {
                        ghe g = p.get(position);
                        holder.btn.setBackgroundColor(Color.GREEN);
                        g.setDat(!g.isDat());
                        giamGia(gi, p.get(position).getLoai());
                    }
                    tongSoTien.tongSoTien(sotien);
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
    public void tangGia(LinkedList<gia> a, int loai){
        double tien = 0.0;
        for (gia f :a) {
            if (f.getLoaighe() == loai){
                sotien = sotien + f.getGia();
            }else {
                if (f.getLoaighe() == loai){
                    sotien = sotien + f.getGia();
                }
            }

        }
    }
    public void giamGia(LinkedList<gia> a, int loai){
        for (gia f :a) {
            if (f.getLoaighe() == loai){
                sotien = sotien - f.getGia();
            }else {
                if (f.getLoaighe() == loai){
                    sotien = sotien - f.getGia();
                }
            }

        }
    }
}
