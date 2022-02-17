package com.alo.eparts;

import android.app.Activity;
import android.app.Notification;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class CustomFragment extends Fragment {

    public static Fragment newInstance(Activity context, int position, float scale) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putFloat("scale", scale);
        return Fragment.instantiate(context, CustomFragment.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.item_slide, container, false);

        int position = this.getArguments().getInt("position");
        TextView textView = (TextView) linearLayout.findViewById(R.id.item_text);
        if(position==0)
        {
            textView.setText("Gold");
        }else if(position==1)
        {
            textView.setText("Silver");
        }else if(position==2)
        {
            textView.setText("Platinum");
        }

        Button Upgrade = (Button) linearLayout.findViewById(R.id.Upgrade);
        Upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpConfirm popUpClass = new PopUpConfirm();
                popUpClass.showPopupWindow(v);
            }
        });
        CustomLinearLayout root = (CustomLinearLayout) linearLayout.findViewById(R.id.item_root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return linearLayout;



    }




}