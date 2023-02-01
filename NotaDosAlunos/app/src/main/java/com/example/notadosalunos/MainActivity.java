package com.example.notadosalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void moveToApproved(View view) {
        Intent moveToApprovedIntent = new Intent(MainActivity.this,ApprovedStudentActivity.class);
        startActivity(moveToApprovedIntent);
    }

    public void moveToExam(View view) {
        Intent moveToExamIntent = new Intent(MainActivity.this,ExamStudentActivity.class);
        startActivity(moveToExamIntent);
    }

    public void moveToRegister(View view) {
        Intent moveToRegisterIntent = new Intent(MainActivity.this,RegisterStudentActivity.class);
        startActivity(moveToRegisterIntent);
    }
}