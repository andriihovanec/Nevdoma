package com.newsnewdoma.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.newsnewdoma.DetailActivity;
import com.newsnewdoma.MainActivity;
import com.newsnewdoma.R;
import com.newsnewdoma.fragment.DetailFragment;
import com.newsnewdoma.model.Events;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private static final String BASE_IMAGE_URL = "http://nevdoma.com/";

    private Context context;

    private ArrayList<Events> events;
    public DataAdapter(ArrayList<Events> events) {
        this.events = events;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.tv_title.setText(events.get(position).getTitle());

        Date date = new Date(events.get(position).getWhenDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        holder.tv_whenDate.setText(simpleDateFormat.format(date));

        holder.tv_address.setText(events
                .get(position).getAddress().getCity() + ", " + events
                .get(position).getAddress().getStreet() + " " + events
                .get(position).getAddress().getBuildingNumber());

        Context context = holder.iv_event.getContext();
        Picasso.with(context)
                .load(BASE_IMAGE_URL + events.get(position).getImageUrl())
                //.fit()
                .into(holder.iv_event);

    }

    @Override
    public int getItemCount() {
        return events.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title, tv_whenDate, tv_address;
        private ImageView iv_event;

        private ViewHolder(final View view) {
            super(view);
            context = view.getContext();

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("event", getAdapterPosition());
                    /*intent.putExtra("event", events.get(getAdapterPosition()).getTitle());
                    intent.putExtra("event_img", events.get(getAdapterPosition()).getImageUrl());
                    intent.putExtra("event_address", events.get(getAdapterPosition()).g.getAddress().getCity());*/
                    context.startActivity(intent);
                    Toast.makeText(v.getContext(),"clicked=" + getPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            tv_title = (TextView)view.findViewById(R.id.tv_title);
            tv_whenDate = (TextView)view.findViewById(R.id.tv_whenDate);
            tv_address = (TextView)view.findViewById(R.id.tv_address);
            iv_event = (ImageView)view.findViewById(R.id.iv_event);

        }
    }
}
