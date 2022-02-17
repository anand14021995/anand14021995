package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Intro1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);
        LinearLayout app_layer = (LinearLayout) findViewById (R.id.Linearlayoutnext);
        TextView textViewOrderStatus = (TextView) findViewById(R.id.textViewOrderStatus);
        app_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro1Activity.this,Intro2Activity.class);
                startActivity(intent);
            }
        });

        //skip button
        textViewOrderStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro1Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}