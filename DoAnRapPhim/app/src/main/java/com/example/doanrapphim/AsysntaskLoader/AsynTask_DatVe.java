package com.example.doanrapphim.AsysntaskLoader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.android.volley.AuthFailureError;
import com.example.doanrapphim.lop.ghe;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AsynTask_DatVe extends AsyncTaskLoader<String>{

 private  String url;
 private int phim, rap, gio;
 private  String ghes;
 public AsynTask_DatVe(@NonNull Context context, String url, String ghe,int p, int r, int g) {
        super(context);
        this.url = url;
        this.ghes = ghe;
        this.phim = p;
        this.rap = r;
        this.gio = g;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String kq = null;
        String data = null;
            data = "ghe="+this.ghes+"&phim="+this.phim+"&rap="+this.rap+"&thoigian="+this.gio;
        try {
            URL url = new URL(this.url);
            urlConnection= (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
            writer.write(data);
            writer.flush();
            urlConnection.connect();
            InputStream inputStream =urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine())!= null){
                stringBuilder.append(line);
            }
            if (stringBuilder.length() == 0){
                return  null;
            }
            kq = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return kq;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    protected Map<String, int[]> getParams(LinkedList<ghe> ghes) {
        HashMap<String,int[]> map = new HashMap<>();
        int[] a = new int[ghes.size()];
        ArrayList<ghe> ar = new ArrayList<ghe>();
        int i = 0;
        for (ghe g:ghes) {
            a[i] = g.getId();
        }
        map.put("idGhe" , a);
        return map;
    }
}
