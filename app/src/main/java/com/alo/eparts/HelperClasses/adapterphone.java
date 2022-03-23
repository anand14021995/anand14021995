package com.alo.eparts.HelperClasses;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alo.eparts.Football;
import com.alo.eparts.ManagePayment;
import com.alo.eparts.R;
import com.alo.eparts.cart;
import com.alo.eparts.myOrdersActivity;

import java.util.ArrayList;

public class adapterphone extends RecyclerView.Adapter<adapterphone.PhoneViewHold>  {

    ArrayList<phonehelper> phoneLocations;
    final private ListItemClickListener mOnClickListener;

    public adapterphone(ArrayList<phonehelper> phoneLocations, ListItemClickListener listener) {
        this.phoneLocations = phoneLocations;
        mOnClickListener = listener;
    }




    @NonNull

    @Override
    public PhoneViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemorder, parent, false);

        return new PhoneViewHold(view);

    }
    private static final String TAG = "";
    @Override
    public void onBindViewHolder(@NonNull PhoneViewHold holder, int position) {


        phonehelper phonehelper = phoneLocations.get(position);
        holder.image.setImageResource(phonehelper.getImage());
        holder.title.setText(phonehelper.getTitle());

        holder.image.setOnClickListener(new View.OnClickListener() {
            private Context activity;

            public void setActivity(Context activity) {
                this.activity = activity;
            }

            public Context getActivity() {
                return activity;
            }
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Calling time afterSubmitClicked called");
                Intent intent = new Intent(this.getActivity(), myOrdersActivity.class);
                activity.startActivity(intent);

            }




        });
        //holder.relativeLayout.setBackground(phonehelper.getgradient());


    }

    @Override
    public int getItemCount() {
        return phoneLocations.size();

    }

    public interface ListItemClickListener {
        void onphoneListClick(int clickedItemIndex);
    }

    public class PhoneViewHold extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView image;
        TextView title;
        RelativeLayout relativeLayout;


        public PhoneViewHold(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                private static final String TAG = "";
                private Context activity;

                public void setActivity(Context activity) {
                    this.activity = activity;
                }

                public Context getActivity() {
                    return activity;
                }

                @Override
                public void onClick(View v) {



                }
            });
            //hooks

            image = itemView.findViewById(R.id.phoneimage);
            title = itemView.findViewById(R.id.phonetitle);
            relativeLayout = itemView.findViewById(R.id.backgroundcolor);


        }

        @Override
        public void onClick(View v) {

            int clickedPosition = getAdapterPosition();
            mOnClickListener.onphoneListClick(clickedPosition);
            
        }
    }

}
