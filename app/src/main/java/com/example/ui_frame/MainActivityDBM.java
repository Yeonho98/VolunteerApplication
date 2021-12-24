package com.example.ui_frame;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDBM extends AppCompatActivity {
    private UserContractDBHelper userContractDBHelper;
    private OrganizationDBHelper organizationDBHelper;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dbm);

        textView = findViewById(R.id.textView);
        userContractDBHelper = new UserContractDBHelper(this);
        organizationDBHelper = new OrganizationDBHelper(this);
    }

    private void userContract_printTable() {
        Cursor cursor = userContractDBHelper.readRecordOrderByID();
        String result = "";

        result += "row 개수 : " + cursor.getCount() + "\n";
        while(cursor.moveToNext()) {
            int itemId = cursor.getInt(cursor.getColumnIndexOrThrow(UserContract.UserEntry._ID));
            String ID = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_ID));
            String PW = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_PW));
            String TYPE = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_TYPE));
            String RATE = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_RATE));
            String VOL_TIME = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_VOL_TIME));
            String VOL_COUNT = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_VOL_COUNT));

            result += itemId + " " + ID + " " + PW + " " + TYPE + " \n" + RATE + " " + VOL_TIME + " " + VOL_COUNT + "\n";
        }

        textView.setText(result);
        cursor.close();
    }

    @Override
    protected void onDestroy() {
        userContractDBHelper.close();
        super.onDestroy();
    }

    public void userContract_printDbButtonClick(View view){
        userContract_printTable();
    }


    public void userContract_setDbButtonClick(View view) {
        userContractDBHelper.insertRecord("Example_ID1", "Example_PW1", "Example_Type1", "Example_Rate", "Example_Time", "Example_count");
        userContractDBHelper.insertRecord("Example_ID2", "Example_PW2", "Example_Type2", "Example_Rate", "Example_Time", "Example_count");
        userContractDBHelper.insertRecord("Example_ID3", "Example_PW3", "Example_Type3", "Example_Rate", "Example_Time", "Example_count");
        userContractDBHelper.insertRecord("Example_ID4", "Example_PW4", "Example_Type4", "Example_Rate", "Example_Time", "Example_count");
    }

    public void userContract_initDbButtonClick(View view) {
        SQLiteDatabase sqlDB = userContractDBHelper.getWritableDatabase();
        userContractDBHelper.onUpgrade(sqlDB, 1, 2);
        sqlDB.close();
    }

    public void publicPrintDBClick(View view) {
        Cursor cursor = organizationDBHelper.readRecordOrderByID();
        String result = "";

        result += "row 개수 : " + cursor.getCount() + "\n";
        while(cursor.moveToNext()) {
            int itemId = cursor.getInt(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo._ID));
            String ID = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ID));
            String SPON_INFO = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_SPON_INFO));
            String REVIEW = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_REVIEW));
            String RESERVATION = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_RESERVATION));
            String IMAGE = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_IMAGE));

            result += itemId + " " + ID + " " + SPON_INFO + " " + REVIEW + " \n";
        }

        textView.setText(result);
        cursor.close();

    }

    public void publicDbSetButtonClick(View view) {
        organizationDBHelper.insertRecord("Example_ID1", "Example_INFO1", "Example_SPONINFO1", "", "", "", "", "", "", "");
        organizationDBHelper.insertRecord("Example_ID2", "Example_INFO2", "Example_SPONINFO2", "", "", "", "", "", "", "");
        organizationDBHelper.insertRecord("Example_ID3", "Example_INFO3", "Example_SPONINFO3", "", "", "", "", "", "", "");
        organizationDBHelper.insertRecord("Example_ID4", "Example_INFO4", "Example_SPONINFO4", "", "", "", "", "", "", "");
    }

    public void publicInitDbButtonClick(View view) {
        SQLiteDatabase sqlDB = organizationDBHelper.getWritableDatabase();
        organizationDBHelper.onUpgrade(sqlDB, 1, 2);
        sqlDB.close();
    }

}
