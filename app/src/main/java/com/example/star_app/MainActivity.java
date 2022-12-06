package com.example.star_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.star_app.databinding.Main;

/*
* 구현할 기능 리스트
*
* 1. Splash 의 sec(스플래시 초 객체)에 다이어로그 정수값을 입력시킬 방법 찾기 - complete
* 2. 이미지 클릭 시 사진 전체화면
* 3. 사진전체화면 후에는 뒤로가기 버튼
* 4. 이미지 줌인 줌 아웃
* 5. 트와이스까지 총 16명 이미지 생성
* */
public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Main binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        * SharedPreferences
        * Map 형식으로 key, value 형식으로 반환
        * 값을 수정할 수 있게 Editor 를 통해서 인터페이스의 새 인스턴스를 반환
        * */
        sharedPreferences = getSharedPreferences("data", 0);
        editor = sharedPreferences.edit();
        /*
        * DataBinding
        * 1. Splash
        * 2. Img
        * */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.dialogButton.setOnClickListener(v -> CustomDialog());
    }

    public AlertDialog CustomDialog() {
        Log.i("dialog", "dialog join");
        EditText input = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
            .setTitle("출력할 스플래시 시간을 입력하시오.")
            .setView(input)
            .setPositiveButton("Ok", (dialog, which) -> {
                try {
                    int input_text = Integer.parseInt(input.getText().toString().trim());
                    if (input_text > 120) {
                        Toast.makeText(getApplicationContext(), "스플래시 시간이 너무 길어요!", Toast.LENGTH_SHORT).show();
                    } else if(input_text <= 0) {
                        Toast.makeText(getApplicationContext(), "1보다 작을 수 없습니다!", Toast.LENGTH_SHORT).show();
                    } else {
                        editor.putInt("input_num", input_text);
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "시간 설정 완료!", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"숫자만 가능합니다. 다시해주세요!", Toast.LENGTH_LONG).show();
                }
                Log.i("dialog_ok", "Dialog btn ok");
            })
            .setNegativeButton("Cancel", (dialog, which) -> {
                dialog.dismiss();
                Log.i("dialog_cancel", "Dialog btn cancel");
            });
        return builder.show();
    }

    public void fullScreen() {
        Intent intent = new Intent(getApplicationContext(), FullScreen.class);
        startActivity(intent);
    }
}