package com.alo.eparts;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alo.eparts.recycler.notificationActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class navigationbar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    ViewPager mViewPager,mViewPagerOrder;

    // images array
    int[] images = {R.drawable.banner, R.drawable.banner, R.drawable.banner};
    int[] orders = {R.drawable.neworder, R.drawable.inprogressorder, R.drawable.completeorder};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;
    com.alo.eparts.order.ViewPagerAdapter mViewPagerAdapterorder;

    CardView oemcatelog;
    ImageView backIconImageView,propic;
    NavigationView navigationView;
    LinearLayout itemclick ,cart;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        mViewPagerOrder = (ViewPager)findViewById(R.id.viewPagerMainorder);
        navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);


        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(navigationbar.this, images);
        mViewPagerAdapterorder = new com.alo.eparts.order.ViewPagerAdapter(navigationbar.this, orders);
        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPagerOrder.setAdapter(mViewPagerAdapterorder);
        oemcatelog = (CardView) findViewById(R.id.oemcatelog);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        //OEM CATELOG CLICKED
        oemcatelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(navigationbar.this,OemCatelogActivity.class);
                startActivity(intent);
            }
        });
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(navigationbar.this, notificationActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(navigationbar.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(navigationbar.this, cart.class);
                startActivity(intent);
            }
        });

        //profileClicked
        LinearLayout profile = (LinearLayout) findViewById(R.id.profileclick);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(navigationbar.this, profileActivity.class);
                startActivity(intent);
            }
        });





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.id.nav_host_fragment);
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }



//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "Wow, SuccessFully Order", Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.managepayment){
            Intent intent = new Intent(this,ManagePayment.class);
            this.startActivity(intent);
        }else if(item.getItemId()==R.id.myorder){
            Intent intent = new Intent(this,myOrdersActivity.class);
            this.startActivity(intent);
        }
        else if(item.getItemId()==R.id.nmanageteam){
            Intent intent = new Intent(this,ManageTeam.class);
            this.startActivity(intent);
        }
        else if(item.getItemId()==R.id.notifications){
            Intent intent = new Intent(this,notificationActivity.class);
            this.startActivity(intent);
        }
        else if(item.getItemId()==R.id.subscriptions){
            Intent intent = new Intent(this,ManageSubscription.class);
            this.startActivity(intent);
        }else if(item.getItemId()==R.id.profile){
            Intent intent = new Intent(this,profileActivity.class);
            this.startActivity(intent);
        }else if(item.getItemId()==R.id.offers){
            Intent intent = new Intent(this,MakeOfferNew.class);
            this.startActivity(intent);
        }else if(item.getItemId()==R.id.quotes){
            Intent intent = new Intent(this,manageQuotes.class);
            this.startActivity(intent);
        }else if(item.getItemId()==R.id.partsrequest){
            Intent intent = new Intent(this,ManageUnavailability.class);
            this.startActivity(intent);
        }
        return false;
    }
}