package com.example.doanrapphim.activity_chitiet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.AsysntaskLoader.AsynTask;
import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.lop.Phim;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;

public class tabthongtin extends Fragment implements LoaderManager.LoaderCallbacks<String> {
    TextView t1,t2,t3;
    static final int LOADER = 111;
    static final int POST = 2;
    LoaderManager loaderManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabthongtin, container, false);
        anhXa(view);
        Bundle bundle = getActivity().getIntent().getExtras();
        int maPhim = bundle.getInt("id");
        Bundle bundle1 = new Bundle();
        bundle1.putInt("phuongThuc",POST);
        bundle1.putInt("id",maPhim);
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(LOADER, bundle1, this);
        return view;
    }
    public void anhXa(View view){
      t1 = view.findViewById(R.id.noidung);
      t2 = view.findViewById(R.id.daodien);
      t3 = view.findViewById(R.id.dienvien);
    }
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == LOADER && args != null) {
            String url = "http://192.168.43.83/DatVePhim/public/api/api/phim";
            String thamSo = "id=" + args.getInt("id");
            return new AsynTask(getContext(), url, args.getInt("phuongThuc"), thamSo);
        }else {
            return null;
        }
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (data != null && loader.getId() == LOADER){
            try {
                JSONObject jc = new JSONObject(data);
                JSONObject jb = jc.getJSONObject("phim");
                t1.setText(jb.getString("noidung"));
                t2.setText(jb.getString("daodien"));
                t3.setText(jb.getString("dienvien"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}