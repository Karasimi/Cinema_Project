package com.example.doanrapphim.duLieu;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class AsyntaskLoader extends AsyncTaskLoader<String> {
    private String url;
    public AsyntaskLoader(@NonNull Context context, String url) {
        super(context);
        this.url = url;
    }
    @Nullable
    @Override
    public String loadInBackground() {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String result = null;
        try {
            URL requestURL = new URL(this.url);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            if (builder.length() == 0) {
                return null;
            }
            result = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}