package com.example.sqllitetrain.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version ){
        super(context,name,factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS employees (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL,email TEXT NOT NULL, phone TEXT NOT NULL, cni TEXT NOT NULL,nif TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // insert employees

    public void addEmployee(String name, String email,  String phone, String cni, String nif){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO employees VALUES(null, '"+ name + "'," +email +")");
    }


}
