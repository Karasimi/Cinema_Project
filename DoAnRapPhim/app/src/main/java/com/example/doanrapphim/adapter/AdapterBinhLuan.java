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
import com.example.doanrapphim.lop.BinhLuan;
import com.example.doanrapphim.lop.ghe;
import com.example.doanrapphim.lop.gia;

import java.util.LinkedList;

public class  AdapterBinhLuan extends RecyclerView.Adapter<AdapterBinhLuan.ViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<BinhLuan> p;
    Context context;
    public AdapterBinhLuan(LinkedList<BinhLuan> p, Context context) {
        this.p = p;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterBinhLuan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_binhluan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBinhLuan.ViewHolder holder, int position) {
        holder.txt.setText(p.get(position).getKhachhang());
        holder.txt1.setText(p.get(position).getNoidung());

    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt, txt1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.tvKH);
            txt1 = itemView.findViewById(R.id.tvND);
        }
    }

}
