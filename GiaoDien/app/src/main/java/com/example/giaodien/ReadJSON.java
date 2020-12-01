package com.example.giaodien;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadJSON {
    // Đọc nội dung tẽt của một file nguồn.
    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((s = br.readLine()) !=null){
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

}
