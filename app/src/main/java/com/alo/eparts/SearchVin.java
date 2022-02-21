package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alo.eparts.catalog.RetrofitAPI;
import com.alo.eparts.catalog.VinData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchVin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vin);
        Bundle bundle = getIntent().getExtras();
        String Vin = bundle.getString("searchVin");
        getSearchVin(Vin);

        Button openfilter =(Button)findViewById(R.id.openfilter);
        openfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchVin.this,oemcatelogfilteropen.class);
                intent.putExtra("searchVin",Vin);
                startActivity(intent);
            }
        });

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
                    TextView vinnumber = findViewById(R.id.vinnumber);
                    EditText searchvin = findViewById(R.id.searchvin);
                    searchvin.setText(Vin);
                    vinnumber.setText(adslist.get(0).getBusiness_name());

                    Toast.makeText(SearchVin.this, "data1111---"+adslist.get(0).getBusiness_name(), Toast.LENGTH_SHORT).show();



                }
            }

            @Override
            public void onFailure(Call<List<VinData>> call, Throwable t) {

            }






        });
    }
}