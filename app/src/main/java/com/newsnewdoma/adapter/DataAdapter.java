package com.newsnewdoma.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newsnewdoma.R;
import com.newsnewdoma.model.Events;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Events> events;
    public DataAdapter(ArrayList<Events> events) {
        this.events = events;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.tv_title.setText(events.get(position).getTitle());
        holder.tv_description.setText(events.get(position).getDescription());
        holder.tv_address.setText(events.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title, tv_description, tv_address;
        public ViewHolder(View view) {
            super(view);

            tv_title = (TextView)view.findViewById(R.id.tv_name);
            tv_description = (TextView)view.findViewById(R.id.tv_version);
            tv_address = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }
}
