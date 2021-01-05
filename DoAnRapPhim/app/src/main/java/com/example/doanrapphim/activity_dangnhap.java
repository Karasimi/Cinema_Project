package com.example.doanrapphim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.doanrapphim.adapter.ViewPageAdapter;
import com.example.doanrapphim.dangnhap.DangnhapFragment;
import com.google.android.material.tabs.TabLayout;

import java.io.InputStream;

public class activity_dangnhap extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        tabLayout = findViewById(R.id.tab_dangki);
        viewPager = findViewById(R.id.view_page);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        getSupportFragmentManager().beginTransaction().replace(R.id.dangnhap , new DangnhapFragment()).commit();
    }

}