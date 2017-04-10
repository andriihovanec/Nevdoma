package com.newsnewdoma;


import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newsnewdoma.model.Example;
import com.newsnewdoma.model.ExampleData;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class ApiService {

    private static RequestInterface requestInterface;


    public interface RequestInterface {

        @GET("/api/events")
        Call<ArrayList<Example>> getJSON();
    }


    public static RequestInterface getRequestInterface() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nevdoma.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        requestInterface = retrofit.create(RequestInterface.class);

        return requestInterface;
    }
}
