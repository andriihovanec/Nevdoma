package com.newsnewdoma.adapter;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.newsnewdoma.fragment.SoonTaskFragment;
import com.newsnewdoma.fragment.TodayTaskFragment;
import com.newsnewdoma.fragment.TomorrowTaskFragment;


public class TabAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public TabAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new TodayTaskFragment();
            case 1:
                return new TomorrowTaskFragment();
            case 2:
                return new SoonTaskFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
