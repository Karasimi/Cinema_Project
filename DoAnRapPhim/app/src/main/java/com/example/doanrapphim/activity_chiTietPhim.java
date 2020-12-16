package com.example.doanrapphim;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.doanrapphim.activity_chitiet.tabthongtin;
import com.example.doanrapphim.adapter.PagerAdapter;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.lop.Phim;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class activity_chiTietPhim extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    Phim phim = new Phim();
    Toolbar toolbar;
    ImageView imageView,img;
    TextView txtTen, txtTl, txtTuoi, txtDv, txtDd, txtNd, txtDiem;
    TextView txtChamDiem;
    ImageButton imageButton;
    TabLayout tabLayout;
    TabItem lichchieu, thongtin, binhluan;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phim);
        anhxa();
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chi Tiết Phim");
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
       viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //lay du lieu
        anhxa();
       layDsPhim();
        xuatThongtin();
        txtChamDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamDiem();
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_chiTietPhim.this,MainActivity.class);
                intent.putExtra("key",phim.getTrailer());
                startActivity(intent);
            }
        });
    }

    private void layDsPhim() {
        Bundle bundle = getIntent().getExtras();
        int maPhim = bundle.getInt("id");
        guiDL(maPhim);
        String d = new adapterjson().read(this, R.raw.data);
        try {
            JSONObject jsonRoot = new JSONObject(d);
            JSONArray jsonArray = jsonRoot.getJSONArray("phim");
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                if (jsonArray.getJSONObject(i).getInt("maphim") == maPhim) {
                    phim.setTenphim(jsonArray.getJSONObject(i).getString("tenphim"));
                    phim.setHinhanh(jsonArray.getJSONObject(i).getString("hinhanh"));
                    phim.setTheloai(jsonArray.getJSONObject(i).getString("theloai"));
                    phim.setDiem(jsonArray.getJSONObject(i).getInt("diem"));
                    phim.setTuoi(jsonArray.getJSONObject(i).getString("tuoi"));
                    phim.setDaodien(jsonArray.getJSONObject(i).getString("daodien"));
                    phim.setDienvien(jsonArray.getJSONObject(i).getString("dienvien"));
                    phim.setNoidung(jsonArray.getJSONObject(i).getString("noidung"));
                    phim.setTrailer(jsonArray.getJSONObject(i).getString("trailer"));
                    phim.setTrangthai(jsonArray.getJSONObject(i).getInt("trangthai"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void xuatThongtin() {
//       txtTen.setText(phim.getTenphim());
        txtTl.setText(phim.getTheloai());
        txtTuoi.setText(phim.getTuoi());
        txtDiem.setText(String.valueOf(phim.getDiem()));
        int hinhAnh = this.getDrawableResIdByName(phim.getHinhanh());
        imageView.setImageResource(hinhAnh);
        img.setBackgroundResource(hinhAnh);
    }

    public int getDrawableResIdByName(String tenHinh) {
        String ct = this.getPackageName();
        int resID = this.getResources().getIdentifier(tenHinh, "drawable", ct);
        return resID;
    }

    public void chamDiem() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.chamdiem);
        dialog.show();
    }

    public void anhxa() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        img = findViewById(R.id.imgbg);
        imageView = findViewById(R.id.img);
       // txtTen = findViewById(R.id.tenphim);
        txtTl = findViewById(R.id.theloai);
        txtDiem = findViewById(R.id.diem);
        txtTuoi = findViewById(R.id.tuoi);
        txtChamDiem = findViewById(R.id.chamdiem);
        toolbar = findViewById(R.id.toolbar);
        imageButton = findViewById(R.id.btnplay);
    }

    public void guiDL(int i) {
        tabthongtin t = new tabthongtin();
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        t.setArguments(bundle);
    }

}