package com.example.giaodien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Info(View view) {
        Intent t = new Intent(MainActivity.this,Info.class);
        startActivity(t);

    }

    public void Deal(View view) {
        Intent t = new Intent(MainActivity.this,deal.class);
        startActivity(t);
    }

    public void dealFilm(View view) {
    }
}