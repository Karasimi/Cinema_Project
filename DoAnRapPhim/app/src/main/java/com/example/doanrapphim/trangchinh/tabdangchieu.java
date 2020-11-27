package com.example.doanrapphim.trangchinh;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.adapter.adaptertopphim;
import com.example.doanrapphim.adapter.listadapter;
import com.example.doanrapphim.lop.Phim;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class tabdangchieu extends Fragment {

    ViewPager2 viewPager2;
    private final LinkedList<Phim> listPhim = new LinkedList<>();
    String d = "";
    private JSONObject jsonRoot = null;
    private JSONArray jsonArray;
    int l;
    adaptertopphim m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabdangchieu, container, false);
        layDsPhim();
        m = new adaptertopphim(top5(listPhim), getContext());
        viewPager2 = view.findViewById(R.id.vp);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPager2.setAdapter(m);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(8));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float v = 1 - Math.abs(position);
                page.setScaleY(0.8f + v * 0.2f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        return view;
    }

    private void layDsPhim() {
        d = new adapterjson().read(getContext(), R.raw.data);
        try {
            jsonRoot = new JSONObject(d);
            jsonArray = jsonRoot.getJSONArray("phim");
            l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                Phim phim = new Phim();
                phim.setTenphim(jsonArray.getJSONObject(i).getString("tenphim"));
                phim.setHinhanh(jsonArray.getJSONObject(i).getString("hinhanh"));
                phim.setTheloai(jsonArray.getJSONObject(i).getString("theloai"));
                phim.setId(jsonArray.getJSONObject(i).getInt("maphim"));
                phim.setTrangthai(jsonArray.getJSONObject(i).getInt("trangthai"));
                listPhim.add(i, phim);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private LinkedList<Phim> top5(LinkedList<Phim> a) {
        LinkedList<Phim> topPhim = new LinkedList<>();
        int i = 0;
            for (Phim s : a) {
                if(i < 5) {
                if (s.getTrangthai() == 1) {
                    topPhim.add(s);
                    i++;
                }
            }
        }
        return topPhim;
    }
}