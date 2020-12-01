package com.example.dangnhap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       String Title = "";
       switch (position){
           case 0:
               Title = "Đăng nhập";
               break;
           case 1:
               Title = "Đăng ký";
               break;
       }
       return Title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DangnhapFragment();
            case 1:
                return new DangkyFragment();
            default:
                return new DangkyFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
