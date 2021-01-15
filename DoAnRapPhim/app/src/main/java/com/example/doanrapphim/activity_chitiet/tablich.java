package com.example.doanrapphim.activity_chitiet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.example.doanrapphim.adapter.AdapterLichChieu;
import com.example.doanrapphim.adapter.MyAdapter;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.adapter.adapterlich;
import com.example.doanrapphim.adapter.listadapter;
import com.example.doanrapphim.itf.OnItemClickListener;
import com.example.doanrapphim.lop.Phim;
import com.example.doanrapphim.lop.khungtgchieu;
import com.example.doanrapphim.lop.lich;
import com.example.doanrapphim.lop.lichchieu;
import com.example.doanrapphim.lop.rap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class tablich extends Fragment implements LoaderManager.LoaderCallbacks<String> {
    static final int GET = 1;
    static final int POST = 2;
    static final int LOADERLich = 111;
    static final int LOADERRapx2 = 114;
    static final int LOADERRap = 112;
    private LoaderManager loaderManager;
    private String ngayTrongTuan = "";


    //lay du lieu

    RecyclerView rc1;
    AdapterLichChieu adapterLichChieu;


    RecyclerView recyclerView;
    TextView all;
    TextView trong;
    adapterlich adtlich;
    LinkedList<lich> p = new LinkedList<>();
    LinkedList<rap> Rap = new LinkedList<>();
    LinkedList<khungtgchieu> k = new LinkedList<>();
    OnItemClickListener onItemClickListener;
    int maPhim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablich, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        rc1 = view.findViewById(R.id.rcl);
        all = view.findViewById(R.id.all);
        trong = view.findViewById(R.id.idnull);
        Bundle maP = getActivity().getIntent().getExtras();
        maPhim = maP.getInt("id");
        //goi asyntask
        Bundle bundle = new Bundle();
        bundle.putInt("phuongThuc", GET);
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(LOADERLich, bundle, this);

        trong.setVisibility(View.GONE);
        onItemClickListener = new OnItemClickListener() {
            @Override
            public void OnItemClickListener(String th, int ng, int t, int n, String ntn) {
                all.setText(setNgay(th, ng, t, n));
                doiLich(ntn);
            }

        };
        return view;
    }

    public String setNgay(String thu, int ng, int th, int n) {
        String s = thu + " " + ng + " Tháng " + th + " " + n;
        return s;
    }
    public void doiLich(String ngay){
        Bundle layRap = new Bundle();
        layRap.putInt("maPhim",maPhim);
        layRap.putInt("phuongThuc",POST);
        layRap.putString("ngay",ngay);
        if (loaderManager.getLoader(LOADERRap) == null) {
            loaderManager.initLoader(LOADERRapx2,layRap,this);
        } else {
            loaderManager.restartLoader(LOADERRapx2, layRap, this);
        }
    }
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        if (args != null && id == LOADERLich) {
                String url = "http://192.168.43.83/DatVePhim/public/api/api/dslich";
                String thamSo = "";
                return new AsynTask(getContext(), url, args.getInt("phuongThuc"), thamSo);
        }else {
            if (args != null && id == LOADERRap) {
                String url = "http://192.168.43.83/DatVePhim/public/api/api/rap";
                ngayTrongTuan = args.getString("ngay");
                String thamSo = "id="+args.getInt("maPhim")+"&ngaychieu="+ngayTrongTuan;
                return new AsynTask(getContext(), url, args.getInt("phuongThuc"), thamSo);
            }
            else {
                if (args != null && id == LOADERRapx2) {
                    String url = "http://192.168.43.83/DatVePhim/public/api/api/rap";
                    String a = args.getString("ngay");
                    String thamSo = "id="+args.getInt("maPhim")+"&ngaychieu="+a;
                    return new AsynTask(getContext(), url, args.getInt("phuongThuc"), thamSo);
                }
            }
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (loader.getId() == LOADERLich && data != null) {
            if (p.size() < 7) {
                setTuan(data);
            }
        }else {
            if (loader.getId() == LOADERRap && data != null) {
                if (Rap != null){
                    Rap.clear();
                }
                Rap = setRap(data);
                k = setGio(data);
                if (Rap.size() == 0) {
                    trong.setVisibility(View.VISIBLE);
                    trong.setText("Không Có Lịch Chiếu");
                    rc1.setVisibility(View.GONE);
                } else {
                    adapterLichChieu = new AdapterLichChieu(Rap, maPhim, k, getContext());
                    rc1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    rc1.setAdapter(adapterLichChieu);
                }
            } else {
                if (loader.getId() == LOADERRapx2 && data != null) {
                    if (Rap != null){
                        Rap.clear();
                    }
                    Rap = setRap(data);
                    k = setGio(data);
                    if (Rap.size() != 0) {
                        trong.setVisibility(View.GONE);
                        rc1.setVisibility(View.VISIBLE);
                        adapterLichChieu.filterl(Rap,k);
                    }
                }else {
                    if (data == null) {
                        trong.setVisibility(View.VISIBLE);
                        trong.setText("Không Có Lịch Chiếu");
                        rc1.setVisibility(View.GONE);
                    }
                }
            }
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
    public void setTuan(String data){
            try {
                JSONArray jr = new JSONArray(data);
                int l = jr.length();
                for (int i = 0; i < l; i++) {
                    lich lc = new lich();
                    JSONObject jc = jr.getJSONObject(i);
                    lc.setNgay(jc.getInt("ngay"));
                    lc.setThang(jc.getInt("thang"));
                    lc.setThu(jc.getString("thu"));
                    lc.setNam(jc.getInt("nam"));
                    lc.setNtn((jc.getString("ntn")));
                    p.add(i, lc);
                }
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            recyclerView.setHasFixedSize(false);
            GridLayoutManager gridLayout = new GridLayoutManager(getContext(), 7);
            recyclerView.setLayoutManager(gridLayout);
            adtlich = new adapterlich(p, getContext());
            adtlich.onItemClickListener = onItemClickListener;
            recyclerView.setAdapter(adtlich);
        all.setText(setNgay(p.getFirst().getThu(), p.getFirst().getNgay(), p.getFirst().getThang(), p.getFirst().getNam()));
        Bundle layRap = new Bundle();
        layRap.putInt("maPhim",maPhim);
        layRap.putInt("phuongThuc",POST);
        layRap.putString("ngay",p.getFirst().getNtn());
        loaderManager.initLoader(LOADERRap, layRap, this);
    }
    public LinkedList<rap> setRap(String data){
        LinkedList<rap> raps = new LinkedList<>();
        try {
            JSONObject js = new JSONObject(data);
            JSONArray jr = js.getJSONArray("rap");
            int l = jr.length();
            raps.clear();
            for (int i = 0; i < l; i++) {
                rap r = new rap();
                JSONObject jc = jr.getJSONObject(i);
                r.setTenrap(jc.getString("tenrap"));
                r.setId(jc.getInt("id"));
                r.setSocot(jc.getInt("socot"));
                raps.add(i, r);
            }
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
       return raps;
    }
    public LinkedList<khungtgchieu> setGio(String data){
        LinkedList<khungtgchieu> khungtgchieus = new LinkedList<>();
        try {
            JSONObject js = new JSONObject(data);
            JSONArray jr = js.getJSONArray("gio");
            int l = jr.length();
            for (int i = 0; i < l; i++) {
                khungtgchieu r = new khungtgchieu();
                JSONObject jc = jr.getJSONObject(i);
                r.setId(jc.getInt("thoigian"));
                r.setRap(jc.getInt("rap"));
                r.setNgaychieu(jc.getString("ngaychieu"));
                r.setGio(jc.getString("giochieu"));
                khungtgchieus.add(i, r);
            }
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
        return khungtgchieus;
    }
}