package com.alo.eparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import static com.alo.eparts.R.id.vieworder;

public class Cricket extends Fragment {
    public Cricket() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cricket, container, false);
        //view order Clicked

        Button button;

        button = (Button) view.findViewById(vieworder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderDetails.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
