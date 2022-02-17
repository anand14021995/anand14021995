package com.alo.eparts;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.alo.eparts.recycler.notificationActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.alo.eparts.R.id.vieworder;

public class Football extends Fragment{


    public Football() {
        // Required empty public constructor
    }
    final Calendar myCalendar= Calendar.getInstance();
    TextView tvDate;
    EditText btPickDate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_football, container, false);

        Button button;
        ImageView imageView,sortView;

        button = (Button) view.findViewById(vieworder);
        imageView = (ImageView) view.findViewById(R.id.filter);
        sortView = (ImageView)view.findViewById(R.id.sort);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), OrderDetails.class);
                startActivity(intent);
            }
        });

//        dateofbirth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatePicker datePicker = MaterialDatePicker.Builder.datePicker()
//                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
//                        .setTitleText("Add date of birth").build()
//
//
//                datePicker.show(supportFragmentManager, datePicker.toString());
//            }
//        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });

        sortView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortshowBottomSheetDialog();
            }
        });



        return view;
    }

    private void showBottomSheetDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(),R.style.BottomSheetDialog);
        bottomSheetDialog.setContentView(R.layout.activity_filterview);
        bottomSheetDialog.show();
    }


    private void sortshowBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(),R.style.BottomSheetDialog);
        bottomSheetDialog.setContentView(R.layout.activity_sorts);
        bottomSheetDialog.show();
    }


}
