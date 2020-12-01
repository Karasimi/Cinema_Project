package com.example.dangnhap;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadJSONExample {
    public static String readText(Context context, int resId){
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String s = null;
        while (true){
            try {
                if (!((s = br.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
