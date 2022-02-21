package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alo.eparts.recycler.notificationActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class oemcatelogfilteropen extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    TextView modify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oemcatelogfilteropen);
        Bundle bundle = getIntent().getExtras();
        String Vin = bundle.getString("searchVin");
        EditText searchvin = findViewById(R.id.searchvin);
        TextView modify = (TextView)findViewById(R.id.modify);
        LinearLayout carimage = (LinearLayout)findViewById(R.id.carimage);
        LinearLayout branddetail = (LinearLayout)findViewById(R.id.branddetail);
        LinearLayout oemtitle = (LinearLayout)findViewById(R.id.oemtitle);
        searchvin.setText(Vin);
        if(Vin == "")
        {

        }else
        {
            Toast.makeText(this,"dataaa=="+Vin,Toast.LENGTH_SHORT).show();
            modify.setVisibility(View.GONE);
            carimage.setVisibility(View.GONE);
            branddetail.setVisibility(View.GONE);
            oemtitle.setVisibility(View.GONE);

        }
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
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
                return false;
            }
        });


        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemcatelogfilteropen.this,oem_activityfilterall.class);
                startActivity(intent);
            }
        });

        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemcatelogfilteropen.this, notificationActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemcatelogfilteropen.this, navigationbar.class);
                startActivity(intent);
            }
        });

        //MyorderClicked

        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oemcatelogfilteropen.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });

    }
}