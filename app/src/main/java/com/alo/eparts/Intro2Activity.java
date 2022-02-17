package com.alo.eparts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class Intro2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
        LinearLayout app_layer = (LinearLayout) findViewById (R.id.Linearlayoutnext);
        TextView textViewOrderStatus = (TextView) findViewById(R.id.textViewOrderStatus);
        app_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro2Activity.this,Intro3Activity.class);
                startActivity(intent);
            }
        });

        //skip button
        textViewOrderStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro2Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}