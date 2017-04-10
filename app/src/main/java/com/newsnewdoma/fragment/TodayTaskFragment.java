package com.newsnewdoma.fragment;


import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.newsnewdoma.R;
import com.newsnewdoma.adapter.DataAdapter;
import com.newsnewdoma.model.ApiService;
import com.newsnewdoma.model.Events;
import com.newsnewdoma.model.Example;
import com.newsnewdoma.model.JSONResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TodayTaskFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Example> data;
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
//        loadJSON();

        return rootView;
    }

//    private void loadJSON(){
//
//        Call<List<Example>> call = ApiService.getRequestInterface().getJSON();
//        call.enqueue();
//        call.enqueue(new Callback<Example>() {
//            @Override
//            public void onResponse(Call<Example> call, Response<Example> response) {
//                if (response.isSuccessful()) {
//                    Example example = response.body();
//                    data = new ArrayList<>(Arrays.asList(example));
//                    adapter = new DataAdapter(data);
//                    recyclerView.setAdapter(adapter);
//                } else {
//                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<Example> call, Throwable t) {
//                Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
//            }
//        });
//    }

}
