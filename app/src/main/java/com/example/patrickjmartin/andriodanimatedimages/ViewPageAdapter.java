package com.example.patrickjmartin.andriodanimatedimages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;

public class ViewPageAdapter extends FragmentPagerAdapter {
    private final HashMap<String, Fragment> fragments = new HashMap<>();
    private static int NUM_ITEMS = 3;

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    public ViewPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
