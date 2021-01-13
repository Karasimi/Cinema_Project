package com.example.doanrapphim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doanrapphim.adapter.PagerAdapter;
import com.example.doanrapphim.adapter.PagerAdapter1;
import com.example.doanrapphim.ketnoi.Constant;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class activity_trangchu extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView  navigationView;
    TabItem dangchieu,sapchieu;
    ListView listView;
    TabLayout tabLayout;
    ViewPager viewPager;
    SharedPreferences preferences;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        //Ánh xạ
        preferences = getApplicationContext().getSharedPreferences("user",Context.MODE_PRIVATE);
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
                        dangxuat();
                        break;
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
    public void dangxuat(){
        StringRequest request = new StringRequest(Request.Method.GET , Constant.DANGXUAT, res->{
            try {
                JSONObject object = new JSONObject(res);
                if(object.getBoolean("success")){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.apply();
                    startActivity(new Intent(activity_trangchu.this, activity_dangnhap.class));
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        },error -> {

        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String token = preferences.getString("token","");
                HashMap<String, String> map= new HashMap<>();
                map.put("Authorization","Bearer "+token);
                return  map;
            }
        };
        RequestQueue  queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
    public  void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}