package com.example.lab5whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    Button waButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waButton = (Button) findViewById(R.id.button);
    }

    public void waNumber(View view) {
        PackageManager packageManager = getPackageManager();
        Intent i= new Intent (Intent.ACTION_VIEW);
        String message = "Type your custom message here";
        String phone= "+601123650109";
        try {
                String url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + URLEncoder.encode(message, "UTF-8");
        i.setPackage("com.whatsapp");
        i.setData(Uri.parse(url));
    if (i.resolveActivity(packageManager) != null) {
        startActivity (i);
    } } catch (Exception e) {
        e.printStackTrace();
    }}
}