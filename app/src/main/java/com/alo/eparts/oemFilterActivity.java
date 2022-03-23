package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alo.eparts.recycler.notificationActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class oemFilterActivity extends AppCompatActivity {
Button openfilter;
    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_filter);
        openfilter = (Button)findViewById(R.id.openfilter);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        Bundle bundle = getIntent().getExtras();
        String brand = bundle.getString("brand");
        Toast.makeText(oemFilterActivity.this,brand,Toast.LENGTH_SHORT).show();
        String model = bundle.getString("model");
        TextView brandtext = (TextView)findViewById(R.id.brandtext);
        brandtext.setText(": "+brand);
        TextView modeltext = (TextView)findViewById(R.id.modeltext);
        modeltext.setText(": "+model);
        TextView modify = (TextView)findViewById(R.id.modify);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
                if(groupPosition==0)
                {

                }
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();

                if(groupPosition==0)
                {
                    if (childPosition == 0)
                    {
                        Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
                        Intent c = new Intent(getApplicationContext(),oem_activityfilterall.class);
                        startActivity(c);
                    }

                }if (groupPosition == 1) {

                    if (childPosition == 0)
                    {
                        Intent c = new Intent(getApplicationContext(),oem_activityfilterall.class);
                        startActivity(c);
                    }


                }
                return false;
            }
        });
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(oemFilterActivity.this,oem_catelogmodel.class);
                intent.putExtra("brand",brand);
                intent.putExtra("model",model);
                startActivity(intent);
            }
        });
        /*Open Button Clicked*/
        openfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout cardetails = (RelativeLayout)findViewById(R.id.cardetails);
                cardetails.setVisibility(View.VISIBLE);openfilter.setVisibility(View.GONE);
//                Intent intent=new Intent(oemFilterActivity.this,oemcatelogfilteropen.class);
//                startActivity(intent);
            }
        });
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemFilterActivity.this, notificationActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemFilterActivity.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemFilterActivity.this, navigationbar.class);
                startActivity(intent);
            }
        });
    }
}