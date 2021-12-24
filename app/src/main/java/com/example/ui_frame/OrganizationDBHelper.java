package com.example.ui_frame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class OrganizationDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database2";
    public static final int DATABASE_VERSION = 1;

    public OrganizationDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(OrganizationSetting.OrganizationInfo.SQL_CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(OrganizationSetting.OrganizationInfo.SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    void insertRecord(String ID, String NAME, String INFO, String SPON_INFO, String REVIEW, String RESERVATION, String IMAGE, String PHONE, String ADDRESS, String CATEGORY) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(OrganizationSetting.OrganizationInfo.COLUMN_ID, ID);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_INFO, INFO);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_SPON_INFO, SPON_INFO);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_REVIEW, REVIEW);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_RESERVATION, RESERVATION);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_IMAGE, IMAGE);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_NAME, NAME);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_PHONENUMBER, PHONE);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_ADDRESS, ADDRESS);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_CATEGORY, CATEGORY);

        db.insert(OrganizationSetting.OrganizationInfo.TABLE_NAME, null, values);
        this.close();
    }

    void updateRecord(String ID, String INFO, String SPON_INFO, String REVIEW, String RESERVATION, String IMAGE) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_INFO, INFO);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_SPON_INFO, SPON_INFO);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_REVIEW, REVIEW);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_RESERVATION, RESERVATION);
        values.put(OrganizationSetting.OrganizationInfo.COLUMN_IMAGE, IMAGE);

        db.update(OrganizationSetting.OrganizationInfo.TABLE_NAME, values, "ID=?", new String[] { ID });
        this.close();
    }

    void deleteRecord(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(OrganizationSetting.OrganizationInfo.TABLE_NAME, "ID=?", new String[] { ID });
        this.close();
    }

    public Cursor readRecordOrderByID() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                OrganizationSetting.OrganizationInfo.COLUMN_ID,
                OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_INFO,
                OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_NAME,
                OrganizationSetting.OrganizationInfo.COLUMN_SPON_INFO,
                OrganizationSetting.OrganizationInfo.COLUMN_REVIEW,
                OrganizationSetting.OrganizationInfo.COLUMN_RESERVATION,
                OrganizationSetting.OrganizationInfo.COLUMN_IMAGE,
                OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_CATEGORY,
                OrganizationSetting.OrganizationInfo.COLUMN_PHONENUMBER,
                OrganizationSetting.OrganizationInfo.COLUMN_ADDRESS
        };

        String sortOrder = OrganizationSetting.OrganizationInfo.COLUMN_ID + " DESC";

        Cursor cursor = db.query(
                OrganizationSetting.OrganizationInfo.TABLE_NAME,
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

