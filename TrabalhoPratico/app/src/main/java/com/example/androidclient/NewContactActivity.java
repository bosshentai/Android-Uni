package com.example.androidclient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class NewContactActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText phoneNumberEditText;
    private EditText emailEditText;
    private EditText birthDayEditText;
    private String selectedSex;
//    private RadioGroup radioGroup;
//    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        fullNameEditText = findViewById(R.id.fullNameInput);
        phoneNumberEditText = findViewById(R.id.phoneNumberInput);
        emailEditText = findViewById(R.id.emailInput);
        birthDayEditText = findViewById(R.id.birthInput);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        birthDayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(NewContactActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;

                        String date = day + "/" + month + "/" + year;
                        birthDayEditText.setText(date);
                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });
    }

    public void sexHandle(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()){
            case R.id.selectedMasc:
                if(checked){
//                    toastDisplay("Masculino");
                    selectedSex = "Masculino";
                }
                break;
            case R.id.selectedFemin:
                if(checked){
                    selectedSex = "Feminino";

                }
                break;
            case R.id.selectedOther:
                if (checked){
                    selectedSex = "Outros";
                }
                break;
            default:
                selectedSex = "";
                break;

        }
    }

    public void cancelHandler(View view) {
        AlertDialog.Builder cancelAlertBuilder = new AlertDialog.Builder(NewContactActivity.this);

        // title
        cancelAlertBuilder.setTitle(R.string.alert_dialog_title);
        cancelAlertBuilder.setMessage(R.string.alert_dialog_message);


        cancelAlertBuilder.setPositiveButton(R.string.confirm_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        cancelAlertBuilder.setNegativeButton(R.string.cancel_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        cancelAlertBuilder.show();
    }

    private void toastDisplay(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void registerContactHandler(View view) {
        String fullName = fullNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String birth = birthDayEditText.getText().toString();
        String sex = selectedSex;

        Boolean isFullNameEmpty = fullName.isEmpty();
        Boolean isEmailEmpty = email.isEmpty();
        Boolean isEmailValid = isEmailValid(email);
        Boolean isBirthEmpty = birth.isEmpty();
        Boolean isSexEmpty = sex.isEmpty();
        Boolean isFormOK = !isFullNameEmpty && !isBirthEmpty && !isEmailValid && !isBirthEmpty && !isSexEmpty;


        if(isFullNameEmpty){
            toastDisplay("Nome Completo Vazio");
            return;
        }

        if(isEmailEmpty){
            toastDisplay("Email Vazio");
            return;
        }


        if(isEmailValid){
            toastDisplay("Email Invalido");
            return;
        }

        if(isBirthEmpty){
            toastDisplay("Niver Vazio");
            return;
        }

        if(isSexEmpty){
            toastDisplay("Nao escolheu o sexo");
            return;
        }


        if(isFormOK){
            Db.contactList.add(new Contact(fullName,email,birth,sex));
            finish();
        }

//        toastDisplay(selectedSex);
    }


    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}