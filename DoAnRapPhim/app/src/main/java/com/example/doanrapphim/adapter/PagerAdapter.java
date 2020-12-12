package com.example.doanrapphim.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.doanrapphim.activity_chitiet.tabbinhluan;
import com.example.doanrapphim.activity_chitiet.tablich;
import com.example.doanrapphim.activity_chitiet.tabthongtin;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcout;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcout = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new tablich();
            case 1 : return new tabthongtin();
            case 2 : return new tabbinhluan();
            default: return null;

        }
    }

    @Override
    public int getCount() {
        return tabcout;
    }
}
