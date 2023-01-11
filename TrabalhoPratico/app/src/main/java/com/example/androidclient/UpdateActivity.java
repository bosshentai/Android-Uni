package com.example.androidclient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Retrofit;

public class UpdateActivity extends AppCompatActivity {


    private EditText fullNameEditText;
    private EditText phoneNumberEditText;
    private EditText emailEditText;
    private EditText birthDayEditText;
    private String selectedSex;
   

    private RadioButton mascButton;
    private RadioButton femButton;
    private RadioButton otherButton;
    private static final String LOG_TAG = UpdateActivity.class.getSimpleName();
    private int contactSelectedPosition;
    private String contactId;
//    private ArrayList<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent getPositionView = getIntent();
        contactId = getPositionView.getStringExtra("userData");


//        Log.d(LOG_TAG,positionView);
//
//
//                for(int i = 0; i < Db.contactList.size(); i++){
//            if(Db.contactList.get(i).getId().equals(positionView)){
//                Log.d(LOG_TAG,Db.contactList.get(i).getId());
//                contactSelectedPosition = i;
//            }
//
//        }

//        position = selectContact(positionView);


        fullNameEditText = findViewById(R.id.fullNameInput);
        phoneNumberEditText = findViewById(R.id.phoneNumberInput);
        emailEditText = findViewById(R.id.emailInput);
        birthDayEditText = findViewById(R.id.birthInput);
        mascButton = findViewById(R.id.selectedMasc);
        femButton = findViewById(R.id.selectedFemin);
        otherButton = findViewById(R.id.selectedOther);






        fullNameEditText.setText(Db.contactList.get(contactSelectedPosition).getFullName());
//        fullNameEditText.setText(Db.contactList.get(Integer.parseInt(position)).getFullName());
//        phoneNumberEditText.setText(Db.contactList.get(Integer.parseInt(position)).getPhoneNumber());
        phoneNumberEditText.setText(Db.contactList.get(contactSelectedPosition).getPhoneNumber());
//        emailEditText.setText(Db.contactList.get(Integer.parseInt(position)).getEmail());
        emailEditText.setText(Db.contactList.get(contactSelectedPosition).getEmail());
//        birthDayEditText.setText(Db.contactList.get(Integer.parseInt(position)).getBirth());
        birthDayEditText.setText(Db.contactList.get(contactSelectedPosition).getBirth());


//        if (Db.contactList.get(Integer.parseInt(position)).getSex() == "Masculino") {
//            selectedSex = "Masculino";
//            mascButton.setChecked(true);
//
//        }
        if (Db.contactList.get(contactSelectedPosition).getSex() == "Masculino") {
            selectedSex = "Masculino";
            mascButton.setChecked(true);

        }
//
//        if (Db.contactList.get(Integer.parseInt(position)).getSex() == "Feminino") {
//            selectedSex = "Feminino";
//            femButton.setChecked(true);
//        }
        if (Db.contactList.get(contactSelectedPosition).getSex() == "Feminino") {
            selectedSex = "Feminino";
            femButton.setChecked(true);
        }
//        if (Db.contactList.get(Integer.parseInt(position)).getSex() == "Outros") {
//            selectedSex = "Outros";
//            otherButton.setChecked(true);
//        }
        if (Db.contactList.get(contactSelectedPosition).getSex() == "Outros") {
            selectedSex = "Outros";
            otherButton.setChecked(true);
        }


//        Log.d(LOG_TAG,position);
//        Log.d(LOG_TAG,Db.contactList);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        birthDayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        switch (view.getId()) {
            case R.id.selectedMasc:
                if (checked) {
//                    toastDisplay("Masculino");
                    selectedSex = "Masculino";
                }
                break;
            case R.id.selectedFemin:
                if (checked) {
                    selectedSex = "Feminino";

                }
                break;
            case R.id.selectedOther:
                if (checked) {
                    selectedSex = "Outros";
                }
                break;
            default:
                selectedSex = "";
                break;

        }
    }

    public void cancelHandler(View view) {
        AlertDialog.Builder cancelAlertBuilder = new AlertDialog.Builder(UpdateActivity.this);

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

    public void updateContactHandler(View view) {
        String fullName = fullNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneNumberEditText.getText().toString();
        String birth = birthDayEditText.getText().toString();
        String sex = selectedSex;
//
        Boolean isFullNameEmpty = fullName.isEmpty();
        Boolean isEmailEmpty = email.isEmpty();
        Boolean isEmailValid = isEmailValid(email);
        Boolean isPhoneEmpty = phone.isEmpty();
        Boolean isBirthEmpty = birth.isEmpty();
        Boolean isSexEmpty = sex.isEmpty();
        Boolean isFormOK = !isFullNameEmpty && !isBirthEmpty && isEmailValid  && !isSexEmpty && !isPhoneEmpty;

//        Log.d(LOG_TAG,sex);

        if (isFullNameEmpty) {
            toastDisplay("Nome Completo Vazio");
            return;
        }
//
//
        if (isPhoneEmpty){
            toastDisplay("Numero de Telephone Vazio");
            return;
        }
//
        if (isEmailEmpty) {
            toastDisplay("Email Vazio");
            return;
        }
//
//
        if (!isEmailValid) {
            toastDisplay("Email Invalido");
            return;
        }
//
        if (isBirthEmpty) {
            toastDisplay("Niver Vazio");
            return;
        }
//
        if (isSexEmpty) {
            toastDisplay("Nao escolheu o sexo");
            return;
        }
//
//
        if (isFormOK) {
//
//            Log.d(LOG_TAG,contactSelectedPosition);
//            Db.contactList.add(new Contact(fullName, phone, email, birth, sex));
            Db.contactList.get(contactSelectedPosition).updateContact(fullName,phone,email,birth,sex);
            finish();
        }else {
            Log.d(LOG_TAG,"Cant handle it");
        }
    }

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }



//    private  String selectContact  (String id){
//        for(int i = 0; i < Db.contactList.size(); i++){
//            if(Db.contactList.get(i).getId() == id){
//                contactSelectedPosition = id;
//            }
//        }
//
//        return  contactSelectedPosition;
//    }


    private Contact getSelect (String id){
        Retrofit.Builder builder = new

    }


    private void toastDisplay(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}