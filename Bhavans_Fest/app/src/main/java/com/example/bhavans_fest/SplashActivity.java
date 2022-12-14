package com.example.bhavans_fest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.fest_audio);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,FirstActivity.class);
                startActivity(i);
            }
        },SPLASH_TIME_OUT);
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
