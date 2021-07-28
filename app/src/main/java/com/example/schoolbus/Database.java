package com.example.schoolbus;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_USER_FIRSTNAME = "USER_FIRSTNAME";
    public static final String COLUMN_USER_LASTNAME = "USER_LASTNAME";
    public static final String COLUMN_USER_USERNAME = "USER_USERNAME";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_TEL = "USER_TEL";
    public static final String COLUMN_USER_CREATED = "USER_CREATED";

    public Database(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + USER_TABLE + "(" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_FIRSTNAME + " TEXT, " + COLUMN_USER_LASTNAME + " TEXT, " + COLUMN_USER_USERNAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_TEL + " TEXT, " + COLUMN_USER_CREATED + " TIMESTAMP)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(UserModel userModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_FIRSTNAME, userModel.getUser_firstname());
        cv.put(COLUMN_USER_LASTNAME, userModel.getUser_lastname());
        cv.put(COLUMN_USER_USERNAME, userModel.getUser_username());
        cv.put(COLUMN_USER_PASSWORD, userModel.getUser_password());
        cv.put(COLUMN_USER_TEL, userModel.getUser_tel());
        cv.put(COLUMN_USER_CREATED, userModel.getUser_created());

        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
