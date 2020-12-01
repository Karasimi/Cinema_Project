package com.example.dangnhap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;


public class DangnhapFragment extends Fragment {
    private EditText gmail, password;
    private TextView tvMassage;
    private Button btnlogin;
    private Button btndangky;
    public LinkedList<User> listuser = new LinkedList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dangnhap, container, false);
        gmail = view.findViewById(R.id.dangnhap_taikhoan);
        password = view.findViewById(R.id.dangnhap_matkhau);
        btnlogin = view.findViewById(R.id.btn_login);
        tvMassage = view.findViewById(R.id.tvmessage);
        btndangky = view.findViewById(R.id.dangnhap_dangky);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laydulieu();
            }
        });
        return view;
    }


    //private void clickLogin () {
    //String mEmail = gmail.getText().toString().trim();
    //String mpassword = password.getText().toString().trim();
    //User user = new User(mEmail, mpassword);
    //tvMassage.setVisibility(View.VISIBLE);
    //if (user.isValidPassword() && user.isValidEmail()) {
    //if (mEmail.equals(a) && mpassword.equals(b)) {
    //Intent intent = new Intent(getActivity(), Trangcanhan.class);
    //startActivity(intent);
    //}
    public void laydulieu() {
        String mEmail = gmail.getText().toString().trim();
        String mpassword = password.getText().toString().trim();
        int tinh = 0;
        String d = null;
        d = new ReadJSONExample().readText(getContext() , R.raw.taikhoan );
        try {
            JSONObject jsonroot = new JSONObject(d);
            JSONArray jsonArray = jsonroot.getJSONArray("ds");
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                String a = jsonArray.getJSONObject(i).getString("gmail");
                String b = jsonArray.getJSONObject(i).getString("password");
                if (mEmail.equals(a)) {
                    if (mpassword.equals(b)) {
                        tinh++;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (tinh == 1) {
            User user = new User(mEmail, mpassword);
            tvMassage.setVisibility(View.VISIBLE);
            if (user.isValidPassword() && user.isValidEmail()) {
                tvMassage.setText("Login success");
                tvMassage.setTextColor(getResources().getColor(R.color.colorAccent));
            }else{
                tvMassage.setText("Email or ");
            }
        }else{
            tvMassage.setText("Nhap sai ten tai khoan mat khau!!");
        }
    }
}


