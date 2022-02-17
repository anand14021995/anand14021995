package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.alo.eparts.catalog.BrandData;
import com.alo.eparts.catalog.RecyclerData;
import com.alo.eparts.catalog.RetrofitAPI;
import com.alo.eparts.recycler.notificationActivity;
import com.alo.eparts.ui.ModelData;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class manageQuoteEdit extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    AutoCompleteTextView autocompleteTV;

    private ArrayList<BrandData> BrandDataArrayList;
    private ArrayList<ModelData> ModelDataArratList;
    List<String> codes = new ArrayList<String>();
    List<String> codesid = new ArrayList<String>();
    List<String> model =new ArrayList<String>();
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_quote_edit);
        /*Brand Dropdown Start*/
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(manageQuoteEdit.this, proceedSavetoQuote.class);
                startActivity(intent);
            }
        });

        getBrandData();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewproduct);
        expandableListDetail = ExpandableListDataPumpProduct.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapterProduct(this, expandableListTitle, expandableListDetail);
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
    }

    private void getBrandData() {
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
                    ArrayAdapter<String> adapterTime = new ArrayAdapter<>(manageQuoteEdit.this, R.layout.dropdownbrand_item, codes);
                    AutoCompleteTextView autocompleteTV=findViewById(R.id.autoCompleteTextView);
                    autocompleteTV.setAdapter(adapterTime);

                    autocompleteTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String item = BrandDataArrayList.get(position).getId();
                            getModelList(item);
                            //Toast.makeText(manageQuoteEdit.this, "Selected Item is: \t" + item, Toast.LENGTH_LONG).show();
                           Toast.makeText(manageQuoteEdit.this, "" + BrandDataArrayList.get(position).getId(), Toast.LENGTH_SHORT).show();
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
       // Toast.makeText(manageQuoteEdit.this, "Selected Item is11: \t" + item, Toast.LENGTH_LONG).show();
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
                    ArrayAdapter<String> adapterTime = new ArrayAdapter<>(manageQuoteEdit.this, R.layout.dropdownmodel_item, model);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
