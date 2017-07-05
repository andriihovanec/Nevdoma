package com.newsnewdoma.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newsnewdoma.DetailActivity;
import com.newsnewdoma.R;
import com.newsnewdoma.model.Events;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private static final String BASE_IMAGE_URL = "http://nevdoma.com/";

    private Context context;

    private ArrayList<Events> eventsList;

    public DataAdapter(Context context, ArrayList<Events> eventsList) {
        this.context = context;
        this.eventsList = eventsList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Events events = eventsList.get(position);
        holder.bindEvents(events);
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.tv_whenDate)
        TextView whenDate;
        @BindView(R.id.tv_address)
        TextView address;
        @BindView(R.id.iv_event)
        ImageView image;

        Events events;

        public void bindEvents(Events events) {
            this.events = events;
            Date date = new Date(events.getWhenDate());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

            title.setText(events.getTitle());
            whenDate.setText(simpleDateFormat.format(date));
            address.setText(events.getAddress().getCity() + ", " + events.getAddress().getStreet() + " " + events.getAddress().getBuildingNumber());

            Picasso.with(context)
                    .load(BASE_IMAGE_URL + events.getImageUrl())
                    .into(image);
        }

        private ViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.click_conteiner)
        void clickItem() {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("Events", events);
            context.startActivity(intent);


        }
    }
}
