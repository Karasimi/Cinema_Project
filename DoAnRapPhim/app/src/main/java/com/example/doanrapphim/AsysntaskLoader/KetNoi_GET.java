package com.example.doanrapphim.AsysntaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KetNoi_GET {
  public  static String getDL(String s){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String kq = null;
        try {
            URL url = new URL(s);
            urlConnection= (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
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
}
