package com.alo.eparts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> shoppingList;
    private List<String> quoteList;
    public MainListAdapter(List<String> shoppingList,List<String> quoteList) {
        this.shoppingList = shoppingList;
        this.quoteList = quoteList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_main, parent, false);
        return new MainListItem(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainListItem mainListItem = (MainListItem) holder;
        mainListItem.mealTV.setText(shoppingList.get(position));
        mainListItem.quoteTV.setText(quoteList.get(position));
        mainListItem.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "INFO CLICKED", Toast.LENGTH_SHORT).show();
            }
        });
        mainListItem.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "EDIT CLICKED", Toast.LENGTH_SHORT).show();
                Context context = null;
                Intent myactivity = new Intent(v.getContext(), partsrequestedit.class);
                v.getContext().startActivity(myactivity);

            }
        });
    }
    @Override
    public int getItemCount() {
        return shoppingList.size();
    }
    public static class MainListItem extends RecyclerView.ViewHolder {

        protected TextView mealTV,quoteTV;
        protected ImageButton infoButton;
        protected ImageButton editButton;

        protected MainListItem(View itemView) {
            super(itemView);
            mealTV = itemView.findViewById(R.id.meal_tv);
            quoteTV = itemView.findViewById(R.id.quote);
            infoButton = itemView.findViewById(R.id.info_button);
            editButton= itemView.findViewById(R.id.edit_button);
        }
    }
}
