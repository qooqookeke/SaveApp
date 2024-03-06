package com.qooke.saveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editSentence;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSentence = findViewById(R.id.editSentence);
        btnSave = findViewById(R.id.btnSave);

        // 만약에 앱 내 저장소에 데이터가 저장되어 있으면, editSentence에 보여주고
        // 저장된 데이터가 없으면 그냥 빈 문자열로 보여주자
        // 데이터 가져오기
        SharedPreferences sp = getSharedPreferences("save_app", MODE_PRIVATE);
        String sentence = sp.getString("sentence", "");

        // 데이터 보여주기
        editSentence.setText(sentence);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 앱 내 저장소에 저장한다.
                String sentence = editSentence.getText().toString().trim();

                // 저장하는 코드
                SharedPreferences sp = getSharedPreferences("save_app", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("sentence", sentence);
                editor.apply();

                // 불러오는 코드

            }
        });
    }
}