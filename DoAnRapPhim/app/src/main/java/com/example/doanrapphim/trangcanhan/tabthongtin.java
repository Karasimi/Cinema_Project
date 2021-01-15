package com.example.doanrapphim.trangcanhan;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.MainActivity;
import com.example.doanrapphim.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class tabthongtin extends Fragment {

    private static final int RESULT_OK = 1 ;
    private EditText name, phone, email, diachi;
    private TextView txt_thongbao;
    private ImageButton anh;
    private Button button;
    private static  final  int G = 1;
    private Bitmap bitmap = null;
    private int maKH;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabthongtin2, container, false);
        maKH = MainActivity.ID;
        init(view);
        loadThongTin();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capNhat();
            }
        });
        return view;
    }
    private void init(View view){
        name = view.findViewById(R.id.edithoten);
        phone = view.findViewById(R.id.editsdt);
        diachi = view.findViewById(R.id.editdiachi);
        email = view.findViewById(R.id.editemail);
        button = view.findViewById(R.id.btnluu);
        loadThongTin();
    }


    private void loadThongTin() {
        String url ="http://192.168.43.83/DatVePhim/public/api/api/ttcanhan";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getString("email") != null){
                        email.setText(jsonObject.getString("email"));
                    }
                    if (jsonObject.getString("sdt") != null){
                        phone.setText(jsonObject.getString("sdt"));
                    }
                    if (jsonObject.getString("name") != null){
                        name.setText(jsonObject.getString("name"));
                    }
                    if (jsonObject.getString("diachi") != null){
                        diachi.setText(jsonObject.getString("diachi"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("khachhang" , String.valueOf(maKH));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
    private void capNhat() {
        String ten = name.getText().toString().trim();
        String sdt = phone.getText().toString().trim();
        String dc = diachi.getText().toString().trim();
        String e = email.getText().toString().trim();
        String url ="http://192.168.43.83/DatVePhim/public/api/api/capnhatcanhan";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getString("email") != null){
                        email.setText(jsonObject.getString("email"));
                    }
                    if (jsonObject.getString("sdt") != null){
                        phone.setText(jsonObject.getString("sdt"));
                    }
                    if (jsonObject.getString("name") != null){
                        name.setText(jsonObject.getString("name"));
                    }
                    if (jsonObject.getString("diachi") != null){
                        diachi.setText(jsonObject.getString("diachi"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("khachhang" , String.valueOf(maKH));
                map.put("name" , ten);
                map.put("diachi" , dc);
                map.put("email" , e);
                map.put("phone" , sdt);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

}
