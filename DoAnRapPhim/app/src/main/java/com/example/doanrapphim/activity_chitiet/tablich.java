package com.example.doanrapphim.activity_chitiet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.AdapterLichChieu;
import com.example.doanrapphim.adapter.MyAdapter;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.adapter.adapterlich;
import com.example.doanrapphim.adapter.listadapter;
import com.example.doanrapphim.itf.OnItemClickListener;
import com.example.doanrapphim.lop.Phim;
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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class tablich extends Fragment {
    private ExpandableListView expandableListView;
    private List<group> groups;
    private Map<group, List<item>> litem;
    private listadapter ladapter;

    //lay du lieu
    private final LinkedList<lichchieu> lichchieus = new LinkedList<>();
    String d = "";
    private JSONObject jsonRoot = null;
    private JSONArray jsonArray;
    int l;
    RecyclerView rc1;
    AdapterLichChieu adapterLichChieu;


    RecyclerView recyclerView;
    TextView all;
    adapterlich adtlich;
    LinkedList<lich> p = new LinkedList<>();
    Calendar calendar = Calendar.getInstance();
    int ng, t, n;
    OnItemClickListener onItemClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablich, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        rc1 = view.findViewById(R.id.rcl);
        all = view.findViewById(R.id.all);
        layNgay();
        onItemClickListener = new OnItemClickListener() {
            @Override
            public void OnItemClickListener(String s) {
                all.setText(s);
            }
        };
        recyclerView.setHasFixedSize(false);
        GridLayoutManager gridLayout = new GridLayoutManager(getContext(),7);
        recyclerView.setLayoutManager(gridLayout);
        adtlich = new adapterlich(p, getContext());
        adtlich.onItemClickListener = onItemClickListener;
        recyclerView.setAdapter(adtlich);

        layDsPhim();
        adapterLichChieu = new AdapterLichChieu(layDsRap(),getContext());
        rc1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rc1.setAdapter(adapterLichChieu);
        return view;
    }

    public void layNgay() {
        ng = calendar.get(calendar.DATE);
        t = calendar.get(calendar.MONTH) + 1;
        n = calendar.get(calendar.YEAR);
        for (int i = 0; i < 7; i++) {
            lich l = new lich();
            l.setNgay(ng);
            l.setThang(t);
            l.setNam(n);
            l.setThu(chonNgay(ng, t, n));
            p.add(i, l);
            kiemTra(ng, t, n);
        }
    }

    public void kiemTra(int ngay, int thang, int nam) {
        switch (thang) {
            case 2:
                if (((n % 4 == 0) && (n % 100 != 0)) || (n % 400 == 0)) {
                    if (ngay < 29) {
                        ng += 1;
                    } else if (thang < 12) {
                        ng = 1;
                        t += 1;
                    } else {
                        ng = 1;
                        t = 1;
                        n += 1;
                    }
                } else if (ngay < 28) {
                    ng += 1;
                } else if (thang < 12) {
                    ng = 1;
                    t += 1;
                } else {
                    ng = 1;
                    t = 1;
                    n += 1;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (ngay < 31) {
                    ng += 1;
                } else if (thang < 12) {
                    ng = 1;
                    t += 1;
                } else {
                    ng = 1;
                    t = 1;
                    n += 1;
                }
            }
            break;
            case 4:
            case 6:
            case 9:
            case 11: {
                if (ngay < 30) {
                    ng += 1;
                } else if (thang < 12) {
                    ng = 1;
                    t += 1;
                } else {
                    ng = 1;
                    t = 1;
                    n += 1;
                }
            }
            break;
        }
    }

    private String chonNgay(int ng, int t, int n) {
        String input_date = ng + "/" + t + "/" + n;
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = null;
        try {
            dt1 = format1.parse(input_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("EEE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    private void layDsPhim(){
        d = new adapterjson().read(getContext(), R.raw.data);
        try {
            jsonRoot = new JSONObject(d);
            jsonArray = jsonRoot.getJSONArray("lichchieu");
            l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                lichchieu lc = new lichchieu();
                lc.setId(jsonArray.getJSONObject(i).getInt("id"));
                lc.setRap(jsonArray.getJSONObject(i).getString("rap"));
                lc.setNgaychieu(jsonArray.getJSONObject(i).getString("ngaychieu"));
                lc.setGiochieu(jsonArray.getJSONObject(i).getString("giochieu"));
                lc.setPhim(jsonArray.getJSONObject(i).getInt("phim"));
                lichchieus.add(i,lc);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private LinkedList<rap> layDsRap(){
        d = new adapterjson().read(getContext(), R.raw.data);
        LinkedList<rap> raps = new LinkedList<>();
        try {
            jsonRoot = new JSONObject(d);
            jsonArray = jsonRoot.getJSONArray("rap");
            l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                rap r = new rap();
                r.setId(jsonArray.getJSONObject(i).getInt("id"));
                r.setTenrap(jsonArray.getJSONObject(i).getString("ten"));
                raps.add(i,r);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return raps;
    }
}