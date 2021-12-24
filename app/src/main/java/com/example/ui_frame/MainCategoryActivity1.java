package com.example.ui_frame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainCategoryActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category1);
    }

    public void Category1_backButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // 하위 화면 생성을 줄이기 위해 버튼이 클릭됬을 때
    // 어떤 버튼이 클릭 됬는지 정보를 하나의 동일한 클래스에 전달
    // (Intent를 통해 화면 전환시 1번 버튼이 눌렸으므로 if, else를 통해 해당하는 화면만 가져오기)
    // 2번이 눌렸을 경우 2번 카테고리에 해당하는 자료 가져온 후 화면에 띄우기, 3.. , 4.. ~~
    public void categoryButton1Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "공공기관");
        startActivity(intent);
    }

    public void categoryButton2Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "민간시설");
        startActivity(intent);
    }

    public void categoryButton3Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "민간기관");
        startActivity(intent);
    }

    public void categoryButton4Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "기업체");
        startActivity(intent);
    }

    public void categoryButton5Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "행정기관");
        startActivity(intent);
    }

}
