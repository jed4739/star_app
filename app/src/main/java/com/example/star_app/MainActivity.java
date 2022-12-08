package com.example.star_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.star_app.databinding.Main;

/**
* 구현 기능 목록
* 1. Splash 의 sec(스플래시 초 객체)에 다이어로그 정수값을 입력시킬 방법 찾기 - 완
* 2. 이미지 클릭 시 사진 전체화면 - 완
* 3. 사진전체화면 후에는 뒤로가기 버튼 - 완
* 4. 이미지 줌인 줌 아웃 - 완
* 5. 트와이스까지 총 16명 이미지 생성 - 완
* */
public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Main binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        /*
         * SharedPreferences
         * Map 형식으로 key, value 형식으로 반환
         * 값을 수정할 수 있게 Editor 를 통해서 인터페이스의 새 인스턴스를 반환
         * */
        sharedPreferences = getSharedPreferences("data", 0);
        editor = sharedPreferences.edit();

        binding.dialogButton.setOnClickListener(v -> SplashDialog());

        imgViewOnclick();
    }

    /*
     * SPLASH DIALOG
     * setPositiveButton
     * 1. dialog.xml 에서 숫자만 받기로 명시되어 있지만 빈칸을 막기위해 예외처리를 함.
     * 2. SharedPreferences 의 인스턴스에 저장하여 어플리케이션이 종료되어도 값이 저장되어있도록 함.
     *
     * setNegativeButton
     * - dialog 가 종료.
     *
     * setNeutralButton
     * - 기본값이 3초라는 것을 강조하기위해 리셋버튼을 생성함.
     * */
    public void SplashDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
            .setTitle("출력할 스플래시 시간을 입력해주세요.")
            .setView(R.layout.dialog)
            .setPositiveButton("확인", (dialog, which) -> {
                try {
                    Dialog f = (Dialog) dialog;
                    EditText input = f.findViewById(R.id.edit_dialog);
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
                    Toast.makeText(getApplicationContext(),"다시 입력해주세요!", Toast.LENGTH_LONG).show();
                }
            })
            .setNegativeButton("취소", (dialog, which) -> dialog.dismiss())
            .setNeutralButton("초기화", (dialog, which) -> {
                editor.putInt("input_num", 3);
                editor.commit();
                Toast.makeText(getApplicationContext(), "기본값(3초)으로 초기화 되었습니다.",Toast.LENGTH_SHORT).show();
            });
        builder.show();
    }

    /*
    * 이미지를 클릭할 시
    * 이미지의 순서에 맞는 번호를 fullScreen 메소드로 넘김
    * */
    public void imgViewOnclick() {
        ImageView[] btn = {binding.bts1, binding.bts2, binding.bts3, binding.bts4, binding.bts5, binding.bts6, binding.bts7, binding.twice1, binding.twice2, binding.twice3, binding.twice4, binding.twice5, binding.twice6, binding.twice7, binding.twice8, binding.twice9};
        for (int i = 0; i < btn.length; i++) {
            int j = i+1;
            btn[i].setOnClickListener(v -> fullScreen(j));
        }
    }

    /*
     * onCreate 메소드에게서 이미지뷰의 순서를 기준으로 하는 번호를 매개변수로 받음.
     * 매개변수로 받은 값은 FullScreen.java 로 넘김.
     * */
    public void fullScreen(int i) {
        Intent intent = new Intent(getApplicationContext(), FullScreen.class);
        intent.putExtra("data", i);
        startActivity(intent);
    }
}