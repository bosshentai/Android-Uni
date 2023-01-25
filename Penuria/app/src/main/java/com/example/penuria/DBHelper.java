package com.example.penuria;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String nameDB = "AgendaContacto.db";

    String [] sql = {
            "CREATE TABLE contacto (id INTEGER AUTO_INCREMENT PRIMARY KEY,nome TEXT,morada TEXT,telemovel TEXT,sexo TEXT,email TEXT);",
            "INSERT INTO contacto VALUES(1,'Maria','Vila Nova','993 41 48','Fiminino','maria@gmail.com');"

    };


    public DBHelper(@Nullable Context context) {
        super(context, nameDB, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (int i = 0; i<sql.length; i++)
            sqLiteDatabase.execSQL(sql[i]);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        version++;
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacto;");
        onCreate(sqLiteDatabase);
    }

    public long Insert_Contacto(String nome, String morada, String telemovel, String sexo, String email){

        SQLiteDatabase db = this.getWritableDatabase(); //Operacao de escrita em cima da base
//        db.open()
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("morada", morada);
        cv.put("telemovel", telemovel);
        cv.put("sexo", sexo);
        cv.put("email", email);

//        Log.d("123",""+cv);
        long id = db.insert("contacto",null,cv);

        db.close();
        return id;
//        return db.insert("contacto", null, cv);
    }
}
