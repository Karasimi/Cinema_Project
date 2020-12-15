package com.example.doanrapphim.dangnhap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_trangchu;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.lop.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;


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
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangkyFragment dangkyFragment = new DangkyFragment();
                getFragmentManager().beginTransaction().replace(R.id.view_page,dangkyFragment).commit();
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
        d = new adapterjson().read(getContext() , R.raw.data );
        try {
            JSONObject jsonroot = new JSONObject(d);
            JSONArray jsonArray = jsonroot.getJSONArray("tk");
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
                Intent intent = new Intent(getActivity(), activity_trangchu.class);
                startActivity(intent);
            }else{
                tvMassage.setText("Email or ");
            }
        }else{
            tvMassage.setText("Nhap sai ten tai khoan mat khau!!");
        }
    }
}


