package com.ilya.remindmeproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilya.remindmeproject.R;
import com.ilya.remindmeproject.adapter.RemindListAdapter;
import com.ilya.remindmeproject.dto.RemindDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilya on 25.05.2016.
 */
public class HistoryFragment extends AbstractTabFragment {

    public static final int LAYOUT = R.layout.fragment_history;

    private List<RemindDTO> data;
    private RemindListAdapter adapter;

    public static HistoryFragment getInstance(Context context, List<RemindDTO> data) {
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setData(data);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_history));

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycle_view);
        rv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RemindListAdapter(data);
        rv.setAdapter(adapter);

        return view;
    }



    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
    }

    public void refreshData(List<RemindDTO> data){
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
