package com.example.dangnhap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import static android.app.Activity.RESULT_OK;


public class DangkyFragment extends Fragment {
    private ImageButton anh;
    private EditText edtgmail;
    private EditText edtMK,resetMK;
    private Button btndangky;
    Uri imageUri;
    public static final int PICK_IMAGE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dangky, container, false);
        anh = view.findViewById(R.id.dangky_anh);
        edtgmail = view.findViewById(R.id.dangky_username);
        edtMK = view.findViewById(R.id.dangnhap_matkhau);
        resetMK = view.findViewById(R.id.dangky_resetpassword);
        btndangky = view.findViewById(R.id.dangky);

        anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent.createChooser(intent,"Select Picture"), PICK_IMAGE);

            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK ) {
            imageUri = data.getData();
            anh.setImageURI(imageUri);
        }
    }
}