package com.example.ui_frame;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainMyPageActivity extends AppCompatActivity {
    private String id;
    private UserContractDBHelper userContractDBHelper;

    private TextView UserID;
    private TextView Rate;
    private TextView VolCount;
    private TextView VolTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_mypage);
        Intent intent = getIntent();
        id = intent.getStringExtra("ID").toString();

        userContractDBHelper = new UserContractDBHelper(this);

        UserID = findViewById(R.id.Mypage_userIdTextView);
        Rate = findViewById(R.id.Mypage_userRateTextView);
        VolCount = findViewById(R.id.Mypage_userVolCount);
        VolTime = findViewById(R.id.Mypage_userVolTime);

        Cursor cursor = userContractDBHelper.readRecordOrderByID();
        while(cursor.moveToNext()) {
            String ID = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_ID));

            if(id.equals(ID)) {
                UserID.setText(ID);
                Rate.setText(cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_RATE)));
                VolCount.setText(cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_VOL_COUNT)));
                VolTime.setText(cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_VOL_TIME)));
                break;
            }
        }

    }

    public void Mypage_backButtonClick(View view) {
        Intent intent = new Intent(this, MainActivityPrivate.class);
        startActivity(intent);
        finish();
    }
}
