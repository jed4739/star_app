package com.example.star_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("data", 0);
        int input_num = sharedPreferences.getInt("input_num", -1);
        if (input_num <= 0) {
            Toast.makeText(getApplicationContext(), "0초 이하는 안됩니다! 기본 3초로 실행합니다.", Toast.LENGTH_SHORT).show();
            moveMain(3);
        } else {
            moveMain(input_num);
        }
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
