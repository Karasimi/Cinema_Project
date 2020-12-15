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

public class PagerAdapter extends FragmentStatePagerAdapter {
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
            default: return new tablich();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0 : title = "Lịch Chiếu";break;
            case 1 :  title = "Thông Tin";break;
            case 2 : title = "Bình Luận";break;
        }
        return title;
    }
}
