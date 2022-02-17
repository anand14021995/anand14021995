package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class manageQuotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_quotes);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MainListAdapter mainListAdapter = new MainListAdapter(getMealList(),getQuote());
        recyclerView.setAdapter(mainListAdapter);
    }
    public List<String> getMealList() {
        List<String> mealList = new ArrayList<>();
        mealList.add("Customer Name");

        return mealList;
    }

    public List<String> getQuote() {
        List<String> quoteList = new ArrayList<>();
        quoteList.add(":  765432");
        return quoteList;
    }
}