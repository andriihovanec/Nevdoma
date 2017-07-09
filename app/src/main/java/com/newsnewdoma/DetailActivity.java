package com.newsnewdoma;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.newsnewdoma.model.Events;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity {

    private static final String BASE_IMAGE_URL = "http://nevdoma.com/";
    @BindView(R.id.iv_detail_event)
    ImageView ivDetailIMG;
    @BindView(R.id.tv_detail_title)
    TextView tvTitle;
    @BindView(R.id.tv_detail_address)
    TextView tvAddress;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.price_icon)
    TextView priceIcon;
    @BindView(R.id.address_icon)
    TextView addressIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );
        priceIcon.setTypeface(font);
        addressIcon.setTypeface(font);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //add fab
        final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionA.setTitle("Action A clicked");
            }
        });

        Events events = getIntent().getParcelableExtra("Events");

        Date date = new Date(events.getWhenDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        Context context = getApplicationContext();
        Picasso.with(context)
                .load(BASE_IMAGE_URL + events.getImageUrl())
                .into(ivDetailIMG);

        tvTitle.setText(events.getTitle());
        tvAddress.setTypeface(font);
        tvAddress.setText(events.getAddress().getApartment() + ", " +
                events.getAddress().getCity() + ", " +
                events.getAddress().getStreet() + " " +
                events.getAddress().getBuildingNumber());
        tvTime.setText(simpleDateFormat.format(date));
        if (events.getPrice() != null) {
            tvPrice.setText(events.getPrice() + " ₴");
        }

        tvDescription.setText(events.getDescription());

    }
}
