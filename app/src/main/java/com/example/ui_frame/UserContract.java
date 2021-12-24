package com.example.ui_frame;

import android.provider.BaseColumns;

public class UserContract {
    private UserContract() {
    }

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "USER";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_PW = "PW";
        public static final String COLUMN_TYPE = "USER_TYPE";
        public static final String COLUMN_RATE = "RATE";
        public static final String COLUMN_VOL_TIME = "TIME";
        public static final String COLUMN_VOL_COUNT = "COUNT";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_ID + " TEXT," +
                COLUMN_PW + " INTEGER," +
                COLUMN_TYPE + " TEXT," +
                COLUMN_RATE + " TEXT," +
                COLUMN_VOL_TIME + " TEXT," +
                COLUMN_VOL_COUNT + " TEXT)";

        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
