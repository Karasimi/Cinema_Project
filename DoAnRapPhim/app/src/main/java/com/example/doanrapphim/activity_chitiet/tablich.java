package com.example.doanrapphim.activity_chitiet;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.listadapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tablich extends Fragment {
    private ExpandableListView expandableListView;
    private List<group> groups;
    private Map<group, List<item>> litem;
    private listadapter ladapter;
    TextView ngay;
    Button chonngay;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablich, container, false);
        expandableListView = view.findViewById(R.id.list);
        ngay = view.findViewById(R.id.ngay);
        chonngay = view.findViewById(R.id.chonngay);
        litem = getLitem();
        groups =  new ArrayList<>(litem.keySet());
        ladapter = new listadapter(groups,litem);
        ngay.setText(simpleDateFormat.format(calendar.getTime()));
        expandableListView.setAdapter(ladapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Intent intent = new Intent(getContext(),datghe.class);
                startActivity(intent);
                return false;

            }
        });
        chonngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay();
            }
        });

        return view;
    }
    private Map<group, List<item>> getLitem() {
        Map<group, List<item>> listMap = new HashMap<>();
        String e[] = getResources().getStringArray(R.array.chinhanh);
        String e1[] = getResources().getStringArray(R.array.thoigian);
        for (String c: e
        ) {
            int i=0;
            group a = new group(c,i);
            i++;
            List<item> ob = new ArrayList<>();
            for (int j=0; j < e1.length;j++){
                ob.add(new item(e1[j]));
            }
            listMap.put(a,ob);
        }
        return listMap;
    }
    private void chonNgay(){
        int ng = calendar.get(calendar.DATE);
        int t = calendar.get(calendar.MONTH);
        int n = calendar.get(calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                ngay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },n,t,ng);
        datePickerDialog.show();
    }



}