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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_chiTietPhim;
import com.example.doanrapphim.activity_chitiet.tabthongtin;
import com.example.doanrapphim.lop.Phim;

import java.util.LinkedList;

public class adaptertopphim extends RecyclerView.Adapter<adaptertopphim.ViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<Phim> p = new LinkedList<>();
    Context context;

    public adaptertopphim( LinkedList<Phim> p, Context context) {
        this.p = p;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public adaptertopphim.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.itemtopphim,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptertopphim.ViewHolder holder, int position) {
        holder.ten.setText(p.get(position).getTenphim());
        holder.theloai.setText(p.get(position).getTheloai());
        int hinhAnh = this.getDrawableResIdByName(p.get(position).getHinhanh());
        holder.imageView.setImageResource(hinhAnh);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activity_chiTietPhim.class);
                intent.putExtra("id",p.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView ten,theloai;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            ten = itemView.findViewById(R.id.tenphim);
            theloai = itemView.findViewById(R.id.theloai);
            linearLayout = itemView.findViewById(R.id.topphim);

        }
    }
    public int getDrawableResIdByName(String tenHinh)  {
        String ct = context.getPackageName();
        int resID = context.getResources().getIdentifier(tenHinh , "drawable", ct);
        return resID;
    }
    public void filterl(LinkedList<Phim> filterP){
        p = filterP;
        notifyDataSetChanged();
    }
}
