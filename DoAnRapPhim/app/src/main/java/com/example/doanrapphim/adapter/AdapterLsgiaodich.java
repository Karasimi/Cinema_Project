package com.example.doanrapphim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.itf.OnItemClickListener;
import com.example.doanrapphim.lop.Dsve;
import com.example.doanrapphim.lop.lich;

import java.util.LinkedList;

public class AdapterLsgiaodich extends RecyclerView.Adapter<AdapterLsgiaodich.WordViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<Dsve> p = new LinkedList<>();
    Context context;
    int f =0;
    public AdapterLsgiaodich(LinkedList<Dsve> p, Context context) {
        this.p = p;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.layoutdsve,
                parent, false);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.t1.setText(p.get(position).getKhachhang());
        holder.t2.setText(p.get(position).getSoluong());
        holder.t3.setText(p.get(position).getNgaymua());

    }
    @Override
    public int getItemCount() {
        return p.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public WordViewHolder(View itemView, AdapterLsgiaodich adapter) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tvkh);
            t2 = itemView.findViewById(R.id.tvsl);
            t3 = itemView.findViewById(R.id.tvngay);
        }

    }
}
