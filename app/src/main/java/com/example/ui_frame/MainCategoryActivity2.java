package com.example.ui_frame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainCategoryActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);
    }

    public void Category1_backButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // 현재 MainCategoryActivity2를 정의할 내용이 없기 때문에 MainCategoryActivity1과 동일한 기능을 하도록 구현
    public void categoryButton1Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "category_name_1");
        startActivity(intent);
    }

    public void categoryButton2Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "category_name_2");
        startActivity(intent);
    }

    public void categoryButton3Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "category_name_3");
        startActivity(intent);
    }

    public void categoryButton4Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "category_name_4");
        startActivity(intent);
    }

    public void categoryButton5Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "category_name_5");
        startActivity(intent);
    }

    public void categoryButton6Click(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", "category_name_6");
        startActivity(intent);
    }

}
