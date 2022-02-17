package com.alo.eparts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alo.eparts.catalog.RecyclerData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    // creating a variable for our array list and context.
    private ArrayList<RecyclerData> courseDataArrayList;
    private Context mcontext;

    // creating a constructor class.
    public RecyclerViewAdapter(ArrayList<RecyclerData> recyclerDataArrayList, Context mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;

    }



    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview from our modal class.
        RecyclerData modal = courseDataArrayList.get(position);
        holder.courseNameTV.setText(modal.getCourseName());
       /* holder.courseTracksTV.setText(modal.getCourseTracks());
        holder.courseModeTV.setText(modal.getCourseMode());
        Picasso.with(mcontext).load(modal.getCourseimg()).into(holder.courseIV);*/
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }



    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {
        // creating variables for our views.
        //private TextView courseNameTV, courseModeTV, courseTracksTV;
        //private ImageView courseIV;
        private Button courseNameTV;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            /*courseModeTV = itemView.findViewById(R.id.idTVBatch);
            courseTracksTV = itemView.findViewById(R.id.idTVTracks);*/
            /*courseIV = itemView.findViewById(R.id.idIVCourse);*/


        }




    }

}
