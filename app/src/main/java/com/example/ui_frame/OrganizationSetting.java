package com.example.ui_frame;

import android.provider.BaseColumns;

public class OrganizationSetting {
    private OrganizationSetting() {
    }

    public static class OrganizationInfo implements BaseColumns {
        public static final String TABLE_NAME = "Organization";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_ORGANIZATION_NAME = "ORGANIZATION_NAME";
        public static final String COLUMN_ORGANIZATION_INFO = "ORGANIZATION_INFO";
        public static final String COLUMN_SPON_INFO = "SPON_INFO";
        public static final String COLUMN_REVIEW = "REVIEW";
        public static final String COLUMN_RESERVATION = "RESERVATION";
        public static final String COLUMN_IMAGE = "IMAGE";
        public static final String COLUMN_PHONENUMBER = "PHONE";
        public static final String COLUMN_ADDRESS = "ADDRESS";
        public static final String COLUMN_ORGANIZATION_CATEGORY = "CATEGORY";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_ID + " TEXT," +
                COLUMN_ORGANIZATION_NAME + " TEXT," +
                COLUMN_ORGANIZATION_INFO + " TEXT," +
                COLUMN_SPON_INFO + " TEXT," +
                COLUMN_REVIEW + " TEXT," +
                COLUMN_RESERVATION + " TEXT," +
                COLUMN_PHONENUMBER + " TEXT," +
                COLUMN_ADDRESS + " TEXT," +
                COLUMN_ORGANIZATION_CATEGORY + " TEXT," +
                COLUMN_IMAGE + " TEXT)";

        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
