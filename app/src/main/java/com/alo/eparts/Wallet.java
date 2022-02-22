package com.alo.eparts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import static com.alo.eparts.R.id.vieworder;

public class Wallet extends Fragment {


    public Wallet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);

        Button addamount;
        addamount = (Button) view.findViewById(R.id.addamount);
        addamount.setOnClickListener(new View.OnClickListener() {
         @Override
           public void onClick(View v) {
              Intent intent = new Intent(getActivity(), walletpayementadd.class);
               startActivity(intent);
           }
       });
        return view;
    }
}
