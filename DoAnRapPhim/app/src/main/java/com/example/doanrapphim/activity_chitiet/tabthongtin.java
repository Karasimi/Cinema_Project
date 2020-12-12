package com.example.doanrapphim.activity_chitiet;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.doanrapphim.R;
import com.example.doanrapphim.adapter.adapterjson;
import com.example.doanrapphim.lop.Phim;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class tabthongtin extends Fragment {
    Phim phim = new Phim();
    YouTubePlayerView youTubePlayerView;
    ImageView imageView;
    TextView txtTen,txtTl,txtTuoi,txtDv,txtDd,txtNd,txtDiem;
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabthongtin, container, false);
        anhXa(view);
        layDsPhim();
         youtube(view);
        xuatThongtin();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamDiem();
            }
        });
        return view;
    }
    private void layDsPhim(){
        Bundle bundle = getActivity().getIntent().getExtras();
        int maPhim = bundle.getInt("id");
        String d = new adapterjson().read(getContext(), R.raw.data);
        try {
            JSONObject jsonRoot = new JSONObject(d);
            JSONArray jsonArray = jsonRoot.getJSONArray("phim");
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
                if (jsonArray.getJSONObject(i).getInt("maphim") == maPhim) {
                    phim.setTenphim(jsonArray.getJSONObject(i).getString("tenphim"));
                    phim.setHinhanh(jsonArray.getJSONObject(i).getString("hinhanh"));
                    phim.setTheloai(jsonArray.getJSONObject(i).getString("theloai"));
                    phim.setDiem(jsonArray.getJSONObject(i).getInt("diem"));
                    phim.setTuoi(jsonArray.getJSONObject(i).getString("tuoi"));
                    phim.setDaodien(jsonArray.getJSONObject(i).getString("daodien"));
                    phim.setDienvien(jsonArray.getJSONObject(i).getString("dienvien"));
                    phim.setNoidung(jsonArray.getJSONObject(i).getString("noidung"));
                    phim.setTrailer(jsonArray.getJSONObject(i).getString("trailer"));
                    phim.setTrangthai(jsonArray.getJSONObject(i).getInt("trangthai"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void xuatThongtin(){
        txtTen.setText(phim.getTenphim());
        txtTl.setText(phim.getTheloai());
        txtTuoi.setText(phim.getTuoi());
        txtDiem.setText(String.valueOf(phim.getDiem()));
        txtDd.setText(phim.getDaodien());
        txtDv.setText(phim.getDienvien());
        txtNd.setText(phim.getNoidung());
        int hinhAnh = this.getDrawableResIdByName(phim.getHinhanh());
        imageView.setImageResource(hinhAnh);
    }
    public int getDrawableResIdByName(String tenHinh)  {
        String ct = getContext().getPackageName();
        int resID = getContext().getResources().getIdentifier(tenHinh , "drawable", ct);
        return resID;
    }
    public void chamDiem(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.chamdiem);
        dialog.show();
    }
    public void anhXa(View view){
        imageView = view.findViewById(R.id.img);
        txtTen = view.findViewById(R.id.tvtenphim);
        txtTl = view.findViewById(R.id.tvtheloai);
        txtDd = view.findViewById(R.id.tvdaodien);
        txtDv = view.findViewById(R.id.tvdienvien);
        txtNd = view.findViewById(R.id.tvmota);
        txtDiem = view.findViewById(R.id.tvdiem);
        txtTuoi = view.findViewById(R.id.tvdotuoi);
        btn = view.findViewById(R.id.btnchamdiem);
    }
    public void youtube(View view){
        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player_view);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = phim.getTrailer();
                youTubePlayer.loadVideo(videoId, 0);
                super.onReady(youTubePlayer);
            }
        });
    }

}