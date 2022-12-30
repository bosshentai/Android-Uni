package com.example.tpc2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Register extends AppCompatActivity {

    private static final String TAG = Register.class.getName();

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText birthEditText;
    private EditText passwordConfirmEditText;

    DatePickerDialog.OnDateSetListener setDataListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameEditText = (EditText) findViewById(R.id.name_input);
        emailEditText = (EditText) findViewById(R.id.email_input);
        passwordEditText = (EditText) findViewById(R.id.password_input);
        birthEditText = (EditText) findViewById(R.id.birth_input);
        passwordConfirmEditText = (EditText) findViewById(R.id.confirm_password_input);


        Calendar calender = Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);
        final int day = calender.get(Calendar.DAY_OF_MONTH);

        birthEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        birthEditText.setText(date);
                    }
                }, year, month, day
                );
                datePickerDialog.show();
            }
        });

    }

    private void ToastDisplay(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void RegisterPerson(View view) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String birth = birthEditText.getText().toString();
        String passwordConfirm = passwordConfirmEditText.getText().toString();

        Boolean isNameValid = name.isEmpty();
        Boolean isEmailEmpty = email.isEmpty();
        Boolean isEmailValid = isEmailValid(email) == false;
        Boolean isBirthEmpty = birth.isEmpty();

        if (isNameValid) {
            ToastDisplay("Empty name");
            return;
        }

        if (isEmailEmpty) {
            ToastDisplay("Empty email");
            return;
        }

        if (isEmailValid) {
            ToastDisplay("Invalid Email");
            return;
        }

        if (isBirthEmpty){
            ToastDisplay("Empty Birth");
            return;
        }


    }


    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isDateValid(String date) {

        return false;
    }

    public void moveToMain(View view) {
        finish();
    }





}