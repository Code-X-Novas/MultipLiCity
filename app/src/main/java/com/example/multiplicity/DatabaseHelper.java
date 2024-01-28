package com.example.multiplicity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName= "Signup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase Mydatabase) {
        Mydatabase.execSQL("create Table allusers(email TEXT primary key, password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydatabase, int oldVersion, int newVersion) {
        Mydatabase.execSQL("drop Table if exists allusers");
    }

    public Boolean insertData(String email,String password){
        SQLiteDatabase Mydatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = Mydatabase.insert("allusers", null,contentValues);
        if (result == -1) {
            return false;

        } else {
            return true;
        }
    }
    public boolean checkEmail(String email){
        SQLiteDatabase Mydatabse=this.getWritableDatabase();
        Cursor cursor = Mydatabse.rawQuery("Select * from allusers where email = ?", new String[]{email});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean checkEmailpassword(String email,String password){
        SQLiteDatabase Mydatabase=this.getWritableDatabase();
        Cursor cursor=Mydatabase.rawQuery("Select * from allusers where email= ? and password=?",new String[]{email,password});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}