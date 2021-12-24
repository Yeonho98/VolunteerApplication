package com.example.ui_frame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class UserContractDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database";
    public static final int DATABASE_VERSION = 1;

    public UserContractDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserContract.UserEntry.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(UserContract.UserEntry.SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    void insertRecord(String ID, String PW, String TYPE, String RATE, String TIME, String COUNT) {
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.COLUMN_ID, ID);
        values.put(UserContract.UserEntry.COLUMN_PW, PW);
        values.put(UserContract.UserEntry.COLUMN_TYPE, TYPE);
        values.put(UserContract.UserEntry.COLUMN_RATE, RATE);
        values.put(UserContract.UserEntry.COLUMN_VOL_TIME, TIME);
        values.put(UserContract.UserEntry.COLUMN_VOL_COUNT, COUNT);

        db.insert(UserContract.UserEntry.TABLE_NAME, null, values);
    }

    public Cursor readRecordOrderByID() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                UserContract.UserEntry.COLUMN_ID,
                UserContract.UserEntry.COLUMN_PW,
                UserContract.UserEntry.COLUMN_TYPE,
                UserContract.UserEntry.COLUMN_RATE,
                UserContract.UserEntry.COLUMN_VOL_COUNT,
                UserContract.UserEntry.COLUMN_VOL_TIME
        };

        String sortOrder = UserContract.UserEntry.COLUMN_ID + " DESC";

        Cursor cursor = db.query(
                UserContract.UserEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        return cursor;
    }
}
