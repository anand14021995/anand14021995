package com.alo.eparts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alo.eparts.recycler.notificationActivity;
import com.google.android.material.tabs.TabLayout;

public class MakeOffer extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Button vieworder;
    ImageView backIconImageView,propic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_offer);
        propic = findViewById(R.id.propic);
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MakeOffer.this, notificationActivity.class);
                startActivity(intent);
            }
        });
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Requested"));
        vieworder = findViewById(R.id.vieworder);
        tabLayout.addTab(tabLayout.newTab().setText("Approved"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyAdapterOffer adapter = new MyAdapterOffer(this,getSupportFragmentManager(),
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

    }

    private class MyAdapterOffer extends FragmentPagerAdapter {
        Context context;
        int totalTabs;


        public MyAdapterOffer(Context c, FragmentManager fm, int totalTabs) {
            super(fm);
            context = c;
            this.totalTabs = totalTabs;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    RequestOffer RequestFragment = new RequestOffer();
                    return RequestFragment;
                case 1:
                    ApprovedOffer approvedFragment = new ApprovedOffer();
                    return approvedFragment;

                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }
}