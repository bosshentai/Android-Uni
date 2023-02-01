package com.example.notadosalunos.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.notadosalunos.models.Student;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    private static int version = 1;
    private static String dbName = "uni.db";


    private String TABLE_STUDENT_NAME = "students";
    private String STUDENT_COLUMN_NAME = "fullName";
    private String STUDENT_COLUMN_GRADE1 = "firstGrade";
    private String STUDENT_COLUMN_GRADE2 = "secondGrade";
    private String STUDENT_COLUMN_FINALGRADE = "finalGrade";

    public DBHelper(@Nullable Context context) {
        super(context, dbName, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_STUDENT_NAME + " (\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  " + STUDENT_COLUMN_NAME + " TEXT NOT NULL,\n" +
                "  " + STUDENT_COLUMN_GRADE1 + " TEXT NOT NULL,\n" +
                "  " + STUDENT_COLUMN_GRADE2 + " TEXT NOT NULL,\n" +
                "  " + STUDENT_COLUMN_FINALGRADE + " TEXT NOT NULL\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public long InsertStudent(String name, String grade1, String grade2, String finalGrade) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues studentInfo = new ContentValues();
        studentInfo.put(STUDENT_COLUMN_NAME, name);
        studentInfo.put(STUDENT_COLUMN_GRADE1, grade1);
        studentInfo.put(STUDENT_COLUMN_GRADE2, grade2);
        studentInfo.put(STUDENT_COLUMN_FINALGRADE, finalGrade);

        long insertId = db.insert(TABLE_STUDENT_NAME, null, studentInfo);

        return insertId;


//        return 1;

    }

    public long deleteStudent(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_STUDENT_NAME, "id=?", new String[]{String.valueOf(id)});
    }

    public Cursor selectAllStudent() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM students", null);
    }


//    public ArrayList<Student> getApprovedStudents(){
//        ArrayList<Student> students = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_STUDENT_NAME + " WHERE grade >= 12.0", null);
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(0);
//                String name = cursor.getString(1);
//                float grade1 = cursor.getFloat(2);
//                float grade2 = cursor.getFloat(3);
//                float avg = cursor.getFloat(4);
////                students.add(new Student(id, name, grade1, grade2, avg));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return students;
//
////        return
//    }
}
