package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alo.eparts.recycler.notificationActivity;

import java.util.ArrayList;

public class OemCatelogActivity extends AppCompatActivity {
    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_catelog);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        //final ListView list = findViewById(R.id.list);
        ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
        arrayList.add(new SubjectData("Brand", "https://www.tutorialspoint.com/java/",   "https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
        arrayList.add(new SubjectData("Model", "https://www.tutorialspoint.com/python/", "https://www.tutorialspoint.com/python/images/python-mini.jpg"));
        arrayList.add(new SubjectData("Model", "https://www.tutorialspoint.com/javascript/", "https://www.tutorialspoint.com/javascript/images/javascript-mini-logo.jpg"));

        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
       // list.setAdapter(customAdapter);

        Button brand;
        brand = (Button)findViewById(R.id.brand);
        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent=new Intent(OemCatelogActivity.this,oem_catelogActivity.class);
//                startActivity(intent);
                Intent intent=new Intent(OemCatelogActivity.this,oem_catelogmodel.class);
                startActivity(intent);

            }
        });
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OemCatelogActivity.this, notificationActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OemCatelogActivity.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });

        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OemCatelogActivity.this, navigationbar.class);
                startActivity(intent);
            }
        });

    }
}