package com.example.doanrapphim;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.AsysntaskLoader.AsynTask;
import com.example.doanrapphim.activity_chitiet.datghe;
import com.example.doanrapphim.activity_chitiet.tablich;
import com.example.doanrapphim.activity_chitiet.tabthongtin;
import com.example.doanrapphim.adapter.PagerAdapter;
import com.example.doanrapphim.lop.Phim;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class activity_chiTietPhim extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    static final int GET = 1;
    static final int POST = 2;
    static final int LOADERID = 111;
    static final int LOADERDIEM = 112;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    ImageView imageView,img;
    TextView txtTen, txtTl, txtTuoi, txtDv, txtDd, txtNd, txtDiem, txtThoiLuong;
    TextView txtChamDiem;
    ImageButton imageButton;
    TabLayout tabLayout;
    ViewPager viewPager;
    private Phim dsPhim = new Phim();
    LoaderManager loaderManager;
    RatingBar ratingBar;
    Button btn;
    int maPhim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phim);
        anhxa();
        //lay du lieu
        Bundle id = getIntent().getExtras();
         maPhim = id.getInt("id");
         Bundle ctPhim = new Bundle();
         ctPhim.putInt("phuongThuc",POST);
         ctPhim.putInt("maPhim",maPhim);
         LoaderManager.getInstance(this).initLoader(LOADERID,ctPhim,this);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chi Tiết Phim");
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        txtChamDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamDiem();
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_chiTietPhim.this,activity_youtube.class);
                intent.putExtra("key",dsPhim.getTrailer());
                startActivity(intent);
            }
        });
    }

    public void xuatThongtin() {
        txtTen.setText(dsPhim.getTenphim());
        txtTl.setText(dsPhim.getTheloai());
        txtTuoi.setText("C"+dsPhim.getTuoi());
        txtDiem.setText(String.valueOf(dsPhim.getDiem()));
        txtThoiLuong.setText(dsPhim.getThoiluong()+"Phút");
        imageView.setImageBitmap(chuyenAnh(dsPhim.getHinhanh()));
        img.setImageBitmap(chuyenAnh(dsPhim.getHinhanh()));
        guiDL(1);

    }

    private Bitmap chuyenAnh(String hinhanh) {
        byte[] anh = Base64.decode(hinhanh, Base64.DEFAULT);
        Bitmap decode = BitmapFactory.decodeByteArray(anh, 0, anh.length);
        return decode;
    }

    public void chamDiem() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.chamdiem);
        btn = dialog.findViewById(R.id.btnchamDiem);
        ratingBar  = dialog.findViewById(R.id.rating);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.ID != 0) {
                    int ratting = (int) ratingBar.getRating();
                    chamDiem(ratting);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), activity_dangnhap.class);
                    startActivity(intent);
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void chamDiem(int diem){
        Bundle dL = new Bundle();
        dL.putInt("maPhim",maPhim);
        dL.putInt("diem", diem);
        if (MainActivity.ID != 0){
            dL.putInt("khachhang",MainActivity.ID);
        }
        dL.putInt("phuongThuc", POST);
        if (loaderManager.getLoader(LOADERDIEM) == null) {
            loaderManager.initLoader(LOADERDIEM,dL,this);
        } else {
            loaderManager.restartLoader(LOADERDIEM, dL, this);
        }
    }

    public void anhxa() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        img = findViewById(R.id.imgbg);
        imageView = findViewById(R.id.img);
        txtTen = findViewById(R.id.tenphim);
        txtTl = findViewById(R.id.theloai);
        txtDiem = findViewById(R.id.diem);
        txtThoiLuong = findViewById(R.id.thoiluong);
        txtTuoi = findViewById(R.id.tuoi);
        txtChamDiem = findViewById(R.id.chamdiem);
        toolbar = findViewById(R.id.toolbar);
        imageButton = findViewById(R.id.btnplay);
    }

    public void guiDL(int i) {
        tablich lich = new tablich();
        tabthongtin t = new tabthongtin();
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        t.setArguments(bundle);
        lich.setArguments(bundle);
    }
    public void diem(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            txtDiem.setText(jsonObject.getInt("diem"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public Phim layPhim(String data) {
        Phim phim = new Phim();
        try {
            JSONObject f = new JSONObject(data);
            JSONObject jb = f.getJSONObject("phim");
            JSONObject jc = f.getJSONObject("diem");
            phim.setTenphim(jb.getString("tenphim"));
            phim.setHinhanh(jb.getString("hinhanh"));
            phim.setTheloai(jb.getString("theloai"));
            phim.setTuoi(jb.getString("dotuoi"));
            phim.setThoiluong(jb.getString("thoiluong"));
            phim.setId(jb.getInt("id"));
            phim.setTrangthai(jb.getInt("trangthai"));
            phim.setDiem(jc.getInt("diem"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return phim;
    }
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        if (args != null && id == LOADERID) {
            String url = "http://192.168.43.83/DatVePhim/public/api/api/phim";
            String thamSo = "id="+args.getInt("maPhim");
            return new AsynTask(this, url, args.getInt("phuongThuc"), thamSo);
        } else{
            if (args != null && id == LOADERDIEM) {
                String url = "http://192.168.43.83/DatVePhim/public/api/api/chamdiem";
                String thamSo = "phim=" + args.getInt("phim")+"&diem="+args.getInt("diem")+"&khachhang="+args.getInt("khachhang");
                return new AsynTask(this, url, args.getInt("phuongThuc"), thamSo);
            }
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (loader.getId() == LOADERID && data != null) {
            dsPhim = layPhim(data);
            xuatThongtin();
        }else {
            if (loader.getId() == LOADERDIEM && data != null) {
                Log.d("diem",data);
                diem(data);
            }
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}