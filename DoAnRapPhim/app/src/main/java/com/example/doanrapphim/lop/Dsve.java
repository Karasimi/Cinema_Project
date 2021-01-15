package com.example.doanrapphim.lop;

import java.util.Date;

public class Dsve {
    private int id;
    private String khachhang;

    public void setKhachhang(String khachhang) {
        this.khachhang = khachhang;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKhachhang() {
        return khachhang;
    }



    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    private int soluong;
    private String ngaymua;
}
