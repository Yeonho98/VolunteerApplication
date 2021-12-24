package com.example.ui_frame;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CategoryOrganizationList extends AppCompatActivity {

    private OrganizationDBHelper organizationDBHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_organizationlist);

        organizationDBHelper = new OrganizationDBHelper(this);

        TextView categoryName = findViewById(R.id.CategoryList_categoryNameTextView);
        Intent getCategoryName = getIntent();


        String message = getCategoryName.getStringExtra("Category_name").toString();
        categoryName.setText(message);


        // Intent를 통해 받아온 값을 DB에 전달한 후 list를 생성해야함
        // (불러올 Category_name은 message에 저장됨)

        // 버튼 동적 생성

        Cursor cursor = organizationDBHelper.readRecordOrderByID();

        int same_category_count = 0;
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        int sameCategoryCount = 0;
        while(cursor.moveToNext()){
            String ID = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ID));
            String NAME = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_NAME));
            String CATEGORY = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_CATEGORY));

            if (message.equals(CATEGORY)){
                id.add(ID);
                name.add(NAME);
                sameCategoryCount += 1;
            }
        }

        Log.w("please",  Integer.toString(sameCategoryCount));

        final LinearLayout lm = (LinearLayout) findViewById(R.id.ll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        for(int j = 1; j < sameCategoryCount + 1; ++j){
            Log.w("J : ",  Integer.toString(j));

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            final Button OrganizationList = new Button(this);
            OrganizationList.setId(j);
            OrganizationList.setText(name.get(j - 1));
            OrganizationList.setLayoutParams(params);
            OrganizationList.setGravity(Gravity.CENTER);

            int finalJ = j;
            OrganizationList.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(view.getContext(), IndividualOrganization.class);
                    intent.putExtra("ID", id.get(finalJ - 1));
                    startActivity(intent);
                }
            });

            ll.addView(OrganizationList);
            lm.addView(ll);
        }

    }

    public void CategoryList_backButtonClick(View view) {
        Intent intent = new Intent(this, MainCategoryActivity1.class);
        startActivity(intent);
        finish();
    }

}
