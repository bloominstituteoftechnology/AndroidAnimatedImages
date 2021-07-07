package com.example.patrickjmartin.andriodanimatedimages;

import android.support.annotation.Nullable;
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
                return AnimatedGIF.newInstance();
            case 1:
                return AnimatedDrawable.newInstance();
            case 2:
                return AnimatedButton.newInstance();
            default:
                return null;
        }
    }

    public ViewPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Animated Gif";
            case 1:
                return "Animated Drawable List";
            case 2:
                return "Animated Vector Drawable";
            default:
                return null;

        }
    }
}
