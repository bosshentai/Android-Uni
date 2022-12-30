package com.example.tpc2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
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

    private void toastDisplay(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void RegisterPerson(View view) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String birth = birthEditText.getText().toString();
        String passwordConfirm = passwordConfirmEditText.getText().toString();

        Boolean isNameEmpty = name.isEmpty();
        Boolean isEmailEmpty = email.isEmpty();
        Boolean isEmailValid = isEmailValid(email);
        Boolean isBirthEmpty = birth.isEmpty();
        Boolean isPasswordEmpty = password.isEmpty();
        Boolean isConfirmPasswordEmpty = passwordConfirm.isEmpty();
        Boolean isPasswordsEquals = password.equals(passwordConfirm);
        Boolean isFormOk = !isNameEmpty && !isEmailEmpty && isEmailValid && !isBirthEmpty && !isPasswordEmpty && !isConfirmPasswordEmpty && isPasswordsEquals;


        if (isNameEmpty) {
            toastDisplay("Empty name");
            return;
        }

        if (isEmailEmpty) {
            toastDisplay("Empty email");
            return;
        }

        if (!isEmailValid) {
            toastDisplay("Invalid Email");
            return;
        }

        if (isBirthEmpty) {
            toastDisplay("Empty Birth");
            return;
        }
        if(isPasswordEmpty){
            toastDisplay("Empty Password");
            return;
        }

        if(isConfirmPasswordEmpty){
            toastDisplay("Empty Confirm Password");
            return;
        }

        if (!isPasswordsEquals){
            toastDisplay("Not match password");
            return;
        }

        for(int i = 0; i < Db.userList.size();i++){
            User user = Db.userList.get(i);
            if(email.equals(user.getEmail())){
                toastDisplay("Email already used");
                return;
            }
        }

        if(isFormOk){
            Db.userList.add(new User(name,email,birth,password));
            Log.d(TAG,"UserCreate");
            nameEditText.getText().clear();
            emailEditText.getText().clear();
            birthEditText.getText().clear();
            passwordEditText.getText().clear();
            passwordConfirmEditText.getText().clear();
        }


    }


    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public void moveToMain(View view) {
        finish();
    }


}