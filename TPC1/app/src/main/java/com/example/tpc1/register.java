package com.example.tpc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class register extends AppCompatActivity {

    private static final String TAG = register.class.getName();

    public ArrayList<User> mUsers;

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordConfirmEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameEditText = (EditText) findViewById(R.id.name_input);
        emailEditText = (EditText) findViewById(R.id.email_input);
        passwordEditText = (EditText) findViewById(R.id.password_input);
        passwordConfirmEditText = (EditText) findViewById(R.id.password_confirm_input);

        mUsers = new ArrayList<>();
     }

    public void moveToMain(View view) {
        Intent moveToMainIntent = new Intent(register.this,MainActivity.class);
        startActivity(moveToMainIntent);
    }

    public void RegisterPerson(View view) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String passwordConfirme = passwordConfirmEditText.getText().toString();


        if(name.isEmpty()){
            ToastDisplay("Empty name");
            return;
        }

        if(email.isEmpty()){
            ToastDisplay("Empty email");
            return;
        }

        if(isEmailValid(email) == false){
            ToastDisplay("Invalid Email");
            return;
        }


        if(password.isEmpty()){
            ToastDisplay("Empty password");
            return;
        }

        if(passwordConfirme.isEmpty()){
            ToastDisplay("Empty Confirm password");
            return;
        }

        if(password.equals(passwordConfirme) == false){
            ToastDisplay("Not match passwords");
            return;
        }


        if(!name.isEmpty() && !password.isEmpty() && !email.isEmpty()){
            mUsers.add(new User(name,email,password));

            Log.d(TAG,"UserCreate");
            return;
        }
//        Log.d("User",name);
//        Log.d("User",email);
//        Log.d("User",password);

    }



    private void ToastDisplay(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    private boolean isEmailValid(String email){
//        String regex = "^[\w-_\.+]*[\w-_\.]\@([\w]+\.)+[\w]+[\w]$";
//        return email.matches(regex);
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}