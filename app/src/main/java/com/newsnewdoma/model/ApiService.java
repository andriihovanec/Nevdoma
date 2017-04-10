package com.newsnewdoma.model;


import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class ApiService {

    private static RequestInterface requestInterface;


    public interface RequestInterface {

        @GET("/api/events")
        Call<ExampleData> getJSON();
    }


    public static RequestInterface getRequestInterface() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nevdoma.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        requestInterface = retrofit.create(RequestInterface.class);

        return requestInterface;
    }
}
