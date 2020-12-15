package com.example.doanrapphim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.doanrapphim.adapter.PagerAdapter;
import com.example.doanrapphim.adapter.PagerAdapter1;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class activity_trangchu extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView  navigationView;
    TabItem dangchieu,sapchieu;
    ListView listView;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        navigationView = findViewById(R.id.nav_view);
        tabLayout = findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.pager);
        Toolbar toolbar = findViewById(R.id.tootbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        drawerLayout = findViewById(R.id.drawer_layout);
        //cac tab
        PagerAdapter1 pagerAdapter = new PagerAdapter1(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        ActionBarDrawerToggle togge = new ActionBarDrawerToggle(this ,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        togge.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.nav_dangxuat:
                    case R.id.nav_ds:
                         intent = new Intent(activity_trangchu.this, activity_dsPhim.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_person:
                        intent = new Intent(activity_trangchu.this, activity_trangcanhan.class);
                        startActivity(intent);
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    public  void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}