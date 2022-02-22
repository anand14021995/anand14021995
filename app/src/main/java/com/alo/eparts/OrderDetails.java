package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alo.eparts.recycler.notificationActivity;

public class OrderDetails extends AppCompatActivity {

    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        itemclick = findViewById(R.id.itemclick);
        TextView moredetails = (TextView)findViewById(R.id.moredetails);
        moredetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String more =moredetails.getText().toString();
                if(more=="More Details")
                {
                    LinearLayout moredetailsview = (LinearLayout)findViewById(R.id.moredetailsview);
                    moredetailsview.setVisibility(View.VISIBLE);
                    moredetails.setText("Less Details");
                }else
                {
                    LinearLayout moredetailsview = (LinearLayout)findViewById(R.id.moredetailsview);
                    moredetailsview.setVisibility(View.GONE);
                    moredetails.setText("More Details");
                }

            }
        });
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderDetails.this, notificationActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderDetails.this, navigationbar.class);
                startActivity(intent);
            }
        });
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderDetails.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });
    }
}