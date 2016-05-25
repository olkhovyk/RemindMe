package com.ilya.remindmeproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilya.remindmeproject.R;

/**
 * Created by ilya on 25.05.2016.
 */
public class TodoFragment extends AbstractTabFragment {
    public static final int LAYOUT = R.layout.fragment_example;


    public static TodoFragment getInstance(Context context) {
        Bundle args = new Bundle();
        TodoFragment fragment = new TodoFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_todo));

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        return view;
    }



    public void setContext(Context context) {
        this.context = context;
    }


}
