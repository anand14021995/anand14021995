package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class proceedSavetoQuote extends AppCompatActivity {

    ExpandableListView expandableListView,expandableListViewservice;
    ExpandableListAdapter expandableListAdapter,expandableListAdapterservice;
    List<String> expandableListTitle;
    List<String> expandableListTitleService;
    HashMap<String, List<String>> expandableListDetail;
    HashMap<String, List<String>> expandableListDetailservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed_saveto_quote);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewproduct);
        expandableListDetail = ExpandableListDataPumpProduct.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapterProductView(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        //service
        expandableListViewservice = (ExpandableListView) findViewById(R.id.expandableListViewservice);
        expandableListDetailservice = ExpandableListDataPumpProduct.getDataService();
        expandableListTitleService = new ArrayList<String>(expandableListDetailservice.keySet());
        expandableListAdapterservice = new CustomExpandableListAdapterServiceView(this, expandableListTitleService, expandableListDetailservice);
        expandableListViewservice.setAdapter(expandableListAdapterservice);
        /*Service*/
        expandableListViewservice.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitleService.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        expandableListViewservice.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitleService.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });
        expandableListViewservice.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitleService.get(groupPosition)
                                + " -> "
                                + expandableListDetailservice.get(
                                expandableListTitleService.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
        /*Product*/
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

        /*Proceed to buy*/
        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(proceedSavetoQuote.this,manageQuotes.class);
                startActivity(intent);
            }
        });
    }


}