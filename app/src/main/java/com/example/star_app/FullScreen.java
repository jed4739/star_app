package com.example.star_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.star_app.databinding.Full;

public class FullScreen extends AppCompatActivity {
    Full fullScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         fullScreen = DataBindingUtil.setContentView(this, R.layout.activity_full_screen);


         fullScreen.backBtn.setOnClickListener(v -> { finish(); });
    }

}