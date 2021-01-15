package com.example.doanrapphim;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanrapphim.AsysntaskLoader.AsynTask;
import com.example.doanrapphim.AsysntaskLoader.AsynTask_DatVe;
import com.example.doanrapphim.activity_chitiet.datghe;
import com.example.doanrapphim.lop.Phim;
import com.example.doanrapphim.lop.ghe;
import com.example.doanrapphim.lop.gia;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.LinkedList;

public class activity_thanhtoan extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    TextView txtPhim, txtNgayChieu, txtGia, txtGiocieu, txtrap, txtGhe;
    ImageView img;
    Button button;
    static final int LOADER = 111;
    static final int DATGHE = 112;
    static final int POST = 2;
    LoaderManager loaderManager;
    Bundle bundle;
    String dataGhe;
    Double aDouble;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanhtoan);
        anhXa();
        img.setImageResource(R.drawable.c);
         bundle = getIntent().getExtras().getBundle("ve");
        bundle.putInt("phuongThuc",POST);
        dataGhe = bundle.getString("gheDat");
        aDouble = bundle.getDouble("tongTien");
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(LOADER, bundle, this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datGhe();
            }
        });


    }public void datGhe(){
        if (loaderManager.getLoader(DATGHE) == null) {
            loaderManager.initLoader(DATGHE,bundle,this);
        } else {
            loaderManager.restartLoader(DATGHE, bundle, this);
        }
    }
    public void anhXa(){
        txtPhim = findViewById(R.id.tv_tenPhim);
        txtNgayChieu = findViewById(R.id.tv_ngaychieu);
        txtGiocieu = findViewById(R.id.tv_gioichieu);
        txtGia = findViewById(R.id.tongTien);
        txtrap = findViewById(R.id.tv_tenrap);
        txtGhe = findViewById(R.id.tv_ghe);
        img = findViewById(R.id.imgbg);
        button = findViewById(R.id.btn_thanhtoan);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == LOADER && args != null) {
            String url = "http://192.168.43.83/DatVePhim/public/api/api/thanhtoan";
            String thamSo = "phim=" + args.getInt("maPhim")+"&rap=" + args.getInt("maRap")+"&thoigian=" + args.getInt("maTG");
            return new AsynTask(this, url, args.getInt("phuongThuc"), thamSo);
        }else {
            if (id == DATGHE && args != null){
                String url = "http://192.168.43.83/DatVePhim/public/api/api/datve";
                return new AsynTask_DatVe(this, url, args.getString("gheDat"), args.getInt("maPhim"), args.getInt("maRap"), args.getInt("maTG"));
            }else {
                return null;
            }
        }
    }
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (data != null && loader.getId() == LOADER) {
           setNoiDung(data);
        }else {
            if (data != null && loader.getId() == DATGHE){
                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.thanhcong);
                Button button = dialog.findViewById(R.id.btnok);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity_thanhtoan.this, activity_dsPhim.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }else {

            }
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
    public void setNoiDung(String data){
        tongCong();
        try {
            JSONObject jb = new JSONObject(data);
            txtPhim.setText(jb.getString("tenphim"));
            txtrap.setText(jb.getString("tenrap"));
            txtNgayChieu.setText(jb.getString("ngaychieu"));
            txtGiocieu.setText(jb.getInt("giochieu"));
            img.setImageBitmap(chuyenAnh((jb.getString("hinhanh"))));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String layGhe(String d){
        String ghe = "";
        try {
            JSONArray jsonArray = new JSONArray(d);
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ghe = ghe + jsonObject.getString("hang")+jsonObject.getString("cot")+" ";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ghe;
    }
    public void tongCong(){
        txtGhe.setText(layGhe(dataGhe));
        txtGia.setText(aDouble+" VNĐ");
    }
    private Bitmap chuyenAnh(String hinhanh) {
            byte[] anh = Base64.decode(hinhanh, Base64.DEFAULT);
            Bitmap decode = BitmapFactory.decodeByteArray(anh, 0, anh.length);
            return decode;

    }

}