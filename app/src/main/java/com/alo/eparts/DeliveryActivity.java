package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.alo.eparts.recycler.notificationActivity;
import com.kofigyan.stateprogressbar.StateProgressBar;

import java.util.Map;

public class DeliveryActivity extends AppCompatActivity {

    String[] descriptionData = {"Cart", "Location", "Invoice", "Payment"};
    Button button;
    LinearLayout review,delivery,payment;
    TextView changeTitle,setadd;
    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.progressbar);
        stateProgressBar.setStateDescriptionData(descriptionData);

        button = (Button) findViewById(R.id.button);
        review = findViewById(R.id.review);
        delivery = findViewById(R.id.delivery);
        changeTitle = findViewById(R.id.changeTitle);
        payment = findViewById(R.id.payment);
        setadd = findViewById(R.id.setadd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (stateProgressBar.getCurrentStateNumber()) {
                    case 1:

                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        break;
                    case 2:
                        review.setVisibility(View.VISIBLE);
                        changeTitle.setText("Review");
                        delivery.setVisibility(View.GONE);
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                        break;
                    case 3:
                        review.setVisibility(View.GONE);
                        changeTitle.setText("Payment");
                        button.setText("Continue and Pay");
                        delivery.setVisibility(View.GONE);
                        payment.setVisibility(View.VISIBLE);
                        setadd.setVisibility(View.GONE);
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
                        break;
                    case 4:
                        stateProgressBar.setAllStatesCompleted(true);
                        PopUpOrder PopUpOrder = new PopUpOrder();
                        PopUpOrder.showPopupWindow(view);
                        break;
                }
            }
        });

        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DeliveryActivity.this, notificationActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DeliveryActivity.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });

//backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DeliveryActivity.this, navigationbar.class);
                startActivity(intent);
            }
        });

        //profileClicked
        LinearLayout profile = (LinearLayout) findViewById(R.id.profileclick);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DeliveryActivity.this, profileActivity.class);
                startActivity(intent);
            }
        });

    }




}