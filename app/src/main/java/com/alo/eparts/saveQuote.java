package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import android.view.View;

import android.widget.Button;

import android.widget.Toast;


public class saveQuote extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_quote);

        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner model = (Spinner) findViewById(R.id.model);
        Button button=(Button)findViewById(R.id.add);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        model.setOnItemSelectedListener(new CitiesSpinnerClass());
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Item 1");
        categories.add("Item 2");
        categories.add("Item 3");
        categories.add("Item 4");
        categories.add("Item 5");
        categories.add("Item 6");

        List<String> categoriesmodel = new ArrayList<String>();
        categoriesmodel.add("Item 1");
        categoriesmodel.add("Item 2");
        categoriesmodel.add("Item 3");
        categoriesmodel.add("Item 4");
        categoriesmodel.add("Item 5");
        categoriesmodel.add("Item 6");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        ArrayAdapter<String> dataAdaptermodel = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesmodel);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdaptermodel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        model.setAdapter(dataAdaptermodel);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpQuote popUpClass = new PopUpQuote();
                popUpClass.showPopupWindow(v);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    private class CitiesSpinnerClass implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
