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
import android.widget.Toast;

import com.newsnewdoma.ApiService;
import com.newsnewdoma.R;
import com.newsnewdoma.adapter.DataAdapter;
import com.newsnewdoma.model.Events;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TomorrowTaskFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private DataAdapter adapter;
    ArrayList<Events> tomorrowList;

    public TomorrowTaskFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public TomorrowTaskFragment(ArrayList<Events> tomorrowList) {
        this.tomorrowList = tomorrowList;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_today_task, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new DataAdapter(getActivity(), tomorrowList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
