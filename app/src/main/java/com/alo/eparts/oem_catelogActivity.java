package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alo.eparts.catalog.RecyclerData;
import com.alo.eparts.catalog.RetrofitAPI;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class oem_catelogActivity extends AppCompatActivity {
    Button cartype;
    private RecyclerView courseRV;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_catelog2);
        cartype = (Button)findViewById(R.id.idTVCourseName);
        courseRV = findViewById(R.id.idRVCourse);
        recyclerDataArrayList = new ArrayList<>();
        getAllCourses();
        /*cartype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogActivity.this,oemFilterActivity.class);
                startActivity(intent);
            }
        });*/
    }

    private void getAllCourses() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonkeeper.com/b/")
                .addConverterFactory(GsonConverterFactory.create())
               .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<ArrayList<RecyclerData>> call = retrofitAPI.getAllCourses();
        call.enqueue(new Callback<ArrayList<RecyclerData>>() {

            public void onResponse(Call<ArrayList<RecyclerData>> call, Response<ArrayList<RecyclerData>> response) {
                // inside on response method we are checking
                // if the response is success or not.
                //Toast.makeText(oem_catelogActivity.this, "data---", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {

                    // on successful we are hiding our progressbar.
                    /*progressBar.setVisibility(View.GONE);*/

                    // below line is to add our data from api to our array list.
                    recyclerDataArrayList = response.body();
                    //Toast.makeText(oem_catelogActivity.this, "data1111---"+recyclerDataArrayList, Toast.LENGTH_SHORT).show();
                    // below line we are running a loop to add data to our adapter class.
                    for (int i = 0; i < recyclerDataArrayList.size(); i++) {
                        recyclerViewAdapter = new RecyclerViewAdapter(recyclerDataArrayList, oem_catelogActivity.this);

                        // below line is to set layout manager for our recycler view.
                        LinearLayoutManager manager = new LinearLayoutManager(oem_catelogActivity.this);

                        // setting layout manager for our recycler view.
                        courseRV.setLayoutManager(manager);

                        // below line is to set adapter to our recycler view.
                        courseRV.setAdapter(recyclerViewAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<RecyclerData>> call, Throwable t) {
                // in the method of on failure we are displaying a
                // toast message for fail to get data.
                Toast.makeText(oem_catelogActivity.this, "Fail to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }



}