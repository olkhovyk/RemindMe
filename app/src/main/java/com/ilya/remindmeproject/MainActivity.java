package com.ilya.remindmeproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ilya.remindmeproject.adapter.TabFragmentAdapter;
import com.ilya.remindmeproject.dto.RemindDTO;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilya on 23.05.2016.
 */
public class MainActivity extends AppCompatActivity {
    public static final int LAYOUT = R.layout.activity_main;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private TabFragmentAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);


        initToolbar();
        initNavigationView();
        initTabs();


    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }


    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new TabFragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        new RemindMeTask().execute();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.view_navigation_open, R.string.view_navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                    switch (item.getItemId()){
                        case R.id.actionNotificationItem:
                            showNotificationTab();
                    }
                return true;
            }
        });
    }

    private void showNotificationTab(){
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }

    private class RemindMeTask extends AsyncTask<Void, Void, RemindDTO>{

        @Override
        protected RemindDTO doInBackground(Void... params) {
            RestTemplate template = new RestTemplate();
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            return template.getForObject(Constants.URL.GET_REMIND_ITEM, RemindDTO.class);
        }

        @Override
        protected void onPostExecute(RemindDTO remindDTO) {
            List<RemindDTO> list = new ArrayList<>();
            list.add(remindDTO);
            adapter.setData(list);
        }
    }
}
