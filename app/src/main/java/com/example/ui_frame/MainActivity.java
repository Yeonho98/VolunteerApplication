package com.example.ui_frame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText main_idInputEditText;
    private EditText main_pwInputEditText;
    private UserContractDBHelper userContractDbHelper;
    private OrganizationDBHelper organizationDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_idInputEditText = findViewById(R.id.main_idInputEditText);
        main_pwInputEditText = findViewById(R.id.main_pwInputEditText);
        userContractDbHelper = new UserContractDBHelper(this);
        organizationDBHelper = new OrganizationDBHelper(this);
    }


    public void LoginButtonClick(View view) {
        Cursor cursor = userContractDbHelper.readRecordOrderByID();
        String result = "";
        boolean success = false;

        result += "row 개수 : " + cursor.getCount() + "\n";
        while(cursor.moveToNext()) {
            int itemId = cursor.getInt(cursor.getColumnIndexOrThrow(UserContract.UserEntry._ID));
            String ID = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_ID));
            String PW = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_PW));
            String TYPE = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_TYPE));

            if (main_idInputEditText.getText().toString().equals(ID) && main_pwInputEditText.getText().toString().equals(PW)) {
                success = true;

                if (TYPE.toString().equals("Private")) {
                    Intent intent = new Intent(this, MainActivityPrivate.class);
                    intent.putExtra("ID", ID);
                    startActivity(intent);
                }

                else {
                    Intent intent = new Intent(this, MainActivityPublic.class);
                    intent.putExtra("ID", ID);

                    organizationDBHelper.insertRecord(ID, null, null, null, null, null, null, null, null, null);

                    startActivity(intent);
                }
            }
        }

        if (success == false) {
            TextView textView = findViewById(R.id.main_textView);
            textView.setText("로그인 실패!");
        }
    }

    public void SignUpButtonClick(View view) {
        Intent intent = new Intent(this, MainActivityContract.class);
        startActivity(intent);
    }

    public void DBManageButtonClick(View view) {
        Intent intent = new Intent(this, MainActivityDBM.class);
        startActivity(intent);
    }
}