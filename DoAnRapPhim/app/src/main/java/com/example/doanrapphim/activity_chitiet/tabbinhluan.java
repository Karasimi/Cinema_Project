package com.example.doanrapphim.activity_chitiet;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.doanrapphim.AsysntaskLoader.AsynTask;
import com.example.doanrapphim.AsysntaskLoader.AsynTask_DatVe;
import com.example.doanrapphim.MainActivity;
import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_dangnhap;
import com.example.doanrapphim.adapter.AdapterBinhLuan;
import com.example.doanrapphim.lop.BinhLuan;
import com.example.doanrapphim.lop.gia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class tabbinhluan extends Fragment implements LoaderManager.LoaderCallbacks<String> {
    static final int GET = 1;
    static final int POST = 2;
    static final int LOADERBL = 111;
    static final int BINHLUAN = 112;
    RecyclerView recyclerView;
    EditText editText;
    Button button;
    LoaderManager loaderManager;
    LinkedList<BinhLuan> binhLuans;
    public  int maKH;
    public  int maP;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_tabbinhluan, container, false);
        recyclerView = view.findViewById(R.id.rcbinhluan);
        Bundle bundle1 = getActivity().getIntent().getExtras();
        maP = bundle1.getInt("id");
        maKH = MainActivity.ID;
        editText = view.findViewById(R.id.txtnoidung);
        button = view.findViewById(R.id.btngui);
        Bundle b = new Bundle();
        b.putInt("phuongThuc",POST);
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(LOADERBL, b, this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nd = editText.getText().toString().trim();
                if (nd != null){
                    binhLuan(nd);
                }

            }
        });
        return view;
    }
    public void binhLuan(String s){
        Bundle b = new Bundle();
        if (maKH != 0) {
            b.putInt("phuongThuc", POST);
            b.putInt("khachhang", maKH);
            b.putInt("phim", maP);
            b.putString("noidung", s);
            if (loaderManager.getLoader(BINHLUAN) == null) {
                loaderManager.initLoader(BINHLUAN, b, this);
            } else {
                loaderManager.restartLoader(BINHLUAN, b, this);
            }
        }else {
            Intent intent = new Intent(getContext(), activity_dangnhap.class);
            startActivity(intent);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == LOADERBL && args != null) {
            String url = "http://192.168.43.83/DatVePhim/public/api/api/bl";
            String thamSo = "phim="+maP;
            return new AsynTask(getContext(), url, args.getInt("phuongThuc"), thamSo);
        }else {
            if (id == BINHLUAN && args != null) {
                String url = "http://192.168.43.83/DatVePhim/public/api/api/binhluan";
                String thamSo = "phim="+args.getInt("phim")+"&khachhang="+args.getInt("khachhang")+"&noidung="+args.getString("noidung");
                return new AsynTask(getContext(), url, args.getInt("phuongThuc"), thamSo);
            }
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (loader.getId() == LOADERBL || loader.getId() == BINHLUAN && data != null) {
            binhLuans = dsBinhLuan(data);
            AdapterBinhLuan adapterBinhLuan = new AdapterBinhLuan(binhLuans, getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapterBinhLuan);
        }else {
            return;
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
    private LinkedList<BinhLuan> dsBinhLuan(String data) {
        LinkedList<BinhLuan> b = new LinkedList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                {
                    BinhLuan binhLuan = new BinhLuan();
                    if (jsonArray.getJSONObject(i).getString("khachhang") == null){
                        binhLuan.setKhachhang(jsonArray.getJSONObject(i).getString("email"));
                    }else {
                        binhLuan.setKhachhang(jsonArray.getJSONObject(i).getString("khachhang"));
                    }
                    binhLuan.setNoidung(jsonArray.getJSONObject(i).getString("noidung"));
                    binhLuan.setPhim(jsonArray.getJSONObject(i).getInt("phim"));
                    binhLuan.setTrangthai(jsonArray.getJSONObject(i).getInt("trangthai"));
                        b.add(i, binhLuan);
                    }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return b;
    }

}