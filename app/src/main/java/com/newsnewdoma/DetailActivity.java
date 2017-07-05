package com.newsnewdoma;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.newsnewdoma.model.Events;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity {

    private static final String BASE_IMAGE_URL = "http://nevdoma.com/";
    @BindView(R.id.iv_detail_event)
    ImageView ivDetailIMG;
    @BindView(R.id.tv_detail_title)
    TextView tvTitle;
    @BindView(R.id.tv_detail_address)
    TextView tvCity;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_description)
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Events events = getIntent().getParcelableExtra("Events");

        Context context = getApplicationContext();
        Picasso.with(context)
                .load(BASE_IMAGE_URL + events.getImageUrl())
                .into(ivDetailIMG);

        tvTitle.setText(events.getTitle());
        tvCity.setText(events.getAddress().getApartment() + ", " +
                events.getAddress().getCity() + ", " +
                events.getAddress().getStreet() + " " +
                events.getAddress().getBuildingNumber());
        if (events.getPrice() != null) {
            tvPrice.setText(events.getPrice());
        } else {
            tvPrice.setText("ціна не вказана");
        }
        tvDescription.setText(events.getDescription());

    }
}
