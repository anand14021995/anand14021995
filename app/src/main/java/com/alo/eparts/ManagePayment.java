package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alo.eparts.recycler.notificationActivity;
import com.google.android.material.tabs.TabLayout;

public class ManagePayment extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Button vieworder;
    ImageView backIconImageView,propic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_payment);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Wallet"));
        vieworder = findViewById(R.id.vieworder);
        tabLayout.addTab(tabLayout.newTab().setText("Transaction History"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyAdapterPayment adapter = new MyAdapterPayment(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        propic = findViewById(R.id.propic);
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManagePayment.this, notificationActivity.class);
                startActivity(intent);
            }
        });
    }
}