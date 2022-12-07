package com.example.star_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.star_app.databinding.Full;

public class FullScreen extends AppCompatActivity {
    Full fullScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen = DataBindingUtil.setContentView(this, R.layout.activity_full_screen);
        fullScreen.backBtn.setOnClickListener(v -> finish());
        int[] images = {R.drawable.bts_1,R.drawable.bts_2, R.drawable.bts_3, R.drawable.bts_4, R.drawable.bts_5, R.drawable.bts_6, R.drawable.bts_7, R.drawable.member_1, R.drawable.member_2, R.drawable.member_3, R.drawable.member_4, R.drawable.member_5, R.drawable.member_6, R.drawable.member_7, R.drawable.member_8, R.drawable.member_9};
        Intent fullIntent = getIntent();
        int getData = fullIntent.getIntExtra("data", 1);
        for (int i = 1; i <= images.length; i++) {
            int img_arr = i - 1;
            if(i == getData){
                fullScreen.imgView.setImageResource(images[img_arr]);
                break;
            }
        }
    }

}