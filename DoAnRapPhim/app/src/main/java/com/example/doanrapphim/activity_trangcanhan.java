package com.example.doanrapphim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.doanrapphim.adapter.ViewPageAdapter;
import com.example.doanrapphim.adapter.adaptertcn;
import com.google.android.material.tabs.TabLayout;

public class activity_trangcanhan extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangcanhan);
        tabLayout = findViewById(R.id.tabcanhan);
        viewPager = findViewById(R.id.viewcanhan);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trang Cá Nhân");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adaptertcn a = new adaptertcn(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(a);
        tabLayout.setupWithViewPager(viewPager);
    }
}