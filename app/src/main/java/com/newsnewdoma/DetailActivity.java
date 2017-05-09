package com.newsnewdoma;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.newsnewdoma.model.Events;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity {

    private static final String BASE_IMAGE_URL = "http://nevdoma.com/";
    TextView tvDetail;
    TextView tvAddress;
    ImageView ivDetailIMG;
    ArrayList<Events> events;
    Events e = new Events();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        tvDetail = (TextView) findViewById(R.id.tv_detail_title);
        tvAddress = (TextView) findViewById(R.id.tv_detail_address);
        ivDetailIMG = (ImageView) findViewById(R.id.iv_detail_event);

        /*String title = getIntent().getExtras().getString("event");
        String t = events.get(getIntent().getExtras().get("event").);*/
        int position = getIntent().getExtras().getInt("event");

        tvDetail.setText(events.get(position).getTitle());
        /*String address = getIntent().getExtras().getString("event_address");
        String img = getIntent().getExtras().getString("event_img");
        Context context = getApplicationContext();
        Picasso.with(context)
                .load(BASE_IMAGE_URL + img)
                //.fit()
                .into(ivDetailIMG);
        tvDetail.setText(title);
        tvAddress.setText(address);*/
    }
}
