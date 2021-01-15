package com.example.doanrapphim.lop;

import java.sql.Date;
import java.sql.Time;

public class lichchieu {
    private int thoigian;
    private int phim;
    private int rap;
    private boolean expan;

    public boolean isExpan() {
        return expan;
    }

    public void setExpan(boolean expan) {
        this.expan = expan;
    }

    public int getRap() {
        return rap;
    }

    public void setRap(int rap) {
        this.rap = rap;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public int getPhim() {
        return phim;
    }

    public void setPhim(int phim) {
        this.phim = phim;
    }
}
