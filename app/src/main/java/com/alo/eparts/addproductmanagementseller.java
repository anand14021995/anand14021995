package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

public class addproductmanagementseller extends AppCompatActivity {

    ImageView btnScanBarcode;
    EditText btnTakePicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproductmanagementseller);
        initViews();
    }
    private void initViews() {
        btnTakePicture = findViewById(R.id.btnTakePicture);
        btnScanBarcode = findViewById(R.id.btnScanBarcode);
        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(addproductmanagementseller.this, PictureBarcodeActivity.class));
            }
        });
        btnScanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(addproductmanagementseller.this, ScannedBarcodeActivity.class));
            }
        });
    }


}