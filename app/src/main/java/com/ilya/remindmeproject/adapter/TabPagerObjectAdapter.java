package com.ilya.remindmeproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ilya.remindmeproject.fragment.ExampleFragment;

/**
 * Created by ilya on 24.05.2016.
 */
public class TabPagerObjectAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public TabPagerObjectAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[]{
                "Tab1",
                "Напоминания",
                "Tab2"
        };
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ExampleFragment.getInstance();
            case 1:
                return ExampleFragment.getInstance();
            case 2:
                return ExampleFragment.getInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
