package com.example.doanrapphim.AsysntaskLoader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class AsynTask extends AsyncTaskLoader<String> {
    private String url;
    private int phuongThuc;
    private String thamSo;

    public AsynTask(@NonNull Context context, String url, int phuongThuc, String thamSo) {
        super(context);
        this.url = url;
        this.phuongThuc = 1;
        this.thamSo = thamSo;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        if (phuongThuc == 1){
            return KetNoi_GET.getDL(this.url);
        }else {
            return null;
        }
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
