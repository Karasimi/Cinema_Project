package com.example.doanrapphim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class activity_youtube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    YouTubePlayerView youTubePlayerView;
    String API_KEY = "AIzaSyC8ic__iGwpeWTwkNZByOh34YQDZCXSeeE";
    int reQuest = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        youTubePlayerView = findViewById(R.id.youtube);
        youTubePlayerView.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo("P_hzyJhUNDQ");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(activity_youtube.this, reQuest);
        }else {
            Toast.makeText(this, "Lỗi !!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == reQuest){
            youTubePlayerView.initialize(API_KEY, activity_youtube.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
