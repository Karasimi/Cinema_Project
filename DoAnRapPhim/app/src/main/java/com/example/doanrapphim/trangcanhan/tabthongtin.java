package com.example.doanrapphim.trangcanhan;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.doanrapphim.R;

public class tabthongtin extends Fragment {


    private EditText txt1, txt2, txt3, txt4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tabthongtincanhan, container, false);
        txt1 = view.findViewById(R.id.editTextTenDN);
        txt2 = view.findViewById(R.id.editTextName);
        txt3 = view.findViewById(R.id.editTextPhone);
        txt4 = view.findViewById(R.id.editTextEmail);
        Context context = view.getContext();




        return view;
    }
}