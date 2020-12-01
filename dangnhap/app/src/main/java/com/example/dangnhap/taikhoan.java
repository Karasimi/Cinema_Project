package com.example.dangnhap;

public class taikhoan {
    private String gmail;
    private String password;


    public String getGmail(String gmail) {
        return this.gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String ToString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.gmail);
        sb.append(this.password);
        return  sb.toString();
    }
}
