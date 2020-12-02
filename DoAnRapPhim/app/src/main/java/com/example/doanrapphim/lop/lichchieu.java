package com.example.doanrapphim.lop;

import java.sql.Date;
import java.sql.Time;

public class lichchieu {
    private int id;
    private String ngaychieu;
    private String giochieu;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgaychieu() {
        return ngaychieu;
    }

    public void setNgaychieu(String ngaychieu) {
        this.ngaychieu = ngaychieu;
    }

    public String getGiochieu() {
        return giochieu;
    }

    public void setGiochieu(String giochieu) {
        this.giochieu = giochieu;
    }

    public int getPhim() {
        return phim;
    }

    public void setPhim(int phim) {
        this.phim = phim;
    }
}
