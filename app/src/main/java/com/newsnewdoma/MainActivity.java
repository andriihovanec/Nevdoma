package com.newsnewdoma;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View backgroundimage = findViewById(R.id.activity_main);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(120);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/JunegullRegular.ttf");
        TextView tv_events = (TextView) findViewById(R.id.eventsList);
        tv_events.setTypeface(type);
        tv_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        TextView tv_films = (TextView) findViewById(R.id.films);
        tv_films.setTypeface(type);
        tv_films.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilmsActivity.class);
                startActivity(intent);
            }
        });

        TextView tv_add = (TextView) findViewById(R.id.add_event);
        tv_add.setTypeface(type);
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewEventActivity.class);
                startActivity(intent);
            }
        });

        TextView tv_about = (TextView) findViewById(R.id.about);
        tv_about.setTypeface(type);
        tv_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}
