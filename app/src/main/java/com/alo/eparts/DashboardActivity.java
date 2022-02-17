package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.banner, R.drawable.banner, R.drawable.banner};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;

    CardView oemcatelog;
    ImageView backIconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(DashboardActivity.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
        oemcatelog = (CardView) findViewById(R.id.oemcatelog);
        backIconImageView = findViewById(R.id.backIconImageView);
        //OEM CATELOG CLICKED
        oemcatelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,OemCatelogActivity.class);
                startActivity(intent);
            }
        });

        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,navigationbar.class);
                startActivity(intent);
            }
        });


    }
}