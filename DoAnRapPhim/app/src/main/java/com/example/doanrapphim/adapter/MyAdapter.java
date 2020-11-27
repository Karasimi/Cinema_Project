package com.example.doanrapphim.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.activity_chiTietPhim;
import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_chitiet.tabthongtin;
import com.example.doanrapphim.lop.Phim;

import java.util.LinkedList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.WordViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<Phim> p = new LinkedList<>();
    Context context;
    public MyAdapter(LinkedList<Phim> p, Context context) {
        this.p = p;
        this.context = context;
        mInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.row,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.ten.setText(p.get(position).getTenphim());
        holder.tlphim.setText(p.get(position).getTheloai());
        int hinhAnh = this.getDrawableResIdByName(p.get(position).getHinhanh());
        holder.img.setImageResource(hinhAnh);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activity_chiTietPhim.class);
                intent.putExtra("id",p.get(position).getId());
                Bundle bundle = new Bundle();
                bundle.putInt("id", p.get(position).getId());
                tabthongtin t = new tabthongtin();
                t.setArguments(bundle);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return p.size();
    }
    public void filterl(LinkedList<Phim> filterP){
        p = filterP;
        notifyDataSetChanged();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public  TextView ten,tlphim;
        public ImageView img;
        final MyAdapter mAdapter;
        ConstraintLayout constraintLayout;
        public WordViewHolder(View itemView, MyAdapter adapter) {
            super(itemView);
            ten = itemView.findViewById(R.id.tenphim);
            tlphim = itemView.findViewById(R.id.theloai);
            img = itemView.findViewById(R.id.img);
            this.mAdapter = adapter;
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.layoutds);
        }
    }
    public int getDrawableResIdByName(String tenHinh)  {
        String ct = context.getPackageName();
        int resID = context.getResources().getIdentifier(tenHinh , "drawable", ct);
        return resID;
    }
}
