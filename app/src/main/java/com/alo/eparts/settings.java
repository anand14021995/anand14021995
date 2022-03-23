package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class settings extends AppCompatActivity {



    TextView countrylanguage,subscriptiondetails,aboutus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        countrylanguage = findViewById(R.id.countrylanguage);
        subscriptiondetails = findViewById(R.id.subscriptiondetails);
        aboutus = findViewById(R.id.aboutus);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this,aboutus.class);
                startActivity(intent);
            }
        });

        subscriptiondetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this,ManageSubscription.class);
                startActivity(intent);
            }
        });
        countrylanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this,countrylanguage.class);
                startActivity(intent);
            }
        });
    }
}