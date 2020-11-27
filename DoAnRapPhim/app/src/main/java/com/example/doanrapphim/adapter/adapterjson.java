package com.example.doanrapphim.adapter;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class adapterjson {
    public static String read(Context context, int data) {
        InputStream is = context.getResources().openRawResource(data);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String s=null;
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
