package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alo.eparts.recycler.notificationActivity;

public class oemFilterActivity extends AppCompatActivity {
Button openfilter;
    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_filter);
        openfilter = (Button)findViewById(R.id.openfilter);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        /*Open Button Clicked*/
        openfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemFilterActivity.this,oemcatelogfilteropen.class);
                startActivity(intent);
            }
        });
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemFilterActivity.this, notificationActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemFilterActivity.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemFilterActivity.this, navigationbar.class);
                startActivity(intent);
            }
        });
    }
}