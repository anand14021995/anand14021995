package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alo.eparts.recycler.notificationActivity;

public class oem_activityfilterall extends AppCompatActivity {

    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    Button viewproducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_activityfilterall);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_activityfilterall.this, notificationActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_activityfilterall.this, navigationbar.class);
                startActivity(intent);
            }
        });

        //MyorderClicked

        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_activityfilterall.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });

        viewproducts = findViewById(R.id.viewproducts);
        viewproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_activityfilterall.this, BuypartsOrder.class);
                startActivity(intent);
            }
        });
    }
}