package com.example.p41;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


//    private String orderMessage;
//    private TextView orderView;
//    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
//        String message = "Order: " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String orderMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        TextView orderView = findViewById(R.id.order_textView);
        orderView.setText(orderMessage);
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
//        TextView textView = findViewById(R.id.order_textView);
//        textView.setText(message);

        EditText editText = findViewById(R.id.phone_text);

        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        dialNumber();
                        handled = true;
                    }
                    return handled;
                }
            });
        }


    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean cheched = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.sameday:
                if (cheched)
                    displayToast(getString(R.string.sameday_text));
                break;
            case R.id.nextday:
                if (cheched)
                    displayToast(getString(R.string.nextday_text));
                break;
            case R.id.pickup:
                if (cheched)
                    displayToast(getString(R.string.pickup_text));
                break;
            default:
                break;
        }

    }


    private void dialNumber() {
        EditText editText = findViewById(R.id.phone_text);
        String phoneNum = null;

        if (editText != null) {
            phoneNum = "tel:" + editText.getText().toString();
        }
        Log.d(TAG, "dialNumber: " + phoneNum);

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phoneNum));
        if (intent.resolveActivity(getPackageManager())!= null){
//        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitiIntents", "Can't handle this!");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}