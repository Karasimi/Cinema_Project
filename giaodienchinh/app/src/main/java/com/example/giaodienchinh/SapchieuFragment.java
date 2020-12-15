package com.example.giaodienchinh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;


public class SapchieuFragment extends Fragment {

    ViewPager2 viewPager2;
    LinkedList<Phim> p = new LinkedList<>();
    String d ="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {//view tra ve
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sapchieu, container, false);
        anhXa(view);
        layDsPhim();
        Adapterdsphim adapterdsphim = new Adapterdsphim(p,getContext());
        viewPager2.setAdapter(adapterdsphim);
        return  view;
    }
    public  void anhXa(View view){
        viewPager2 = view.findViewById(R.id.pager1);
    }
    private void layDsPhim() {
        d = new adapterjson().read(getContext(), R.raw.data);
        JSONObject jsonRoot = null;
        JSONArray jsonArray;
        int l;
        try {
            jsonRoot = new JSONObject(d);
            jsonArray = jsonRoot.getJSONArray("phim");
            l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                Phim phim = new Phim();
                phim.setTenphim(jsonArray.getJSONObject(i).getString("tenphim"));
                phim.setHinhanh(jsonArray.getJSONObject(i).getString("hinhanh"));
                phim.setTheloai(jsonArray.getJSONObject(i).getString("theloai"));
                phim.setDaodien(jsonArray.getJSONObject(i).getString("daodien"));
                phim.setId(jsonArray.getJSONObject(i).getInt("maphim"));
                phim.setTrangthai(jsonArray.getJSONObject(i).getInt("trangthai"));
                p.add(i, phim);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}