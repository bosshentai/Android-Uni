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

//public interface StudentDeleteListener{
//    void onStudentDelete();
//}

public class ApprovedStudentActivity extends AppCompatActivity {


    private ArrayList<Student> listStudent;

    private RecyclerView approvedStudentRecycleView;

//    private StudentDeleteListener deleteListener;



    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved_student);
        getSupportActionBar().setTitle(R.string.approved_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = new DBHelper(this);

        listStudent = new ArrayList<>();

        approvedStudentRecycleView = findViewById(R.id.approvedStudentRecycleView);


        setStudentList();

        ApprovedStudentAdapter adapter = new ApprovedStudentAdapter(this,listStudent);


//
        approvedStudentRecycleView.setAdapter(adapter);
        approvedStudentRecycleView.setLayoutManager(new LinearLayoutManager(this));
//
//        approvedStudentRecycleView.setStudentDeleteListener(new ApprovedStudentAdapter.StudentDeleteListener(){
//
//        });

    }



    private void setStudentList(){


        Cursor c  = db.selectAllStudent();
//
        c.moveToFirst();
        if(c.getCount()>0){
            listStudent.clear();

            do{

                int id = c.getInt(0);
                String name = c.getString(1);
//                float grade1 = c.getFloat(2);
//                float grade2 = c.getFloat(3);
                float finalGrade = c.getFloat(4);

                if(finalGrade >= 12 ){
                    Log.d("123", String.valueOf(finalGrade));
                    listStudent.add(new Student(id,name,finalGrade));
                }
            }while(c.moveToNext());
        }
    }





//    @Override
//    protected void onResume() {
//        super.onResume();
//        setStudentList();
//        ApprovedStudentAdapter adapter = new ApprovedStudentAdapter(this,listStudent);
////
//        approvedStudentRecycleView.setAdapter(adapter);
//        approvedStudentRecycleView.setLayoutManager(new LinearLayoutManager(this));
//    }


}