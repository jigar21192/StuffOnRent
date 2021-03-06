package com.example.viral.stuffonrent;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class MyAdapter extends FragmentPagerAdapter {

    Context myContext;
    int totalTabs;


    public MyAdapter(Context context, FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        myContext=context;
        this.totalTabs=tabCount;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Packages_Frag packages = new Packages_Frag();
                return packages;
            case 1:
                Furniture_Frag furnitures = new Furniture_Frag();
                return furnitures;
            case 2:
                Appliances_Frag appliances = new Appliances_Frag();
                return appliances;
            case 3:
                Vehicles_Frag vehicles = new Vehicles_Frag();
                return vehicles;
            case 4:
                Costume_Frag costume = new Costume_Frag();
                return costume;
            default:
        return null;
    }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
