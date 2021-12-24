package com.example.ui_frame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPrivate extends AppCompatActivity {
    private String ID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_private);
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID").toString();
    }

    // 현재 분류할 목록이 없으므로 Categorical Button 1, 2 같은 기능을 하도록 구현
    // Categorical Button 1 또는 Categorical Button 2를 클릭했을 때,
    // Category_main1 으로 이동 (추후 변경사항이 생길시 Category_main2, ... 로 생성)

    public void CategoryButton1Click(View view){
        Intent intent = new Intent(this, MainCategoryActivity1.class);
        startActivity(intent);
    }

    public void CategoryButton2Click(View view){
        Intent intent = new Intent(this, MainCategoryActivity2.class);
        startActivity(intent);
    }

    public void MyPageButtonClick(View view){
        Intent intent = new Intent(this, MainMyPageActivity.class);
        intent.putExtra("ID", ID);
        startActivity(intent);
    }

}
