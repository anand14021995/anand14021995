package com.alo.eparts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.alo.eparts.HelperClasses.adapterphone;
import com.alo.eparts.HelperClasses.phonehelper;

import java.util.ArrayList;

public class dashboardseller extends AppCompatActivity implements adapterphone.ListItemClickListener{

    int[] images = {R.drawable.banner, R.drawable.banner, R.drawable.banner};
    ViewPager mViewPager,mViewPagerOrder;
    ProgressBar progressBar1,progressBar2,progressBar3;
    RecyclerView phoneRecycler;
    RecyclerView.Adapter adapter;
    int url=R.drawable.productcount;
    int url1= R.drawable.inprogressorder;
    int url2=R.drawable.completeorder;
    ViewPagerAdapter mViewPagerAdapter;
    private ProgressBar pgsBar;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardseller);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar1.getProgressDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        progressBar1.setScaleY(2f);
        progressBar2.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
        progressBar2.setScaleY(2f);
        progressBar3.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        progressBar3.setScaleY(2f);
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        mViewPagerAdapter = new ViewPagerAdapter(dashboardseller.this, images);
        mViewPager.setAdapter(mViewPagerAdapter);
        phoneRecycler = findViewById(R.id.my_recycler);
        phoneRecycler();
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        //setSupportActionBar (toolbar);
        //this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void phoneRecycler() {

        //All Gradients
        GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        GradientDrawable gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        phoneRecycler.setHasFixedSize(true);
        phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<phonehelper> phonelocations = new ArrayList<>();
        phonelocations.add(new phonehelper(gradient1, R.drawable.productcount, "Samsung"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.inprogressorder, "Vivo"));
        phonelocations.add(new phonehelper(gradient2, R.drawable.completeorder, "Apple"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.inprogressorder, "Realme"));




        adapter = new adapterphone(phonelocations, (adapterphone.ListItemClickListener) this);
        phoneRecycler.setAdapter(adapter);

    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }
}