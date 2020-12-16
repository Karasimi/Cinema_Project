package com.example.doanrapphim.activity_chitiet;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.AdapterDatGhe;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.lop.ghe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class datghe extends AppCompatActivity {
    RecyclerView recyclerView;
    LinkedList<ghe> ghes = new LinkedList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_datghe);
        recyclerView = findViewById(R.id.rclview);
        layDsGhe();
        AdapterDatGhe adapterDatGhe = new AdapterDatGhe(ghes,this);
        GridLayoutManager gridLayout = new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(gridLayout);
        recyclerView.setAdapter(adapterDatGhe);
    }
    private void layDsGhe() {
        String d = new adapterjson().read(this, R.raw.data);
        //Bundle bundle = getActivity().getIntent().getExtras();
       // int maPhim = bundle.getInt("id");
        try {
            JSONObject jsonRoot = new JSONObject(d);
            JSONArray jsonArray = jsonRoot.getJSONArray("ghe");
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
               {
                   ghe g = new ghe();
                   g.setId(jsonArray.getJSONObject(i).getInt("id"));
                    g.setHang(jsonArray.getJSONObject(i).getString("hang"));
                    g.setCot(jsonArray.getJSONObject(i).getInt("cot"));
                    g.setRap(jsonArray.getJSONObject(i).getInt("rap"));
                    ghes.add(i,g);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
