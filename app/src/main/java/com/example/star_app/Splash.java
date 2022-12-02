package com.example.star_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moveMain(3);
    }
    /*
    * - 문제점
    * 로딩시간에 Splash 가 나올려고 함.
    * 하지만 Splash 때문에 로딩이 지연됨 -> Splash API 사용 (전부 하고 시간남으면 하기)
    * */
    private void moveMain(int sec) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("splash","splash start");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Log.i("splash", "splash finish");
                finish();
            }
        },1000 * sec);
    }
}
