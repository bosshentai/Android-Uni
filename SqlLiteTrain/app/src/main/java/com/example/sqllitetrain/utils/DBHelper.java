package com.example.sqllitetrain.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private String TABLE_CONTACT_NAME = "contact";
    private String CONTACT_COLUMN_FULLNAME = "fullname";
    private String CONTACT_COLUMN_EMAIL = "email";
    private String CONTACT_COLUMN_BIRTH = "birth";
    private String CONTACT_COLUMN_PHONENUMBER = "phoneNumber";
    private String CONTACT_COLUMN_SEX = "sex";
    private String CONTACT_COLUMN_FAV = "fav";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version ){
        super(context,name,factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS employees (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "name TEXT NOT NULL,email TEXT NOT NULL, phone TEXT NOT NULL, cni TEXT NOT NULL,nif TEXT NOT NULL);");
    sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS contact  (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "fullname TEXT, email TEXT, birth TEXT, phoneNumber TEXT, sex TEXT, fav BOOLEAN);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // insert employees

    public void addContact(String name, String email,  String phone, String cni, String nif){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        db.execSQL("INSERT INTO employees VALUES(null, '"+ name + "'," +email +")");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_CONTACT_NAME + "(" + CONTACT_COLUMN_FULLNAME +
                ","+ CONTACT_COLUMN_EMAIL +") VALUES()");
    }


}
