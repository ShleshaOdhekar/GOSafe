package com.example.gosafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    public static final String u = "user";
    public static final String e = "email";
    public static final String p= "password";

    public DataHelper(@Nullable Context context) {

        super(context, "login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table user(email text primary key,password text )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ u);


    }
    public Boolean insert(String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1) return false;
        else  return true;
    }

    public Boolean chkemail(String email,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select email from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)
            return false;
        else
            return true;

    }

    public boolean updatepass(String email,String passwor) {


        SQLiteDatabase db = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
        contentValues.put("e",email);
        contentValues.put("p", passwor);
//
//
        db.update("u", contentValues, "email =?", new String[]{e});
//
       if(p==passwor) {
           Log.d("new","mani");
           return true;
       }
       else {
           Log.d("new","megha");
           return false;

       }

        //Log.d("myyy", "mistake");
       // Toast.makeText( getApplicationContext(),reset successful", Toast.LENGTH_LONG).show();

//        Cursor cur=db.rawQuery("UPDATE "+ "user" +" SET " + "password"+ " = "+"passwor"+"WHERE "+ "email"=emai, new String[]{email});
//        db.rawQuery("UPDATE"+"user"+"SET"+"password"+"="+passwor+"WHERE"+"email"+"="+emai );
//        if (cur != null)
//        {
//            if(cur.getCount() > 0)
//            {
//                return true;
//            }
//        }
//    return false;


    }}