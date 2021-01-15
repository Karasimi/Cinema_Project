package com.example.doanrapphim.lop;

import java.util.LinkedList;

public class ghe {
    private int id;
    private String cot;
    private String hang;
    private int rap;
    private int loai;
    private int trangthai;

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    private boolean dat;

    public boolean isDat() {
        return dat;
    }
    public void setDat(boolean dat) {
        this.dat = dat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCot() {
        return cot;
    }

    public void setCot(String cot) {
        this.cot = cot;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getRap() {
        return rap;
    }

    public void setRap(int rap) {
        this.rap = rap;
    }
}
