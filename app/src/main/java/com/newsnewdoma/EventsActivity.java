package com.newsnewdoma;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.newsnewdoma.adapter.TabAdapter;
import com.newsnewdoma.model.Events;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    private ViewPager viewPager;

    private TabAdapter tabAdapter;
    private ArrayList<Events> todayList = new ArrayList<>();
    private ArrayList<Events> tomorrowList = new ArrayList<>();
    private ArrayList<Events> soonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        fragmentManager = getFragmentManager();

        setUI();

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tab);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.today_task));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tomorrow_task));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.soon_task));

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        Call<ArrayList<Events>> call = ApiService.getRequestInterface().getJSON();
        call.enqueue(new Callback<ArrayList<Events>>() {
            @Override
            public void onResponse(Call<ArrayList<Events>> call, Response<ArrayList<Events>> response) {

                if (response.isSuccessful()) {
                    ArrayList<Events> events = response.body();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date todayDate = new Date();

                    Date tomorrowDate = new Date();
                    Long time = tomorrowDate.getTime();
                    long anotherDate = +1;
                    time = time + (60*60*24*1000*anotherDate);
                    tomorrowDate = new Date(time);

                    for (int i = 0; i < events.size(); i++){
                        Date eventDate = new Date(events.get(i).getWhenDate());
                        if (simpleDateFormat.format(eventDate).equals(simpleDateFormat.format(todayDate))) {
                            todayList.add(events.get(i));
                        } else if (simpleDateFormat.format(eventDate).equals(simpleDateFormat.format(tomorrowDate))) {
                            tomorrowList.add(events.get(i));
                        } else {
                            soonList.add(events.get(i));
                        }
                    }
                    tabAdapter = new TabAdapter(fragmentManager, 3, todayList, tomorrowList, soonList);
                    viewPager.setAdapter(tabAdapter);
                    if (todayList.isEmpty()) {
                        viewPager.setCurrentItem(1);
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Events>> call, Throwable t) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }



        });
    }
}
