package com.alo.eparts;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alo.eparts.HelperClasses.adapterphone;
import com.alo.eparts.HelperClasses.phonehelper;
import com.alo.eparts.catalog.RetrofitAPI;
import com.alo.eparts.catalog.VinData;
import com.alo.eparts.recycler.notificationActivity;
import com.alo.eparts.ui.ModelData;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class navigationbar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, adapterphone.ListItemClickListener {


    private AppBarConfiguration mAppBarConfiguration;
    ViewPager mViewPager,mViewPagerOrder;
    private ArrayList<VinData> VinDataArratList;
    List<String> model =new ArrayList<String>();
    // images array
    int[] images = {R.drawable.banner, R.drawable.banner, R.drawable.banner};

    int url=R.drawable.neworder;
    int url1= R.drawable.inprogressorder;
    int url2=R.drawable.completeorder;
    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;
    RecyclerView phoneRecycler;
    RecyclerView.Adapter adapter;

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
        phoneRecycler = findViewById(R.id.my_recycler);
        phoneRecycler();
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        //mViewPagerOrder = (ViewPager)findViewById(R.id.viewPagerMainorder);
        navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);


        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(navigationbar.this, images);
        //mViewPagerAdapterorder = new com.alo.eparts.order.ViewPagerAdapter(navigationbar.this, orders);
        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
        //mViewPagerOrder.setAdapter(mViewPagerAdapterorder);
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

        //SearchVin Clicked
        LinearLayout search = (LinearLayout) findViewById(R.id.search);
        EditText edit = (EditText)findViewById(R.id.searchvin);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Vin = edit.getText().toString();
                if (TextUtils.isEmpty(Vin))
                {
                    Toast.makeText(navigationbar.this,
                            "Empty field not allowed!",
                            Toast.LENGTH_SHORT).show();
                }else
                {
                    getSearchVin(Vin);

                    Intent intent = new Intent(navigationbar.this,SearchVin.class);
                    intent.putExtra("searchVin",Vin);
                    startActivity(intent);
                }

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


        //Subscription Clicked
        LinearLayout activepackage = (LinearLayout) findViewById(R.id.activepackage);
        activepackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(navigationbar.this,ManageSubscription.class);
                startActivity(intent);
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);

    }
    private String Vin;
    private void getSearchVin(String Vin) {
        this.Vin = Vin;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.7.10:3000/api/buyer_management/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<List<VinData>> call = retrofitAPI.getAllVin(Vin);
        call.enqueue(new Callback<List<VinData>>() {
            @Override
            public void onResponse(Call<List<VinData>> call, Response<List<VinData>> response) {
                if (response.isSuccessful()) {

                    List<VinData> adslist = response.body();

                    //Toast.makeText(navigationbar.this, "data1111---"+adslist.get(0).getBusiness_name(), Toast.LENGTH_SHORT).show();

//

                }
            }

            @Override
            public void onFailure(Call<List<VinData>> call, Throwable t) {

            }






        });
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
        phonelocations.add(new phonehelper(gradient1, R.drawable.neworder, "Samsung"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.inprogressorder, "Vivo"));
        phonelocations.add(new phonehelper(gradient2, R.drawable.completeorder, "Apple"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.inprogressorder, "Realme"));




        adapter = new adapterphone(phonelocations, this);
        phoneRecycler.setAdapter(adapter);

    }

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
        }else if(item.getItemId()==R.id.logout){
            logout();
            return true;
        }
        return false;
    }

    private void logout() {
        new AlertDialog.Builder(this)
                .setTitle("Really Logout?")
                .setMessage("Are you sure you want to logout?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Intent i=new Intent();
                        i.putExtra("Exit", true);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                        //startActivity(i);
                        finish();

                    }

                }).create().show();
    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Intent i=new Intent();
                        i.putExtra("Exit", true);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                        //startActivity(i);
                        finish();

                    }

                }).create().show();

    }
}