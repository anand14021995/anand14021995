package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alo.eparts.recycler.notificationActivity;

public class oem_catelogmodel extends AppCompatActivity {

    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    Button cartype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_catelogmodel);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        cartype = findViewById(R.id.cartype);
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogmodel.this, notificationActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogmodel.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogmodel.this, navigationbar.class);
                startActivity(intent);
            }
        });

        /*Brand Clicked*/
        cartype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogmodel.this, oemFilterActivity.class);
                startActivity(intent);
            }
        });


    }
}