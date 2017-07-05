package com.newsnewdoma.fragment;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newsnewdoma.R;
import com.newsnewdoma.adapter.DataAdapter;
import com.newsnewdoma.model.Events;

import java.util.ArrayList;


public class TodayTaskFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private DataAdapter adapter;
    private ArrayList<Events> todayList;
    private TextView tvEmpty;


    public TodayTaskFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public TodayTaskFragment(ArrayList<Events> todayList) {
        this.todayList = todayList;
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_today_task, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        tvEmpty = (TextView) rootView.findViewById(R.id.today_events_empty);

        adapter = new DataAdapter(getContext(), todayList);

        if (todayList.isEmpty()) {
            tvEmpty.setText("Вибачте, на данний день подій немає");
        }
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
