package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alo.eparts.recycler.notificationActivity;

public class BuypartsOrder extends AppCompatActivity {
    int minteger = 0;
    Button addtocart;
    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyparts_order);
        backIconImageView = findViewById(R.id.backIconImageView);
        propic = findViewById(R.id.propic);
        addtocart = findViewById(R.id.addtocart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PopUpClass popUpClass = new PopUpClass();
                showPopupWindow(v);
            }
        });
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuypartsOrder.this, notificationActivity.class);
                startActivity(intent);
            }
        });
        //MyorderClicked
        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuypartsOrder.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuypartsOrder.this, navigationbar.class);
                startActivity(intent);
            }
        });


    }
        public void increaseInteger(View v) {
            minteger = minteger + 1;
            display(minteger);

        }
        public void decreaseInteger(View v) {
            minteger = minteger - 1;
            display(minteger);
        }
        private void display(int number) {
            TextView displayInteger = (TextView) findViewById(
                    R.id.integer_number);
            displayInteger.setText("" + number);
        }

    public void showPopupWindow(final View view)
    {
        //Create a View object yourself through inflater
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.addtocartpopup, null);
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
        Button buttonEdit = popupView.findViewById(R.id.cartbtn);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //As an example, display the message
                Toast.makeText(view.getContext(), "Wow, popup action button", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                Intent intent = new Intent(BuypartsOrder.this, OrderDetails.class);
                startActivity(intent);
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

}