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
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.AsysntaskLoader.AsynTask;
import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_chiTietPhim;
import com.example.doanrapphim.activity_chitiet.tabthongtin;
import com.example.doanrapphim.lop.Phim;
import com.example.doanrapphim.lop.khungtgchieu;
import com.example.doanrapphim.lop.lich;
import com.example.doanrapphim.lop.lichchieu;
import com.example.doanrapphim.lop.rap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class AdapterLichChieu extends RecyclerView.Adapter<AdapterLichChieu.ViewHolder>{
    private LayoutInflater mInflater;
    private LinkedList<khungtgchieu> khungtgchieus;
    private LinkedList<khungtgchieu> k;
    private LinkedList<rap> p;
    private int idPhim;
    private String ngayChieu;
    Context context;
    static final int GET = 1;
    static final int POST = 2;
    static final int LOADERLGio = 111;
    public AdapterLichChieu(LinkedList<rap> p, int a, LinkedList<khungtgchieu> gioChieu, Context context) {
        this.p = p;
        this.idPhim = a;
        this.context = context;
        this.khungtgchieus = gioChieu;
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
        int idRap = p.get(position).getId();
        holder.ten.setText(p.get(position).getTenrap());
        if (k != null){
            k.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("rap",idRap);
        bundle.putInt("cot",p.get(position).getSocot());
        bundle.putInt("phim",idPhim);
        k = gioChieu(this.khungtgchieus, idRap);
        GridLayoutManager gridLayout = new GridLayoutManager(context,3);
        holder.rChild.setLayoutManager(gridLayout);
        childlichchieu child = new childlichchieu(k, bundle, context);
        holder.rChild.setAdapter(child);
        boolean isExpand = p.get(position).isExpand();
        if (isExpand == false){
            holder.rChild.setVisibility(View.GONE);
            holder.img.setImageResource(R.drawable.down);
        }else {
            holder.rChild.setVisibility(View.VISIBLE);
            holder.img.setImageResource(R.drawable.up);
        }

    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ten;
        RecyclerView rChild;
        ImageView img;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.tieude);
            rChild = itemView.findViewById(R.id.rcchild);
            img = itemView.findViewById(R.id.updown);
            linearLayout = itemView.findViewById(R.id.linear);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rap raps = p.get(getAdapterPosition());
                    raps.setExpand(!raps.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
    public void filterl(LinkedList<rap> liches,LinkedList<khungtgchieu> ngayChieu){
        p.clear();
        p = liches;
        this.khungtgchieus = ngayChieu;
        notifyDataSetChanged();
    }
    public LinkedList<khungtgchieu> gioChieu(LinkedList<khungtgchieu> g1 , int rap) {
        LinkedList<khungtgchieu> g2 = new LinkedList<>();
        int i = 0;
        for (khungtgchieu tg:g1) {
            if (tg.getRap() == rap){
                if (i < g1.size()) {
                    g2.add(i, tg);
                    i++;
                }
            }
        }
        return g2;
    }


}
