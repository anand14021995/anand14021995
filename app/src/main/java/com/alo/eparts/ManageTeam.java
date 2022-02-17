package com.alo.eparts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alo.eparts.recycler.notificationActivity;
import com.google.android.material.snackbar.Snackbar;

public class ManageTeam extends AppCompatActivity {

    LinearLayout cardswipee;
    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_team);
        cardswipee = findViewById(R.id.cardswipee);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        cardswipee.setOnTouchListener(new OnSwipeTouchListener(ManageTeam.this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                Toast.makeText(ManageTeam.this, "Swipe Left gesture detected", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Toast.makeText(ManageTeam.this, "Swipe Right gesture detected", Toast.LENGTH_SHORT).show();
            }
        });

        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManageTeam.this, notificationActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManageTeam.this, navigationbar.class);
                startActivity(intent);
            }
        });

        //MyorderClicked

        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManageTeam.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });
    }


}