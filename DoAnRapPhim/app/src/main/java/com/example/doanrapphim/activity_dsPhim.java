package com.example.doanrapphim;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.AsysntaskLoader.AsynTask;
import com.example.doanrapphim.AsysntaskLoader.KetNoi_GET;
import com.example.doanrapphim.adapter.MyAdapter;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.lop.Phim;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;


public class activity_dsPhim extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    static final int GET = 1;
    static final int POST = 2;
    static final int LOADERID = 111;
    private LinkedList<Phim> listPhim = new LinkedList<>();
    String d = "";
    LinearLayout linearLayout;
    RecyclerView recyclerView;
    SearchView searchView;
    Toolbar toolbar;
    private JSONObject jsonRoot = null;
    private JSONArray jsonArray;
    int l;
    MyAdapter myAdapter;
    LoaderManager loaderManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_phim);
        Bundle bundle = new Bundle();
        bundle.putInt("phuongThuc",GET);
        LoaderManager.getInstance(this).initLoader(LOADERID,bundle,this);
        anhxa();
        searchView.clearFocus();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Danh Sách Phim");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layDsPhim();
//        myAdapter = new MyAdapter(listPhim, this);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filter(newText);
//                return false;
//            }
//        });
//        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
//            @Override
//            public boolean onClose() {
//                linearLayout.setVisibility(View.INVISIBLE);
//                return false;
//            }
//        });

    }
    public void tatca (View view){
        loc("tca");
        }
        public void dachieu (View view){
        loc("dangchieu");
        }
        public void timkiem (View view){
        loc("sapchieu");
        }
        public void anhxa () {
            linearLayout = findViewById(R.id.filter);
            recyclerView = findViewById(R.id.recycle);
            searchView = findViewById(R.id.search);
            toolbar = findViewById(R.id.toolbar);
        }
        private void filter(String s){
          LinkedList<Phim> filter = new LinkedList<>();
          for (Phim c: listPhim){
              if(c.getTenphim().toLowerCase().contains(s.toLowerCase())){
                  filter.add(c);
              }
          }
          myAdapter.filterl(filter);
        }
        private void layDsPhim(){
            d = new adapterjson().read(getApplicationContext(), R.raw.data);
            try {
                jsonRoot = new JSONObject(d);
                jsonArray = jsonRoot.getJSONArray("phim");
                l = jsonArray.length();
                for (int i = 0; i < l; i++) {
                    Phim phim = new Phim();
                    phim.setTenphim(jsonArray.getJSONObject(i).getString("tenphim"));
                    phim.setHinhanh(jsonArray.getJSONObject(i).getString("hinhanh"));
                    phim.setTheloai(jsonArray.getJSONObject(i).getString("theloai"));
                    phim.setDiem(jsonArray.getJSONObject(i).getInt("diem"));
                    phim.setTuoi(jsonArray.getJSONObject(i).getString("tuoi"));
                    phim.setId(jsonArray.getJSONObject(i).getInt("maphim"));
                    phim.setTrangthai(jsonArray.getJSONObject(i).getInt("trangthai"));
                    listPhim.add(i,phim);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    private void loc(String s){
        LinkedList<Phim> filter = new LinkedList<>();
        switch (s){
            case "tca":{
                for (Phim c: listPhim){
                        filter.add(c);
                    }
                }
                break;
            case "dangchieu":{
                for (Phim c: listPhim){
                    if(c.getTrangthai() == 1)
                    filter.add(c);
                }
                break;
            }
            case "sapchieu" :{
                for (Phim c: listPhim){
                    if(c.getTrangthai() == 2)
                        filter.add(c);
                }
            }
        }
        myAdapter.filterl(filter);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
      if (args != null &&  args.getInt("phuongThuc") == GET) {
          String url = "http://192.168.43.83/DatVe/public/api/api/phim";
          return new AsynTask(this, url, GET, null);
      }
      return null;

    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        listPhim = dsPhim(data);
        myAdapter = new MyAdapter(listPhim, getApplicationContext());
        recyclerView.setAdapter(myAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
    private LinkedList<Phim> dsPhim(String data){
        LinkedList<Phim> phims = new LinkedList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                Phim phim = new Phim();
                JSONObject jb = jsonArray.getJSONObject(i);
                phim.setTenphim(jb.getString("tenphim"));
                phim.setHinhanh(jb.getString("hinhanh"));
                phim.setTheloai(jb.getString("theloai"));
                phim.setId(jb.getInt("id"));
                phim.setTrangthai(jb.getInt("trangthai"));
                phims.add(i,phim);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return phims;

    }
}