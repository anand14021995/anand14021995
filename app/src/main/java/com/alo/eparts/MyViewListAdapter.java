package com.alo.eparts;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewListAdapter extends RecyclerView.Adapter<MyViewListAdapter.ViewHolder>{
    private MyViewListData[] listdata;
    // RecyclerView recyclerView;
    public MyViewListAdapter(MyViewListData[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_viewproducts, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyViewListData MyViewListData = listdata[position];
        holder.textView.setText(listdata[position].getDescription());

        holder.viewproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),BuyPartsStockorder.class);
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public LinearLayout LinearLayout;
        public Button viewproducts;
        public ViewHolder(View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.title);
            LinearLayout = (LinearLayout)itemView.findViewById(R.id.relativeLayout);
            viewproducts = (Button)itemView.findViewById(R.id.viewproducts);
        }
    }
}
