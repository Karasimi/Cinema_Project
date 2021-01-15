package com.example.doanrapphim.trangcanhan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.MainActivity;
import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.AdapterLsgiaodich;
import com.example.doanrapphim.lop.Dsve;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class tabgiaodich extends Fragment {
    public int maKH = 0;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_tabgiaodich, container, false);
        maKH = MainActivity.ID;
        loadThongTin(view);
        return view;
    }
    private void loadThongTin(View view) {
        String url ="http://192.168.43.83/DatVePhim/public/api/api/lsgiaodich";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LinkedList<Dsve> dsves = new LinkedList<>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i=0; i<jsonArray.length();i++) {
                        Dsve dsve = new Dsve();
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        dsve.setId(jsonObject.getInt("id"));
                        dsve.setKhachhang(jsonObject.getString("khachhang"));
                        dsve.setNgaymua(jsonObject.getString("ngaymua"));
                        dsve.setSoluong(jsonObject.getInt("soluong"));
                        dsves.add(i, dsve);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                recyclerView = view.findViewById(R.id.rcler);
//                AdapterLsgiaodich adapterLsgiaodich = new AdapterLsgiaodich(dsves, getContext());
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                recyclerView.setAdapter(adapterLsgiaodich);

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
}