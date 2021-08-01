package com.example.schoolbus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_USER_FIRSTNAME = "USER_FIRSTNAME";
    public static final String COLUMN_USER_LASTNAME = "USER_LASTNAME";
    public static final String COLUMN_USER_USERNAME = "USER_USERNAME";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_TEL = "USER_TEL";
    public static final String COLUMN_USER_CREATED = "USER_CREATED";

    public static final String STUDENT_TABLE = "STUDENT_TABLE";
    public static final String COLUMN_STU_ID = "STU_ID";
    public static final String COLUMN_STU_FIRSTNAME = "STU_FIRSTNAME";
    public static final String COLUMN_STU_LASTNAME = "STU_LASTNAME";
    public static final String COLUMN_STU_IMAGE = "STU_IMAGE";
    public static final String COLUMN_STU_ADDRESS = "STU_ADDRESS";
    public static final String COLUMN_STU_SCHOOL = "STU_SCHOOL";
    public static final String COLUMN_STU_CREATED = "STU_CREATED";

    private static final String createTableUser = "CREATE TABLE " + USER_TABLE + "(" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_FIRSTNAME + " TEXT, " + COLUMN_USER_LASTNAME + " TEXT, " + COLUMN_USER_USERNAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_TEL + " TEXT, " + COLUMN_USER_CREATED + " TIMESTAMP)";
    private static final String createTableStudent = "CREATE TABLE " + STUDENT_TABLE + " (" + COLUMN_STU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_STU_FIRSTNAME + " TEXT, " + COLUMN_STU_LASTNAME + " TEXT, " + COLUMN_STU_IMAGE + " TEXT, " + COLUMN_STU_ADDRESS + " TEXT, " + COLUMN_STU_SCHOOL + " TEXT, " + COLUMN_USER_ID + " INTEGER, " + COLUMN_STU_CREATED + " TIMESTAMP)";

    public Database(@Nullable Context context) {
        super(context, "schoolbus.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTableUser);
        db.execSQL(createTableStudent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS '" + USER_TABLE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + STUDENT_TABLE + "'");
        onCreate(db);

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

    public boolean addOne(StudentModel studentModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STU_FIRSTNAME, studentModel.getStu_firstname());
        cv.put(COLUMN_STU_LASTNAME, studentModel.getStu_lastname());
        cv.put(COLUMN_STU_IMAGE, studentModel.getStu_image());
        cv.put(COLUMN_STU_ADDRESS, studentModel.getStu_address());
        cv.put(COLUMN_STU_SCHOOL, studentModel.getStu_school());
        cv.put(COLUMN_STU_CREATED, studentModel.getStu_created());

        long insert = db.insert(STUDENT_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public List<StudentModel> getStudent(){
        List<StudentModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + STUDENT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            do {
                int stuId = cursor.getInt(0);
                String stuFirstname = cursor.getString(1);
                String stuLastname = cursor.getString(2);
                String stuImage = cursor.getString(3);
                String stuAddress = cursor.getString(4);
                String stuSchool = cursor.getString(5);
                int userId = cursor.getInt(6);
                String stuCreated = cursor.getString(7);

                StudentModel newStudent = new StudentModel(stuId, stuFirstname, stuLastname, stuImage, stuAddress, stuSchool, userId, stuCreated);
                returnList.add(newStudent);
            }while (cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;
    }
}
