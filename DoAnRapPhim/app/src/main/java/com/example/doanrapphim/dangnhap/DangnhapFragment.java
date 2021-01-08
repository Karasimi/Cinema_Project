package com.example.doanrapphim.dangnhap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_trangchu;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.ketnoi.Constant;
import com.example.doanrapphim.lop.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class DangnhapFragment extends Fragment {
    private EditText gmail, password;
    private TextView tvMassage;
    private Button btnlogin;
    //public LinkedList<User> listuser = new LinkedList<>();
    private ProgressDialog dialog;
    View view;
    public DangnhapFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_dangnhap, container, false);
        init();

        return view;
    }
    private void init(){
        gmail = view.findViewById(R.id.dangnhap_taikhoan);
        password = view.findViewById(R.id.dangnhap_matkhau);
        btnlogin = view.findViewById(R.id.btn_login);
        tvMassage = view.findViewById(R.id.tvmessage);
        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);

        btnlogin.setOnClickListener(v -> {
            if (validate()) {
                dangnhap();
            }
        });

    }



    private boolean validate(){
        if(gmail.getText().toString().isEmpty()){
            tvMassage.setText("Chưa nhập email");
            return false;
        }
        if(password.getText().toString().length()<6){
            tvMassage.setText("Chưa nhập password");
            return false;
        }
        return true;
    }

    private void dangnhap() {
        dialog.setMessage("Đang đăng nhâp");
        dialog.show();
        StringRequest request = new StringRequest(Request.Method.POST , Constant.DANGNHAP ,response -> {
            try {
                JSONObject jsonObject = new JSONObject(response);
                if(jsonObject.getBoolean("success")){
                    JSONObject user = jsonObject.getJSONObject("user");
                    SharedPreferences userPref = getActivity().getApplicationContext().getSharedPreferences("user",getContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = userPref.edit();
                    editor.putString("token", jsonObject.getString("token"));
                    editor.putString("name", user.getString("name"));
                    editor.apply();
                    //Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), activity_trangchu.class);
                    startActivity(intent);
                }

            }catch (JSONException e){
                e.printStackTrace();
            }
            dialog.dismiss();
        },error -> {
            error.printStackTrace();
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("email" , gmail.getText().toString().trim());
                map.put("password",password.getText().toString().trim());
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
    }
}


