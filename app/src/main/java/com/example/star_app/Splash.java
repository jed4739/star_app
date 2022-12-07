package com.example.star_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("data", 0);
        int input_num = sharedPreferences.getInt("input_num", -1);
        try {
            moveMain(input_num);
        }catch (NullPointerException e) {
            moveMain(3);
        }
    }
    /*
     * SPLASH TIME METHOD
     * Splash.java -> MainActivity.java
     * 단위 : 1초 (1000L)
     * */
    private void moveMain(int sec) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }, 1000L * sec);
    }
}
