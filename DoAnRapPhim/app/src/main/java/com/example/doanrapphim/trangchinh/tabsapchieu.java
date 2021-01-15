package com.example.doanrapphim.trangchinh;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.adapter.adaptertopphim;
import com.example.doanrapphim.adapter.listadapter;
import com.example.doanrapphim.lop.Phim;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class tabsapchieu extends Fragment {

    ViewPager2 viewPager2;
    private final LinkedList<Phim> listPhim = new LinkedList<>();
    String d = "";
    private JSONObject jsonRoot = null;
    private JSONArray jsonArray;
    int l;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabsapchieu, container, false);
       loadPhim(view);
        return view;
    }
    private  void  loadPhim(View view){
        String url ="http://192.168.43.83/DatVePhim/public/api/api/phim";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    l = jsonArray.length();
                    for (int i = 0; i < l; i++) {
                        Phim phim = new Phim();
                        phim.setTenphim(jsonArray.getJSONObject(i).getString("tenphim"));
                        phim.setHinhanh(jsonArray.getJSONObject(i).getString("hinhanh"));
                        phim.setTheloai(jsonArray.getJSONObject(i).getString("theloai"));
                        phim.setId(jsonArray.getJSONObject(i).getInt("id"));
                        phim.setTrangthai(jsonArray.getJSONObject(i).getInt("trangthai"));
                        listPhim.add(i, phim);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adaptertopphim m = new adaptertopphim(top5(listPhim),getContext());
                viewPager2 =view.findViewById(R.id.vp1);
                viewPager2.setAdapter(m);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
    private LinkedList<Phim> top5(LinkedList<Phim> a) {
        LinkedList<Phim> topPhim = new LinkedList<>();
        int i = 0;
        for (Phim s : a) {
            if(i < 5) {
                if (s.getTrangthai() == 2) {
                    topPhim.add(s);
                    i++;
                }
            }
        }
        return topPhim;
    }
}