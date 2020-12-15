package com.example.giaodienchinh;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.zip.Inflater;

public class Adapterdsphim extends RecyclerView.Adapter<Adapterdsphim.ViewHolder> {

    LinkedList<Phim> p = new LinkedList<Phim>();///danh sach cac pgim lay dc

    public Adapterdsphim(LinkedList<Phim> p, Context context) {//khoi tao danh sach do
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
    }//tra ra giao dien

    @Override
    public void onBindViewHolder(@NonNull Adapterdsphim.ViewHolder holder, int position) {//load len giao dien
       holder.textView.setText(p.get(position).getTenphim());
       int hinhAnh = getDrawableResIdByName(p.get(position).getHinhanh());
       holder.imageView.setImageResource(hinhAnh);
       holder.noidung.setText(p.get(position).getDaodien());
       holder.noidung.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
    }

    @Override
    public int getItemCount() {
        return p.size();
    }//tra ve sao luong phim

    public class ViewHolder extends  RecyclerView.ViewHolder{//
        ImageView imageView;
        TextView textView;

        TextView noidung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.txttenphim);

            noidung = itemView.findViewById(R.id.noidung);
        }
    }
    public int getDrawableResIdByName(String tenHinh)  {//lay hinh anh
        String ct = context.getPackageName();
        int resID = context.getResources().getIdentifier(tenHinh , "drawable", ct);
        return resID;
    }
}
