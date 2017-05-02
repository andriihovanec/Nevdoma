package com.newsnewdoma.adapter;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.newsnewdoma.fragment.SoonTaskFragment;
import com.newsnewdoma.fragment.TodayTaskFragment;
import com.newsnewdoma.fragment.TomorrowTaskFragment;
import com.newsnewdoma.model.Events;

import java.util.ArrayList;


public class TabAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;
    private ArrayList<Events> todayList;
    private ArrayList<Events> tomorrowList;
    private ArrayList<Events> soonList;

    public TabAdapter(FragmentManager fm, int numberOfTabs, ArrayList<Events> todayList, ArrayList<Events> tomorrowList, ArrayList<Events> soonList) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        this.todayList = todayList;
        this.tomorrowList = tomorrowList;
        this.soonList = soonList;
    }

    @Override
    public Fragment getItem(int i) {

        /*switch (i) {
            case 0:
                return new TodayTaskFragment(todayList);
            case 1:
                return new TomorrowTaskFragment(tomorrowList);
            case 2:
                return new SoonTaskFragment(soonList);
            default:
                return null;
        }*/

        if (i == 0) {
            return new TodayTaskFragment(todayList);
        } else if (i == 1) {
            return new TomorrowTaskFragment(tomorrowList);
        } else {
            return new SoonTaskFragment(soonList);
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
