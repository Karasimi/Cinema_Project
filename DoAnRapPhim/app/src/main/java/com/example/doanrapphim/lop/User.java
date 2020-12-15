package com.example.doanrapphim.lop;

import android.text.TextUtils;
import android.util.Patterns;

public class User {
    private String email;
    private String password;
    public User(String gmail, String passord)
    {
        this.email = gmail;
        this.password = passord;
    }

    public String getEmail(String gmail) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.email);
        sb.append(this.password);
        return sb.toString();
    }
    public boolean isValidEmail() {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public boolean isValidPassword(){
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }
}
