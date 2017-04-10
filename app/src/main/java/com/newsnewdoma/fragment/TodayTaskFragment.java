package com.newsnewdoma.fragment;


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
import com.newsnewdoma.model.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TodayTaskFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<List<Example>> data;
    RecyclerView.LayoutManager layoutManager;
    private DataAdapter adapter;


    public TodayTaskFragment() {
        // Required empty public constructor
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
        loadJSON();

        return rootView;
    }

    private void loadJSON() {

        Call<ArrayList<Example>> call = ApiService.getRequestInterface().getJSON();
        call.enqueue(new Callback<ArrayList<Example>>() {
            @Override
            public void onResponse(Call<ArrayList<Example>> call, Response<ArrayList<Example>> response) {

                if (response.isSuccessful()) {
                    ArrayList<Example> example = response.body();
                    adapter = new DataAdapter(example);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Error response message", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Example>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failure response", Toast.LENGTH_LONG).show();
            }
        });
    }
}
