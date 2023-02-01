package com.example.notadosalunos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notadosalunos.models.Student;
import com.example.notadosalunos.util.DBHelper;

public class RegisterStudentActivity extends AppCompatActivity {

    private Button btnAdd, btnCancel;
    private EditText nameEditText, score1EditText, score2EditText;

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        btnAdd = findViewById(R.id.btn_add_student);
        btnCancel = findViewById(R.id.btn_cancel);

        nameEditText = findViewById(R.id.register_student_name);
        score1EditText = findViewById(R.id.register_student_score1);
        score2EditText = findViewById(R.id.register_student_score2);

        db = new DBHelper(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerStudent();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelRegister();
            }
        });
    }

    private void cancelRegister() {
        AlertDialog.Builder cancelAlertBuilder = new AlertDialog.Builder(RegisterStudentActivity.this);

        cancelAlertBuilder.setTitle(R.string.alert_title);
        cancelAlertBuilder.setMessage(R.string.alert_message);

        cancelAlertBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        cancelAlertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        cancelAlertBuilder.show();
    }

    private void registerStudent() {
        String name = nameEditText.getText().toString();
        String grade1 = score1EditText.getText().toString();
        String grade2 = score2EditText.getText().toString();

        Boolean isNameEmpty = name.isEmpty();
        Boolean isGrade1Empty = grade1.isEmpty();
        Boolean isGrade2Empty = grade2.isEmpty();

        Boolean isNameValid = nameValid(name);
        Boolean isGrade1Valid = gradeValid(grade1);
        Boolean isGrade2Valid = gradeValid(grade2);

        Boolean isFormOk = !isNameEmpty && !isGrade1Empty && !isGrade2Empty && isNameValid &&
                isGrade1Valid && isGrade2Valid;


        if (isNameEmpty) {
            toastDisplay(getString(R.string.toast_name_empty));
            return;
//            Toast.makeText(this,R.string.toast_name_empty,Toast.LENGTH_SHORT).show();
        }

        if (isGrade1Empty) {
            toastDisplay(getString(R.string.toast_first_grade_empty));
            return;
        }

        if (isGrade2Empty) {
            toastDisplay(getString(R.string.toast_second_grade_empty));
            return;
        }


        if (!isNameValid) {
            toastDisplay(getString(R.string.toast_name_invalid));
            return;
        }

        if (!isGrade1Valid) {
            toastDisplay(getString(R.string.toast_first_grade_invalid));
            return;
        }

        if (!isGrade2Valid) {
            toastDisplay(getString(R.string.toast_second_grade_invalid));
            return;
        }


        if (isFormOk) {

            if (db != null) {

                String finalGrade = String.valueOf(((Float.valueOf(grade1) + Float.valueOf(grade2)) / 2));

                Log.d("123", finalGrade);
                long res = db.InsertStudent(name, grade1, grade2, finalGrade);

                if (res > 0) {
                    finish();
                } else {
                    toastDisplay(getString(R.string.problem_insert_student));
                }

            } else {
                toastDisplay(getString(R.string.db_problem));
            }
        }
    }


    protected void toastDisplay(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected boolean nameValid(String name) {
        return name.matches("^[a-zA-Z\\s]+$");
    }

    protected boolean gradeValid(String number) {
        if (!number.isEmpty()) {
            return Float.valueOf(number) >= 0 && Float.valueOf(number) <= 20;
        }
        return false;
    }
}