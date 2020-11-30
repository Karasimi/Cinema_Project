package com.example.doanrapphim.activity_chitiet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.lop.Phim;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class tabthongtin extends Fragment {
    TextView t1,t2,t3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabthongtin, container, false);
        anhXa(view);
        layDsPhim();
        return view;
    }
    public void anhXa(View view){
      t1 = view.findViewById(R.id.noidung);
      t2 = view.findViewById(R.id.daodien);
      t3 = view.findViewById(R.id.dienvien);
    }
    private void layDsPhim() {
        String d = new adapterjson().read(getContext(), R.raw.data);
        Bundle bundle = getActivity().getIntent().getExtras();
        int maPhim = bundle.getInt("id");
        try {
            JSONObject jsonRoot = new JSONObject(d);
            JSONArray jsonArray = jsonRoot.getJSONArray("phim");
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                if (jsonArray.getJSONObject(i).getInt("maphim") == maPhim) {
                    t2.setText(jsonArray.getJSONObject(i).getString("daodien"));
                    t3.setText(jsonArray.getJSONObject(i).getString("dienvien"));
                    t1.setText(jsonArray.getJSONObject(i).getString("noidung"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}