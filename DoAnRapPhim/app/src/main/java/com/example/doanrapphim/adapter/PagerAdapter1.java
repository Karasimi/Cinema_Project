package com.example.doanrapphim.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.doanrapphim.activity_chitiet.tabbinhluan;
import com.example.doanrapphim.activity_chitiet.tablich;
import com.example.doanrapphim.activity_chitiet.tabthongtin;
import com.example.doanrapphim.trangchinh.tabdangchieu;
import com.example.doanrapphim.trangchinh.tabsapchieu;

public class PagerAdapter1 extends FragmentStatePagerAdapter {
    int tabcout;

    public PagerAdapter1(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcout = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new tabdangchieu();
            case 1 : return new tabsapchieu();
            default: return new tabdangchieu();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0 : title = "Đang Chiếu";break;
            case 1 :  title = "Sắp Chiếu";break;
        }
        return title;
    }
}
