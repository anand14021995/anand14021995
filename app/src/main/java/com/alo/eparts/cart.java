package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alo.eparts.recycler.notificationActivity;

public class cart extends AppCompatActivity {
    Button proceedpay;
    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    TextView savetoquote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        savetoquote = findViewById(R.id.savetoquote);
        savetoquote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cart.this, saveQuote.class);
                startActivity(intent);
            }
        });
        //pay
        proceedpay = findViewById(R.id.proceedpay);
        proceedpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cart.this, DeliveryActivity.class);
                startActivity(intent);
            }
        });
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cart.this, notificationActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cart.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });

//backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cart.this, navigationbar.class);
                startActivity(intent);
            }
        });

        //profileClicked
        LinearLayout profile = (LinearLayout) findViewById(R.id.profileclick);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cart.this, profileActivity.class);
                startActivity(intent);
            }
        });
    }
}