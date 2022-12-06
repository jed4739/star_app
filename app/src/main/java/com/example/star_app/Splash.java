package com.example.star_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("data", 0);
        int input_num = sharedPreferences.getInt("input_num", -1);
        moveMain(input_num);
    }
    private void moveMain(int sec) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Log.i("splash","실행 완료");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        },1000 * sec);
    }
}
