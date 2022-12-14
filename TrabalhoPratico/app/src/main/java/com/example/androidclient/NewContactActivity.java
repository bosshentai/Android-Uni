package com.example.androidclient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.androidclient.utils.IClientConnection;

import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewContactActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText phoneNumberEditText;
    private EditText emailEditText;
    private EditText birthDayEditText;
    private String selectedSex;

    private int contactPosition;
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


        switch (view.getId()) {
            case R.id.selectedMasc:
                if (checked) {
//                    toastDisplay("Masculino");
                    selectedSex = "MASC";
                }
                break;
            case R.id.selectedFemin:
                if (checked) {
                    selectedSex = "FEMIN";

                }
                break;
            case R.id.selectedOther:
                if (checked) {
                    selectedSex = "OTHER";
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void registerContactHandler(View view) {
        // Text
        fullNameEditText.setText(R.string.example_full_name);
        emailEditText.setText(R.string.example_email);
        phoneNumberEditText.setText(R.string.example_number);
        birthDayEditText.setText(R.string.example_birth);
        selectedSex = "MASC";


        String fullName = fullNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneNumberEditText.getText().toString();
        String birth = birthDayEditText.getText().toString();
        String sex = selectedSex;


        Boolean isFullNameEmpty = fullName.isEmpty();
        Boolean isEmailEmpty = email.isEmpty();
        Boolean isEmailValid = isEmailValid(email);
        Boolean isPhoneEmpty = phone.isEmpty();
        Boolean isBirthEmpty = birth.isEmpty();
        Boolean isSexEmpty = sex.isEmpty();
        Boolean isFormOK = !isFullNameEmpty && !isBirthEmpty && isEmailValid && !isSexEmpty && !isPhoneEmpty;


        if (isFullNameEmpty) {
            toastDisplay("Nome Completo Vazio");
            return;
        }


        if (isPhoneEmpty) {
            toastDisplay("Numero de Telephone Vazio");
            return;
        }

        if (isEmailEmpty) {
            toastDisplay("Email Vazio");
            return;
        }


        if (!isEmailValid) {
            toastDisplay("Email Invalido");
            return;
        }

        if (isBirthEmpty) {
            toastDisplay("Niver Vazio");
            return;
        }

        if (isSexEmpty) {
            toastDisplay("Nao escolheu o sexo");
            return;
        }


        if (isFormOK) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:5020/")
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            IClientConnection contactService = retrofit.create(IClientConnection.class);
            Contact newContact = new Contact(fullName, phone, email, birth, sex);
            Call<ResponseBody> call = contactService.createContact(newContact);

            call.enqueue(new Callback<ResponseBody>() {

                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (!response.isSuccessful()) {
                        Log.e("RESPONSE", "OnResponse: " + response.code());
                        Log.e("RESPONSE","OnMessage:  " + response.message());
                    } else {
                        Log.d("response", "OnResponse: " + response.body());
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e("Error", "OnFailure" + t.getMessage());
                }
            });
//            Db.contactList.add(new Contact(fullName, phone, email, birth, sex));
//            finish();
        }

//        toastDisplay(selectedSex);
    }

//
//    private int selectedContact (String id ) {
////        int position = 0;
//        for(int i = 0 ; i < Db.contactList.size(); i++){
//            if(Db.contactList.get(i).getId() = )
//        }
//
////        return position;
//    }

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}