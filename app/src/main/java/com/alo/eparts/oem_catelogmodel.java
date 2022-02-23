package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alo.eparts.catalog.BrandData;
import com.alo.eparts.catalog.RetrofitAPI;
import com.alo.eparts.recycler.notificationActivity;
import com.alo.eparts.ui.ModelData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class oem_catelogmodel extends AppCompatActivity {

    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    Button searchcar;
    private ArrayList<BrandData> BrandDataArrayList;
    private ArrayList<ModelData> ModelDataArratList;
    List<String> codes = new ArrayList<String>();
    List<String> codesid = new ArrayList<String>();
    List<String> model =new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_catelogmodel);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        searchcar = findViewById(R.id.searchcar);
        Bundle bundle = getIntent().getExtras();
        String brand = bundle.getString("brand");
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        AutoCompleteTextView modelautoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.modelautoCompleteTextView);
        Button brandclear = (Button)findViewById(R.id.brandclear);
        Button modelclear = (Button)findViewById(R.id.modelclear);
        brandclear.setText(brand);

        autoCompleteTextView.setText(brand);

        String model = bundle.getString("model");
        modelautoCompleteTextView.setText(model);
        modelclear.setText(model);
        getBrandData();
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogmodel.this, notificationActivity.class);
                startActivity(intent);
            }
        });

        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogmodel.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogmodel.this, navigationbar.class);
                startActivity(intent);
            }
        });

        /*Clear Button*/
        brandclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brandclear.setVisibility(View.GONE);
            }
        });

        modelclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelclear.setVisibility(View.GONE);
            }
        });

        /*Brand Clicked*/
        searchcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_catelogmodel.this, oemFilterActivity.class);
                startActivity(intent);
            }
        });


    }

    private void getBrandData() {
        Toast.makeText(this,"inisde",Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.7.10:3000/api/common_management/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<ArrayList<BrandData>> call = retrofitAPI.getAllBrand();
        call.enqueue(new Callback<ArrayList<BrandData>>() {

            public void onResponse(Call<ArrayList<BrandData>> call, Response<ArrayList<BrandData>> response) {

                //Toast.makeText(oem_catelogActivity.this, "data---", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {


                    BrandDataArrayList = response.body();
                    //Toast.makeText(manageQuoteEdit.this, "data1111---"+BrandDataArrayList.size(), Toast.LENGTH_SHORT).show();
                    // below line we are running a loop to add data to our adapter class.
                    for (int i = 0; i < BrandDataArrayList.size(); i++) {
                        codes.add(BrandDataArrayList.get(i).getCountry_name());
                        codesid.add(BrandDataArrayList.get(i).getId());
                    }
                    ArrayAdapter<String> adapterTime = new ArrayAdapter<>(oem_catelogmodel.this, R.layout.dropdownbrand_item, codes);
                    AutoCompleteTextView autocompleteTV=findViewById(R.id.autoCompleteTextView);
                    autocompleteTV.setAdapter(adapterTime);

                    autocompleteTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String item = BrandDataArrayList.get(position).getId();
                            getModelList(item);
                            Toast.makeText(oem_catelogmodel.this, "" + BrandDataArrayList.get(position).getId(), Toast.LENGTH_SHORT).show();
                        }

                    });

                }
            }

            @Override
            public void onFailure(Call<ArrayList<BrandData>> call, Throwable t) {

            }


        });
    }

    private String item;
    private void getModelList(String item) {
        this.item =item;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.7.10:3000/api/common_management/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<ArrayList<ModelData>> call = retrofitAPI.getAllModel(item);
        call.enqueue(new Callback<ArrayList<ModelData>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelData>> call, Response<ArrayList<ModelData>> response) {
                // Toast.makeText(manageQuoteEdit.this, "data---", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    ModelDataArratList = response.body();
                    for (int i = 0; i < ModelDataArratList.size(); i++) {
                        model.add(ModelDataArratList.get(i).getState_name());
                    }
                    ArrayAdapter<String> adapterTime = new ArrayAdapter<>(oem_catelogmodel.this, R.layout.dropdownmodel_item, model);
                    AutoCompleteTextView autocompleteTVmodel=findViewById(R.id.modelautoCompleteTextView);
                    autocompleteTVmodel.setAdapter(adapterTime);
                    // Toast.makeText(manageQuoteEdit.this, "data---", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ArrayList<ModelData>> call, Throwable t) {

            }
        });
    }
}