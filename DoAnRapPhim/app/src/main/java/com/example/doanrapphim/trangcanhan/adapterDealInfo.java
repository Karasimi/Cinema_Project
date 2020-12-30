package com.example.doanrapphim.trangcanhan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;

public class adapterDealInfo extends RecyclerView.Adapter<adapterDealInfo.DealInfoViewHolder> {

    customer Customer = new customer();
    Context context;
    public adapterDealInfo(Context ct, customer Cus)
    {
        this.context = ct;
        this.Customer = Cus;
    }

    @NonNull
    @Override
    public DealInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_deal_info, parent, false);
        return new DealInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealInfoViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DealInfoViewHolder extends  RecyclerView.ViewHolder{

        TextView txtDealTitle, txtDealScript, txtDealDate, txtDealPrice;
        public DealInfoViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtDealTitle = itemView.findViewById(R.id.txtDealTitle);
            txtDealScript = itemView.findViewById(R.id.txtDealScript);
            txtDealDate = itemView.findViewById(R.id.txtDealDate);
            txtDealPrice = itemView.findViewById(R.id.txtDealPrice);
        }
    }
}
