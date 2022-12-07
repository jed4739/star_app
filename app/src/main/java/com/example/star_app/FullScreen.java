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
        backBtn();
        fullImg();
    }

    /*
    * 뒤로가기 버튼
    * 현재 화면을 종료시켜서 기존 화면으로 이동시킴.
    * */
    public void backBtn() {
        fullScreen.backBtn.setOnClickListener(v -> finish());
    }

    /*
     * 1. 반복문을 사용해서 코드의 중복을 막고자 이미지 주소를 배열객체에 저장함.
     * 2. 반복문의 객체와 fullScreen 메소드에서 받은 Intent 인스턴스 값을 비교후 이미지 출력 
     * */
    public void fullImg() {
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