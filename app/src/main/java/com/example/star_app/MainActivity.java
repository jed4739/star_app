package com.example.star_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.star_app.databinding.Main;

import java.util.logging.Logger;

/*
* 구현할 기능 리스트
*
* 1. Splash 의 sec(스플래시 초 객체)에 다이어로그 정수값을 입력시킬 방법 찾기
* 2. 이미지 클릭 시 사진 전체화면
* 3. 사진전체화면 후에는 뒤로가기 버튼
* 4. 이미지 줌인 줌 아웃
* 5. 트와이스까지 총 16명 이미지 생성
* */
public class MainActivity extends AppCompatActivity {
    Main binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.dialogButton.setOnClickListener(v -> CustomDialog());
    }
    public AlertDialog CustomDialog() {
        EditText input = new EditText(this);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                .setTitle("출력할 스플래시 시간을 입력하시오.")
                .setView(input);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(input){
                    Toast.makeText(this,"숫자임",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "숫자만 입력하세요", Toast.LENGTH_SHORT).show();
                }
                Log.i("dialog_ok", "Dialog btn ok");
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("dialog_cancel", "Dialog btn cancel");
            }
        });
        Log.i("dialog", "dialog success");
        return dialog.show();
//        try {
//        } catch (NumberFormatException exception) {
//        }
    }
}