package com.example.doanrapphim.activity_chitiet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.AsysntaskLoader.AsynTask;
import com.example.doanrapphim.AsysntaskLoader.AsynTask_DatVe;
import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_thanhtoan;
import com.example.doanrapphim.adapter.AdapterDatGhe;
import com.example.doanrapphim.itf.OnItemClickListener;
import com.example.doanrapphim.itf.tongSoTien;
import com.example.doanrapphim.lop.ghe;
import com.example.doanrapphim.lop.gia;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class datghe extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    static final int GET = 1;
    static final int POST = 2;
    static final int LOADERGHE = 111;
    static final int DATGHE = 112;
    RecyclerView recyclerView;
    TextView txt1;
    TextView txt2;
     TextView txtTongCong;
     tongSoTien clickListener;
     public  double tongCong = 0.0;
    LinkedList<ghe> g = new LinkedList<>();
    LinkedList<ghe> ghes = new LinkedList<>();
    LinkedList<gia> gias = new LinkedList<>();
    int maP;
    int maR;
    int maTG;
    int socot;
    Button btn,btnback;
    LoaderManager loaderManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_datghe);
        btn = findViewById(R.id.btndatve);
        btnback = findViewById(R.id.btnquaylai);
        txt1 = findViewById(R.id.txtgialoai1);
        txt2 = findViewById(R.id.txtgialoai2);
        txtTongCong = findViewById(R.id.txttong);
        toolbar();
        recyclerView = findViewById(R.id.rclview);
        clickListener = new tongSoTien() {
            @Override
            public void tongSoTien(double tien) {
                tongCong = tien;
                txtTongCong.setText(tongCong + " VNĐ");

            }
        };
        Bundle bundle = getIntent().getExtras().getBundle("datve");
        if (bundle != null) {
            maP = bundle.getInt("phim");
            maR = bundle.getInt("rap");
            maTG = bundle.getInt("thoigian");
            socot = bundle.getInt("cot");
        }
        Bundle b = new Bundle();
        b.putInt("phuongThuc",POST);
        b.putInt("rap",maR);
        b.putInt("thoigian",maTG);
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(LOADERGHE, b, this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datGhe();

            }
        });

    }

    private void toolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar == null) return;

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }
    public void setGia(LinkedList<gia> a){
        if(a != null) {
            for (gia f : a) {
                if (f.getLoaighe() == 1) {
                    txt1.setText(f.getGia() + " VNĐ");
                } else {
                    if (f.getLoaighe() == 2) {
                        txt2.setText(f.getGia() + " VNĐ");
                    }
                }

            }
        }
    }
    private LinkedList<ghe> layDsGhe(String data) {
        LinkedList<ghe> gh = new LinkedList<>();
        try {
            JSONObject jo = new JSONObject(data);
            JSONArray jsonArray = jo.getJSONArray("ghe");
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
               {
                   ghe g = new ghe();
                    g.setId(jsonArray.getJSONObject(i).getInt("id"));
                    g.setHang(jsonArray.getJSONObject(i).getString("hang"));
                    g.setCot(jsonArray.getJSONObject(i).getString("cot"));
                    g.setLoai(jsonArray.getJSONObject(i).getInt("loaighe"));
                    g.setRap(jsonArray.getJSONObject(i).getInt("rap"));
                   g.setTrangthai(jsonArray.getJSONObject(i).getInt("trangthai"));
                   gh.add(i,g);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gh;
    }
    private LinkedList<gia> layDsGia(String data) {
        LinkedList<gia> gh = new LinkedList<>();
        try {
            JSONObject jo = new JSONObject(data);
            JSONArray jsonArray = jo.getJSONArray("gia");
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                {
                    gia g = new gia();
                    if (jsonArray.getJSONObject(i).getInt("phim") == maP) {
                        g.setId(jsonArray.getJSONObject(i).getInt("id"));
                        g.setPhim(jsonArray.getJSONObject(i).getInt("phim"));
                        g.setLoaighe(jsonArray.getJSONObject(i).getInt("loaighe"));
                        g.setGia(jsonArray.getJSONObject(i).getDouble("gia"));
                        gh.add(i, g);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gh;
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == LOADERGHE && args != null) {
            String url = "http://192.168.43.83/DatVePhim/public/api/api/ghe";
            String thamSo = "rap="+args.getInt("rap")+"&thoigian="+args.getInt("thoigian");

            return new AsynTask(this, url, args.getInt("phuongThuc"), thamSo);
        }else {
            if (id == DATGHE && args != null){
                String url = "http://192.168.43.83/DatVePhim/public/api/api/datve";
                return new AsynTask_DatVe(this, url, args.getString("ghedat"), args.getInt("maPhim"), args.getInt("maRap"), args.getInt("maTG"));
            }
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (data != null && loader.getId() == LOADERGHE){
            ghes = layDsGhe(data);
            Log.d("ghe",data);
            gias = layDsGia(data);
            setGia(gias);
            AdapterDatGhe adapterDatGhe = new AdapterDatGhe(ghes,this, gias, clickListener);
            GridLayoutManager gridLayout = new GridLayoutManager(this,socot);
            recyclerView.setLayoutManager(gridLayout);
            recyclerView.setAdapter(adapterDatGhe);
        } else {
            if (data != null && loader.getId() == DATGHE){
                Toast.makeText(this, "Đặt Thành Công", Toast.LENGTH_SHORT).show();
            }else {

            }
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
    public void datGhe(){
        g = layGhe(ghes);
        Gson json = new Gson();
        String gheDat = json.toJson(g);
        Bundle dL = new Bundle();
        dL.putInt("maPhim",maP);
        dL.putInt("maRap", maR);
        dL.putInt("maTG", maTG);
        dL.putString("gheDat", gheDat);
        dL.putDouble("tongTien",tongCong);
        Intent intent = new Intent(datghe.this, activity_thanhtoan.class);
        intent.putExtra("ve",dL);
        startActivity(intent);
//        if (loaderManager.getLoader(DATGHE) == null) {
//            loaderManager.initLoader(DATGHE,dL,this);
//        } else {
//            loaderManager.restartLoader(DATGHE, dL, this);
//        }
    }
    public LinkedList<ghe> layGhe(LinkedList<ghe> ghes){
        LinkedList<ghe> g = new LinkedList<>();
        for (ghe f:ghes) {
            if (f.isDat() == true){
                g.add(f);
            }
        }
        return g;
    }
}
