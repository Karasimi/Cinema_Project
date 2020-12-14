package com.example.giaodienchinh;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.zip.Inflater;

public class Adapterdsphim extends RecyclerView.Adapter<Adapterdsphim.ViewHolder> {

    LinkedList<Phim> p = new LinkedList<Phim>();

    public Adapterdsphim(LinkedList<Phim> p, Context context) {
        this.p = p;
        this.context = context;
    }

    Context context;
    @NonNull
    @Override
    public Adapterdsphim.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_dsmovie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterdsphim.ViewHolder holder, int position) {
       holder.textView.setText(p.get(position).getTenphim());
       int hinhAnh = getDrawableResIdByName(p.get(position).getHinhanh());
       holder.imageView.setImageResource(hinhAnh);
    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.txttenphim);
        }
    }
    public int getDrawableResIdByName(String tenHinh)  {
        String ct = context.getPackageName();
        int resID = context.getResources().getIdentifier(tenHinh , "drawable", ct);
        return resID;
    }
}
