package com.ilya.remindmeproject.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ilya.remindmeproject.R;
import com.ilya.remindmeproject.dto.RemindDTO;
import com.ilya.remindmeproject.fragment.AbstractTabFragment;
import com.ilya.remindmeproject.fragment.BirthdayFragment;
import com.ilya.remindmeproject.fragment.HistoryFragment;
import com.ilya.remindmeproject.fragment.IdeasFragment;
import com.ilya.remindmeproject.fragment.TodoFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ilya on 24.05.2016.
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;
    private List<RemindDTO> data;
    private HistoryFragment historyFragment;

    public TabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.data = new ArrayList<>();
        initTabMap(context);
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }


    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    private void initTabMap(Context context) {
        tabs = new HashMap<>();
        historyFragment = HistoryFragment.getInstance(context, data);
        tabs.put(0, historyFragment);
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, TodoFragment.getInstance(context));
        tabs.put(3, BirthdayFragment.getInstance(context));
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
        historyFragment.refreshData(data);
    }
}
