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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_chiTietPhim;
import com.example.doanrapphim.activity_chitiet.tabthongtin;
import com.example.doanrapphim.lop.Phim;
import com.example.doanrapphim.lop.khungtgchieu;
import com.example.doanrapphim.lop.lichchieu;
import com.example.doanrapphim.lop.rap;
import com.google.android.youtube.player.internal.n;

import java.util.LinkedList;

public class AdapterLichChieu extends RecyclerView.Adapter<AdapterLichChieu.ViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<rap> p = new LinkedList<>();
    private LinkedList<khungtgchieu> tg = new LinkedList<>();
    Context context;
    private RecyclerView.RecycledViewPool child = new RecyclerView.RecycledViewPool();

    public AdapterLichChieu(LinkedList<rap> p, Context context) {
        this.p = p;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterLichChieu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_giochieu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLichChieu.ViewHolder holder, int position) {
        holder.ten.setText(p.get(position).getTenrap());

    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ten;
        RecyclerView rChild;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.tieude);
            rChild = itemView.findViewById(R.id.rcchild);
        }
    }
}
