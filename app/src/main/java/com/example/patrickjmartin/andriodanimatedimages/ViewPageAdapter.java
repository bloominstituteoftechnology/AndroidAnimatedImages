package com.example.patrickjmartin.andriodanimatedimages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return AnimatedGIF.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FirstFragment.newInstance(1, "Page # 2");
            case 2: // Fragment # 1 - This will show SecondFragment
                return SecondFragment.newInstance(2, "Page # 3");
            default:
                return null;
        }
    }

    public ViewPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void addFragment(String key, Fragment value) {
        fragments.put(key, value);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
