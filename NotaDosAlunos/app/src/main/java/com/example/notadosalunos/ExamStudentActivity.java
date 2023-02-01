package com.example.notadosalunos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.example.notadosalunos.adapter.ApprovedStudentAdapter;
import com.example.notadosalunos.models.Student;
import com.example.notadosalunos.util.DBHelper;

import java.util.ArrayList;

public class ExamStudentActivity extends AppCompatActivity {

    private ArrayList<Student> studentList;

    private RecyclerView examStudentReccleView;

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_student);

        db = new DBHelper(this);

        studentList = new ArrayList<>();

        setStudentList();

        examStudentReccleView = findViewById(R.id.examStudentRecycleView);


        ApprovedStudentAdapter adapter = new ApprovedStudentAdapter(this,studentList);
//
        examStudentReccleView.setAdapter(adapter);

        examStudentReccleView.setLayoutManager(new LinearLayoutManager(this));

    }



    private void setStudentList(){


        Cursor c  = db.selectAllStudent();
//
        c.moveToFirst();
        if(c.getCount()>0){
            studentList.clear();

            do{
//                int id = c.getInt(c.getColumnIndex('id'));
//                String nome = c.getString(c.getColumnIndex("fullName"));
//                String firstGrade = c.getString(c.getColumnIndex("firstGrade"));

                int id = c.getInt(0);
                String name = c.getString(1);
//                float grade1 = c.getFloat(2);
//                float grade2 = c.getFloat(3);
                float finalGrade = c.getFloat(4);

                if(finalGrade < 12 ){
//                    Log.d("123", String.valueOf(finalGrade));
                    studentList.add(new Student(id,name,finalGrade));
                }
            }while(c.moveToNext());
        }
    }

}