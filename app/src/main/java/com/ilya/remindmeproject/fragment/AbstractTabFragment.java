package com.ilya.remindmeproject.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by ilya on 25.05.2016.
 */
public class AbstractTabFragment extends Fragment {

    private String title;
    protected Context context;
    protected View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
