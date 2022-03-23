package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alo.eparts.catalog.BrandData;
import com.alo.eparts.catalog.RetrofitAPI;
import com.alo.eparts.ui.ModelData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Manageunavailabilityadd extends AppCompatActivity implements AdapterView.OnItemClickListener{

    AutoCompleteTextView autocompleteTV;

    private ArrayList<BrandData> BrandDataArrayList;
    private ArrayList<ModelData> ModelDataArratList;
    List<String> codes = new ArrayList<String>();
    List<String> codesid = new ArrayList<String>();
    List<String> model =new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manageunavailabilityadd);
        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(v);
            }
        });

        getBrandData();
    }

    public void showPopupWindow(final View view)
    {
        //Create a View object yourself through inflater
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.partsrequestupdate, null);
        //Specify the length and width through constants
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        //Make Inactive Items Outside Of PopupWindow
        boolean focusable = true;
        //Create a window with our parameters
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        //Initialize the elements of our window, install the handler

        TextView test2 = popupView.findViewById(R.id.itemid);
        Button buttonEdit = popupView.findViewById(R.id.add);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //As an example, display the message
                Toast.makeText(view.getContext(), "Wow, popup action button", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                //Intent intent = new Intent(partsrequestedit.this, OrderDetails.class);
                //startActivity(intent);
            }
        });



        //Handler for clicking on the inactive zone of the window

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //Close the window when clicked
                popupWindow.dismiss();
                return true;
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
                    ArrayAdapter<String> adapterTime = new ArrayAdapter<>(Manageunavailabilityadd.this, R.layout.dropdownbrand_item, codes);
                    AutoCompleteTextView autocompleteTV=findViewById(R.id.autoCompleteTextView);
                    autocompleteTV.setAdapter(adapterTime);

                    autocompleteTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String item = BrandDataArrayList.get(position).getId();
                            getModelList(item);
                            //Toast.makeText(manageQuoteEdit.this, "Selected Item is: \t" + item, Toast.LENGTH_LONG).show();
                            Toast.makeText(Manageunavailabilityadd.this, "" + BrandDataArrayList.get(position).getId(), Toast.LENGTH_SHORT).show();

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
                    ArrayAdapter<String> adapterTime = new ArrayAdapter<>(Manageunavailabilityadd.this, R.layout.dropdownmodel_item, model);
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