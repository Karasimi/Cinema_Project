package com.example.doanrapphim;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.doanrapphim.adapter.PagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class activity_chiTietPhim extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem lichchieu,thongtin,binhluan;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phim);
        anhxa();
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition()==1 || tab.getPosition()==2) {
                    pagerAdapter.notifyDataSetChanged();
                }

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
    public void anhxa(){
        tabLayout = (TabLayout) findViewById(R.id.tabbar);
        lichchieu = (TabItem) findViewById(R.id.lichchieu);
        thongtin = (TabItem) findViewById(R.id.thongtin);
        binhluan = (TabItem) findViewById(R.id.binhluan);
        viewPager = (ViewPager) findViewById(R.id.viewpaper);
    }

}