package com.example.doanrapphim.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.doanrapphim.dangnhap.DangkyFragment;
import com.example.doanrapphim.dangnhap.DangnhapFragment;
import com.example.doanrapphim.trangcanhan.tabgiaodich;
import com.example.doanrapphim.trangcanhan.tabthongtin;

public class adaptertcn extends FragmentStatePagerAdapter {
    public adaptertcn(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String Title = "";
        switch (position){
            case 0:
                Title = "Thông Tin";
                break;
            case 1:
                Title = "Giao Dịch";
                break;
        }
        return Title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new tabthongtin();
            case 1:
                return new tabgiaodich();
            default:
                return new tabthongtin();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

