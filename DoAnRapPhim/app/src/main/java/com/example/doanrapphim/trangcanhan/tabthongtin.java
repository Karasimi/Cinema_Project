package com.example.doanrapphim.trangcanhan;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.doanrapphim.R;
import com.example.doanrapphim.ketnoi.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class tabthongtin extends Fragment {


    private static final int RESULT_OK = 1 ;
    private EditText name, phone, email, diachi;
    private TextView txt_thongbao;
    private ImageButton anh;
    private Button button;
    private static  final  int G = 1;
    private Bitmap bitmap = null;
    private SharedPreferences preferences;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tabthongtincanhan, container, false);
        init();
        return view;
    }
    private void init(){
        name = view.findViewById(R.id.edithoten);
        phone = view.findViewById(R.id.editsdt);
        diachi = view.findViewById(R.id.edtdiachi);
        email = view.findViewById(R.id.editEmail);
        anh = view.findViewById(R.id.anh);
        button = view.findViewById(R.id.btnluu);
        txt_thongbao = view.findViewById(R.id.thongbao);
        preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);

        anh.setOnClickListener(v->{
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            startActivityForResult(i, G);
        });
        button.setOnClickListener(v -> {
            if(validate()){
                saveInfo();
            }
        });
    }

    private void saveInfo() {
        String hoten = name.getText().toString().trim();
        String sdt =  phone.getText().toString().trim();
        String dc = diachi.getText().toString().trim();

        StringRequest  request = new StringRequest(Request.Method.POST, Constant.SAVE_USER, response -> {
            try{
                JSONObject object = new JSONObject(response);
                if(object.getBoolean("success")){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("anh", object.getString("anh"));
                    editor.apply();
                    Toast.makeText(getContext(), "Cap nhật thành công", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        },error -> {
            error.printStackTrace();
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String token  = preferences.getString("token", "");

                HashMap<String, String> map = new HashMap<>();
                map.put("Authorization", "Bearer"+token);
                return  map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("name", hoten);
                map.put("sdt", sdt);
                map.put("diachi", dc);
                map.put("anh", bitmaptoString(bitmap));
                return map;
            }
        };
    }
    private String bitmaptoString(Bitmap bitmap) {
           if(bitmap != null){
               ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
               bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
               byte [] array = byteArrayOutputStream.toByteArray();
               return Base64.encodeToString(array, Base64.DEFAULT);
           }
           return "";
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == G && resultCode == RESULT_OK) {
            Uri imgUri = data.getData();
            anh.setImageURI(imgUri);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imgUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean validate()
    {
        if(name.getText().toString().isEmpty()){
            txt_thongbao.setText("Chưa nhập Họ tên");
        }
        if(diachi.getText().toString().isEmpty()){
            txt_thongbao.setText("Chưa nhập Họ tên");
        }
        if(phone.getText().toString().isEmpty()){
            txt_thongbao.setText("Chưa nhập Họ tên");
        }
        if(name.getText().toString().isEmpty()){
            txt_thongbao.setText("Chưa nhập Họ tên");
        }
        return true;
    }
}