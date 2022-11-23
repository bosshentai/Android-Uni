package com.example.p23;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareEditText = findViewById(R.id.share_edittext);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if(uri != null){
//            String uri_string = "URI: " + uri.toString();
            String uri_string = getString(R.string.uri_label)
                    + uri.toString();

            TextView textView = findViewById(R.id.text_uri_message);
            textView.setText(uri_string);
        }
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.d("ImplicitIntents","Can't handle this!");
        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Log.d("ImplicitIntents",loc);
        Uri addresUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addresUri);
        Log.d("ImplicitIntents",addresUri.toString());
//        intent.setPackage("com.google.adroid.apps.maps");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.d("ImplicitIntents","openLocation: can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String text = mShareEditText.getText().toString();
        String mimetype = "text/plain";

        ShareCompat.IntentBuilder.from(this).setType(mimetype).setChooserTitle("Share this text with:").setText(text).startChooser();

    }
}