package com.example.viral.stuffonrent;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPager viewPagerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        viewPagerImage=findViewById(R.id.viewpagerimage);

        tabLayout.addTab(tabLayout.newTab().setText("Packages"));
        tabLayout.addTab(tabLayout.newTab().setText("Furnitures"));
        tabLayout.addTab(tabLayout.newTab().setText("Appliances"));
        tabLayout.addTab(tabLayout.newTab().setText("Vehicles"));
        tabLayout.addTab(tabLayout.newTab().setText("Costume"));
       // tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        ImageAdapter adapterView = new ImageAdapter(this);
        viewPagerImage.setAdapter(adapterView);

        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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