package com.example.star_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        moveMain(3);
    }
    /*
    * - 문제점
    * 로딩시간에 Splash 가 나올려고 함.
    * 하지만 Splash 때문에 로딩이 지연됨 -> Splash API 사용
    * */
    private void moveMain(int sec) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000 * sec);
    }
}
