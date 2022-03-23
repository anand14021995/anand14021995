package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class profileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ImageView popupButton = findViewById(R.id.buttonPopup);
        popupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PopUpClass popUpClass = new PopUpClass();
                popUpClass.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                popUpClass.showPopupWindow(v);
            }
        });
    }
}