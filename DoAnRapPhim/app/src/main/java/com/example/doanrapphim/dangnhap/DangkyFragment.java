package com.example.doanrapphim.dangnhap;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.R;
import com.example.doanrapphim.ketnoi.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class DangkyFragment extends Fragment {
    private EditText edtgmail;
    private EditText edtMK,resetMK;
    private Button btndangky;
    private TextView tvM;
    private ProgressDialog dialog;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dangky, container, false);
        init();
        return view;
    }
    private void init(){
        edtgmail = view.findViewById(R.id.dangky_username);
        edtMK = view.findViewById(R.id.dangky_matkhau);
        resetMK = view.findViewById(R.id.dangky_rematkhau);
        btndangky = view.findViewById(R.id.dangky);
        tvM = view.findViewById(R.id.tvmessage);
        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);

        btndangky.setOnClickListener(v -> {
            if (validate()) {
                dangky();
            }
        });
    }

    private boolean validate() {
        if(edtgmail.getText().toString().isEmpty()){
            tvM.setText("Chưa nhập email");
            return false;
        }
        if(edtMK.getText().toString().length() <6){
            tvM.setText("password lớn hơn 5");
            return false;
        }
        if(!resetMK.getText().toString().equals(edtMK.getText().toString())){
            tvM.setText("Chưa nhập password");
            return false;
        }
        return true;
    }

    private void dangky() {
        dialog.setMessage("Đang đăng ký");
        dialog.show();
        StringRequest request = new StringRequest(Request.Method.POST , Constant.DANGKY , response -> {
            try {
                JSONObject jsonObject = new JSONObject(response);
                if(jsonObject.getBoolean("success")){
                    JSONObject user = jsonObject.getJSONObject("user");
                    SharedPreferences userPref = getActivity().getApplicationContext().getSharedPreferences("user",getContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = userPref.edit();
                    editor.putString("token", jsonObject.getString("token"));
                    editor.putString("name", user.getString("name"));
                    editor.apply();
                    Toast.makeText(getContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                }

            }catch (JSONException e){
                e.printStackTrace();
            }
            dialog.dismiss();
        },error -> {
            error.printStackTrace();
            dialog.dismiss();
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("email" , edtgmail.getText().toString().trim());
                map.put("password",edtMK.getText().toString());
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
    }
}