package com.alo.eparts.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.alo.eparts.LoginActivity;
import com.alo.eparts.R;

import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    int[] orders;
    LayoutInflater mLayoutInflater;

    public ViewPagerAdapter(Context context, int[] orders) {
        this.context = context;
        this.orders = orders;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return orders.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // inflating the item.xml
        View itemView = mLayoutInflater.inflate(R.layout.itemorder, container, false);

        // referencing the image view from the item.xml file
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);
        Toast.makeText(context, "Hello Javatpoint"+orders.length, Toast.LENGTH_SHORT).show();
        GridLayout root =(GridLayout)itemView.findViewById(R.id.root);
        for(int i=0;i<=orders.length;i++)
        {
            imageView.setImageResource(orders[position]);
        }
        // setting the image in the imageView


        // Adding the View
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }
}