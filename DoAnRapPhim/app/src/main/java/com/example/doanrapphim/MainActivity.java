package com.example.doanrapphim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    YouTubePlayerView youTubePlayerView;
    String API_KEY="AIzaSyALXVSnYN7u5G0wMlY6GYMsO52rHnoCbTo";
    int reQuest=123;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences userPref = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                boolean isLoggedIn = userPref.getBoolean("isLoggedIn", false);
                if (isLoggedIn) {
                    startActivity(new Intent(MainActivity.this, activity_trangcanhan.class));
                    finish();
                } else {
                    isFirstTime();
                }
            }
        }, 1500);

         Bundle bundle = getIntent().getExtras();
         a = bundle.getString("key");
        if (a == null){
            Toast.makeText(this, "Khong Co Video", Toast.LENGTH_SHORT).show();
        }
        youTubePlayerView = findViewById(R.id.youtube);
        youTubePlayerView.initialize(API_KEY,this);
    }
    private void isFirstTime(){
        SharedPreferences preferences = getApplication().getSharedPreferences("onBroard", Context.MODE_PRIVATE);
        boolean isFristTime = preferences.getBoolean("isFirstTime", true);

        if(isFristTime){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime",false);
            editor.apply();

            startActivity(new Intent(this, activity_dsPhim.class));
            finish();
        }else{
            startActivity(new Intent(this, activity_dangnhap.class));
            finish();
        }
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        youTubePlayer.cueVideo("a");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(MainActivity.this,reQuest);
        }else {
            Toast.makeText(this, "Error !!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == reQuest){
            youTubePlayerView.initialize(API_KEY,MainActivity.this);
        }
    }
}